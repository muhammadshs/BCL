package com.dwteam.repository;

import com.dwteam.model.Flight;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvReader {
    private List<Flight> list;
    private List<Flight> listFut;

    public CsvReader() throws Exception {
        list = new ArrayList<>();
        listFut = new ArrayList<>();
        //روش پیدا کردن فایل رو عوض کن
        readAllDataAtOnce("G:\\Java Project\\bcl\\src\\main\\resources\\info_csv\\Flights.csv");

    }

    public void readAllDataAtOnce(String file) {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            Flight flight;
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
                    flight = new Flight(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11]);
                    list.add(flight);
                    if (flight.getDepartureTime().getTime() >= date.getTime()) {
                        listFut.add(flight);
                    }
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Flight> filterAP(String aP) {
        List<Flight> l = new ArrayList<>();
        for (Flight f : list
        ) {
            if (f.getDepartureAirport().equals(aP)) {
                l.add(f);
            }

        }
        return l;
    }

    public List<Flight> filterAPFut(String aP) {
        List<Flight> l = new ArrayList<>();
        for (Flight f : listFut
        ) {
            if (f.getDepartureAirport().equals(aP)) {
                l.add(f);
            }

        }
        return l;
    }

    public List<Flight> getList() {
        return list;
    }

    public List<Flight> getListFut() {
        return listFut;
    }
}
