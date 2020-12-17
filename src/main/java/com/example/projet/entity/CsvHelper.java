package com.example.projet.entity;

import com.example.projet.dao.PosteDao;
import com.example.projet.dao.SalleDao;
import com.example.projet.service.PosteService;
import com.example.projet.service.SalleService;
import org.apache.commons.csv.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

public class CsvHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"adresse_ip","adresse_mac","numero_salle"};
    private static final org.apache.logging.log4j.Logger l=  LogManager.getLogger(CsvHelper.class);

    @Autowired
    public static SalleDao salleDao;
    @Autowired
    public static PosteDao posteDao;
    @Autowired
    public static PosteService posteService;
    @Autowired
    public static SalleService salleService;
    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Poste> csvToTutorialsPoste(InputStream is) {



        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Poste> posteList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                Poste poste = new Poste(

                        csvRecord.get("adresse_mac"),
                        csvRecord.get("adresse_ip"),
                        Long.parseLong(csvRecord.get("numero_salle"))
                );

                posteList.add(poste);
            }
            return posteList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
    public static List<Salle> csvToTutorialsSalle(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Salle> salleList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            List<Long> allid = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {


                allid.add(Long.valueOf(csvRecord.get("numero_salle")));

            }
            HashSet hSetNumbers = new HashSet(allid);

            l.info(hSetNumbers);

            for (Object hSetNumber : hSetNumbers) {
                l.info(hSetNumber);
                Salle salle = new Salle(
                        Long.parseLong(String.valueOf(hSetNumber)),
                        String.valueOf(hSetNumber),
                        18
                );

                salleList.add(salle);
            }
            return salleList;
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
