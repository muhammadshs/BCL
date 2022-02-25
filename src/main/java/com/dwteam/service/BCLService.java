package com.dwteam.service;

import com.dwteam.ListPro;
import com.dwteam.model.Flight;
import com.dwteam.repository.CsvReader;

import java.util.Date;
import java.util.List;

public class BCLService {
    CsvReader csvReader;
    List<Flight> list;

    public BCLService() {
        try {
            csvReader = new CsvReader();
            list = csvReader.getListFut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListPro<String, Integer> getFlightSum(String departureAirport) {
        Date date = new Date();
        Long time = date.getTime() + (30 * 60 * 1000);
        List<Flight> listF = csvReader.filterAPFut(departureAirport);
        ListPro<String, Integer> listPro = new ListPro<>();
        List<Flight> listY=csvReader.filterAPYes(departureAirport);
        for (Flight f : listF
        ) {
            if (f.getDepartureAirport().equals(departureAirport)) {
               //  System.out.println(departureAirport);
                String s = f.getDepartureAirport() + "->" + f.getArrivalAirport() + " " + f.getDepartureTimeWithDelayString();

                if (f.getDepartureTimeWithDelay().getTime() <= time) {
                    listPro.add(s, 1);
                    continue;
                }
                listPro.add(s, 0);
            }

        }
        for (Flight f : listY
        ) {
            if (f.getDepartureAirport().equals(departureAirport)) {
                // System.out.println(f.toString());
                String s = f.getDepartureAirport() + "->" + f.getArrivalAirport() + " " + f.getDepartureTimeWithDelayString();

                if (f.getDepartureTimeWithDelay().getTime() <= time) {
                    listPro.add(s, 1);
                    continue;
                }
                listPro.add(s, 0);
            }

        }
        return listPro;
    }

    public ListPro<String, Integer> getFlightDelay() {
        Date date = new Date();
        Long time = date.getTime() + (30 * 60 * 1000);
        List<Flight> yesList=csvReader.getListYes();
        List<Flight> listF = csvReader.getListFut();
        ListPro<String, Integer> listPro = new ListPro<>();
        Long time2=date.getTime()-(24*60*6000);
        date=new Date(time2);
        for (Flight f:listF
        ) {

            if (f.getDelay() >= 30){
                // System.out.println(f.toString());
                String s = f.getDepartureAirport() + "->" + f.getArrivalAirport() + " " + f.getDepartureTimeWithDelayString();

                if (f.getDepartureTimeWithDelay().getTime() <= time) {
                    listPro.add(s, 1);

                }
                else {
                    listPro.add(s, 0);
                }

                // System.out.println(f.toString());


            }

        }
        for (Flight fy:yesList
             ) {
            if (fy.getDelay() >= 30) {
                String s2 = fy.getDepartureAirport() + "->" + fy.getArrivalAirport() + " " + fy.getDepartureTimeWithDelayString();

                if (fy.getDepartureTimeWithDelay().getTime() <= time) {
                    listPro.add(s2, 1);

                } else {
                    listPro.add(s2, 0);
                }
            }
        }

        return listPro;
    }

}
