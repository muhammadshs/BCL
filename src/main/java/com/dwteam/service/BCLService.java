package com.dwteam.service;

import com.dwteam.ListPro;
import com.dwteam.model.Flight;
import com.dwteam.repository.CsvReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BCLService {
    CsvReader csvReader;
    List<Flight> list;

    public BCLService() {
        try {
            csvReader =new CsvReader();
            list=csvReader.getListFut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<String> getFlightSum(String departureAirport){

         List<Flight> listF=csvReader.filterAPFut(departureAirport);
        List<String> stringList=new ArrayList<>();
        for (Flight f:listF
             ) {
            String s=f.getDepartureAirport()+"->"+f.getArrivalAirport()+" "+f.getDepartureTimeString();
            stringList.add(s);
        }
        return stringList;
    }
    public ListPro<String,Integer> getFlightDelay(){
        Date date=new Date();
        Long time=date.getTime()+(30*60*1000);
        List<Flight> listF=csvReader.getListFut();
        ListPro<String , Integer> listPro = new ListPro<>();

        for (Flight f:listF
             ) {
            if(f.getDelay()>30){
               // System.out.println(f.toString());
                String s=f.getDepartureAirport()+"->"+f.getArrivalAirport()+" "+f.getDepartureTimeString();

                if(f.getDepartureTime().getTime()<=time){
                    listPro.add(s,1);
                    continue;
                }
                listPro.add(s,0);
            }

        }
        return listPro;
    }

}
