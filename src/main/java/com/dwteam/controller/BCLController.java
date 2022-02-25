package com.dwteam.controller;

import com.dwteam.service.BCLService;
import com.dwteam.ui.FlightListUi;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class BCLController extends MouseAdapter {
    private static Map<String, JScrollPane> mapFlightUi ;
    private BCLService bclService;

    public BCLController(Map<String,JScrollPane> map) {
        bclService = new BCLService();
        mapFlightUi=map;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getComponent();
        System.out.println("aa");
        switch (jLabel.getText()) {
            case "LVS":
                mapFlightUi.get("LVS").setBounds(75,170,100,200);
                mapFlightUi.get("LVS").setVisible(true);
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
        }
    }
}
