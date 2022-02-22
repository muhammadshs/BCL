package com.dwteam.controller;

import com.dwteam.service.BCLService;
import com.dwteam.ui.FlightListUi;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class BCLController extends MouseAdapter {
    private static Map<String, FlightListUi> mapFlightUi = new HashMap<>();
    private BCLService bclService;

    public BCLController() {
        bclService = new BCLService();
       /* mapFlightUi.put("LVS", new FlightListUi("List of Today Departure Flights LVS", bclService.getFlightSum("LVS")));
        mapFlightUi.put("JNB", new FlightListUi("List of Today Departure Flights JNB", bclService.getFlightSum("JNB")));
        mapFlightUi.put("BKK", new FlightListUi("List of Today Departure Flights BKK", bclService.getFlightSum("BKK")));
        mapFlightUi.put("DUB", new FlightListUi("List of Today Departure Flights DUB", bclService.getFlightSum("DUB")));
        mapFlightUi.put("LIS", new FlightListUi("List of Today Departure Flights LIS", bclService.getFlightSum("LIS")));
        mapFlightUi.put("ATH", new FlightListUi("List of Today Departure Flights ATH", bclService.getFlightSum("ATH")));
        mapFlightUi.put("DFW", new FlightListUi("List of Today Departure Flights DFW", bclService.getFlightSum("DFW")));
        mapFlightUi.put("BCL", new FlightListUi("List of Today Departure Flights BCL", bclService.getFlightSum("BCL")));
        mapFlightUi.put("SYD", new FlightListUi("List of Today Departure Flights SYD", bclService.getFlightSum("SYD")));
        mapFlightUi.put("DEL", new FlightListUi("List of Today Departure Flights DEL", bclService.getFlightSum("DEL")));
        mapFlightUi.put("HND", new FlightListUi("List of Today Departure Flights HND", bclService.getFlightSum("HND")));
        mapFlightUi.put("HKG", new FlightListUi("List of Today Departure Flights HKG", bclService.getFlightSum("HKG")));
        mapFlightUi.put("DXB", new FlightListUi("List of Today Departure Flights DXB", bclService.getFlightSum("DXB")));
        mapFlightUi.put("AMS", new FlightListUi("List of Today Departure Flights AMS", bclService.getFlightSum("AMS")));
        mapFlightUi.put("MAD", new FlightListUi("List of Today Departure Flights MAD", bclService.getFlightSum("MAD")));
        mapFlightUi.put("JFK", new FlightListUi("List of Today Departure Flights JFK", bclService.getFlightSum("JFK")));
        mapFlightUi.put("FCO", new FlightListUi("List of Today Departure Flights FCO", bclService.getFlightSum("FCO")));
        mapFlightUi.put("GRU", new FlightListUi("List of Today Departure Flights GRU", bclService.getFlightSum("GRU")));
        mapFlightUi.put("YYZ", new FlightListUi("List of Today Departure Flights YYZ", bclService.getFlightSum("YYZ")));
        mapFlightUi.put("MEX", new FlightListUi("List of Today Departure Flights MEX", bclService.getFlightSum("MEX")));
        mapFlightUi.put("ARN", new FlightListUi("List of Today Departure Flights ARN", bclService.getFlightSum("ARN")));
        mapFlightUi.put("CAI", new FlightListUi("List of Today Departure Flights CAI", bclService.getFlightSum("CAI")));
        mapFlightUi.put("LOS", new FlightListUi("List of Today Departure Flights LOS", bclService.getFlightSum("LOS")));
        mapFlightUi.put("SVO", new FlightListUi("List of Today Departure Flights SVO", bclService.getFlightSum("SVO")));
        mapFlightUi.put("RAK", new FlightListUi("List of Today Departure Flights RAK", bclService.getFlightSum("RAK")));*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getComponent();
//        switch (jLabel.getText()) {
//            case ""
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getComponent();

    }
}
