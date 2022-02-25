package com.dwteam.controller;

import com.dwteam.service.BCLService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

public class BCLController extends MouseAdapter {
    private static Map<String, JScrollPane> mapFlightUi;
    private BCLService bclService;

    public BCLController(Map<String, JScrollPane> map) {
        bclService = new BCLService();
        mapFlightUi = map;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getComponent();
        // System.out.println("aa");
        switch (jLabel.getText()) {
            case "LVS":
                mapFlightUi.get("LVS").setVisible(true);
                break;
            case "JNB":
                mapFlightUi.get("JNB").setVisible(true);
                break;
            case "BKK":
                mapFlightUi.get("BKK").setVisible(true);

                break;
            case "DUB" :
                mapFlightUi.get("DUB").setVisible(true);
                break;
            case "LIS" :
                mapFlightUi.get("LIS").setVisible(true);
                break;

            case "ATH" :
                mapFlightUi.get("ATH").setVisible(true);
                break;
            case "DFW" :
                mapFlightUi.get("DFW").setVisible(true);
                break;
            case "BCL" :
                mapFlightUi.get("BCL").setVisible(true);
                break;
            case "SYD" :
                mapFlightUi.get("SYD").setVisible(true);
                break;
            case "DEL" :
                mapFlightUi.get("DEL").setVisible(true);
                break;
            case "HND" :
                mapFlightUi.get("HND").setVisible(true);
                break;
            case "HKG" :
                mapFlightUi.get("HKG").setVisible(true);
                break;
            case "DXB" :
                mapFlightUi.get("DXB").setVisible(true);
                break;
            case "AMS" :
                mapFlightUi.get("AMS").setVisible(true);
                break;
            case "MAD" :
                mapFlightUi.get("MAD").setVisible(true);
                break;
            case "JFK" :
                mapFlightUi.get("JFK").setVisible(true);
                break;
            case "FCO" :
                mapFlightUi.get("FCO").setVisible(true);
                break;
            case "CDG" :
                mapFlightUi.get("CDG").setVisible(true);
                break;
            case "GRU" :
                mapFlightUi.get("GRU").setVisible(true);
                break;
            case "YYZ" :
                mapFlightUi.get("YYZ").setVisible(true);
                break;
            case "MEX" :
                mapFlightUi.get("MEX").setVisible(true);
                break;
            case "ARN" :
                mapFlightUi.get("ARN").setVisible(true);
                break;
            case "CAI" :
                mapFlightUi.get("CAI").setVisible(true);
                break;
            case "LOS" :
                mapFlightUi.get("LOS").setVisible(true);
                break;
            case "SVO" :
                mapFlightUi.get("SVO").setVisible(true);
                break;
            case "RAK" :
                mapFlightUi.get("RAK").setVisible(true);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getComponent();
        switch (jLabel.getText()) {
            case "LVS":
                mapFlightUi.get("LVS").setVisible(false);
                break;
            case "JNB":
                mapFlightUi.get("JNB").setVisible(false);
                break;
            case "BKK":
                mapFlightUi.get("BKK").setVisible(false);

                break;
            case "CDG" :
                mapFlightUi.get("CDG").setVisible(false);
                break;
            case "DUB" :
                mapFlightUi.get("DUB").setVisible(false);
                break;
            case "LIS" :
                mapFlightUi.get("LIS").setVisible(false);
                break;
            case "ATH" :
                mapFlightUi.get("ATH").setVisible(false);
                break;
            case "DFW" :
                mapFlightUi.get("DFW").setVisible(false);
                break;
            case "BCL" :
                mapFlightUi.get("BCL").setVisible(false);
                break;
            case "SYD" :
                mapFlightUi.get("SYD").setVisible(false);
                break;
            case "DEL" :
                mapFlightUi.get("DEL").setVisible(false);
                break;
            case "HND" :
                mapFlightUi.get("HND").setVisible(false);
                break;
            case "HKG" :
                mapFlightUi.get("HKG").setVisible(false);
                break;
            case "DXB" :
                mapFlightUi.get("DXB").setVisible(false);
                break;
            case "AMS" :
                mapFlightUi.get("AMS").setVisible(false);
                break;
            case "MAD" :
                mapFlightUi.get("MAD").setVisible(false);
                break;
            case "JFK" :
                mapFlightUi.get("JFK").setVisible(false);
                break;
            case "FCO" :
                mapFlightUi.get("FCO").setVisible(false);
                break;
            case "GRU" :
                mapFlightUi.get("GRU").setVisible(false);
                break;
            case "YYZ" :
                mapFlightUi.get("YYZ").setVisible(false);
                break;
            case "MEX" :
                mapFlightUi.get("MEX").setVisible(false);
                break;
            case "ARN" :
                mapFlightUi.get("ARN").setVisible(false);
                break;
            case "CAI" :
                mapFlightUi.get("CAI").setVisible(false);
                break;
            case "LOS" :
                mapFlightUi.get("LOS").setVisible(false);
                break;
            case "SVO" :
                mapFlightUi.get("SVO").setVisible(false);
                break;
            case "RAK" :
                mapFlightUi.get("RAK").setVisible(false);
                break;
        }
    }
}
