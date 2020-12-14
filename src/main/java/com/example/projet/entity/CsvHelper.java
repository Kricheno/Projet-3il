package com.example.projet.entity;

import com.example.projet.dao.SalleDao;
import com.example.projet.service.PosteService;
import org.apache.commons.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CsvHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"adresse_ip","adresse_mac","id_salle"};

    @Autowired
    public static SalleDao salleDao;
    @Autowired
    public static PosteService posteService;
    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Poste> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Poste> posteList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            posteService.deleteAll();
            for (CSVRecord csvRecord : csvRecords) {
                //Optional<Salle> salle = salleDao.findById();
                Poste poste = new Poste(

                        csvRecord.get("adresse_mac"),
                        csvRecord.get("adresse_ip"),
                        Long.parseLong(csvRecord.get("id_salle"))

                );

                posteList.add(poste);
            }

            return posteList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<Poste> posteList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Poste poste : posteList) {
                List<String> data = Arrays.asList(
                        String.valueOf(poste.getSalle().getId_Salle()),
                        poste.getAdresse_Mac(),
                        poste.getAdresse_IP()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
