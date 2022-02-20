package com.dwteam.repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvReader {
   private  List<String[]> list;

    public CsvReader() throws Exception {
        list = new ArrayList<>();
        readAllDataAtOnce("G:\\Java Project\\bcl\\src\\main\\resources\\info_csv\\Flights.csv");

    }

    public  void readAllDataAtOnce(String file) {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);
            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(date);
            for (String[] s : allData
            ) {
                if (s[0].equals(strDate)) {
                    list.add(s);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public List<String> readColumn(int i){
        List<String> l=new ArrayList<>();
        for (String[] s:list
             ) {
            l.add(s[i]);

        }
        return l;
    }
    public List<String[]> filterCity(String city){
        List<String[]> l=new ArrayList<>();
        for (String[] s:list
             ) {
            if(s[7].equals(city)){
                l.add(s);
            }

        }
        return l;
    }

    public List<String[]> getList() {
        return list;
    }
}
