package com.example.projet.service;

import com.example.projet.dao.PosteDao;
import com.example.projet.entity.CsvHelper;
import com.example.projet.entity.Poste;
import org.apache.commons.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    PosteDao repository;

    public void save(MultipartFile file) {
        try {
            List<Poste> posteList = CsvHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(posteList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Poste> posteList = repository.findAll();

        ByteArrayInputStream in = CsvHelper.tutorialsToCSV(posteList);
        return in;
    }

    public List<Poste> getAllTutorials() {
        return repository.findAll();
    }

}
