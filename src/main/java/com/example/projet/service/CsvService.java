package com.example.projet.service;

import com.example.projet.dao.PosteDao;
import com.example.projet.dao.SalleDao;
import com.example.projet.entity.CsvHelper;
import com.example.projet.entity.Poste;
import com.example.projet.entity.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    PosteDao posteDao;
    @Autowired
    SalleDao salleDao;

    public void save(MultipartFile file) {
        try {
            List<Salle> salleList = CsvHelper.csvToTutorialsSalle(file.getInputStream());
            List<Poste> posteList = CsvHelper.csvToTutorialsPoste(file.getInputStream());

            posteDao.saveAll(posteList);
            salleDao.saveAll(salleList);

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Poste> posteList = posteDao.findAll();

        ByteArrayInputStream in = CsvHelper.tutorialsToCSV(posteList);
        return in;
    }

}
