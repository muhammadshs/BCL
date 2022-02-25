package com.dwteam.ui;

import com.dwteam.controller.BCLController;
import com.dwteam.model.Flight;
import com.dwteam.repository.CsvReader;
import com.dwteam.service.BCLService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BCLUi extends JFrame {
    private JTable jTable;
    private CsvReader csvReader;
    private JLabel jLabelImg, jLabelHND, jLabelCDG, jLabelHKG, jLabelDXB,
            jLabelAMS, jLabelMAD, jLabelJFK, jLabelFCO, jLabelSYD, jLabelDEL, jLabelGRU, jLabelYYZ, jLabelMEX, jLabelARN, jLabelCAI, jLabelLOS,
            jLabelSVO, jLabelRAK,
            jLabelLVS, jLabelJNB, jLabelBKK, jLabelDUB, jLabelLIS, jLabelATH, jLabelDFW, jLabelBCL;
    private FlightListUi flightListUi;
    private JScrollPane jScrollPane;
    private BCLController bclController;
    private BCLService bclService;
    private static Map<String, JScrollPane> mapFlightUi = new HashMap<>();

    public BCLUi() throws HeadlessException {

        setBounds(200, 100, 1140, 720);
        Container container = getContentPane();
        try {
            csvReader = new CsvReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bclController = new BCLController(mapFlightUi);
        bclService = new BCLService();
        init();

        container.add(jScrollPane);
        container.add(jLabelImg);

        setLayout(null);
        setVisible(true);
    }

    private void init() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Departure  Airport");
        defaultTableModel.addColumn("Arrival AirPort");
        defaultTableModel.addColumn("Departure Time");
        defaultTableModel.addColumn("Original Arrival Time");
        defaultTableModel.addColumn("Delay Time [minutes]");
        defaultTableModel.addColumn("New Arrival Time");
        Object[] ob = new Object[6];
        for (Flight f : csvReader.getList()
        ) {
            ob[0] = f.getDepartureAirport();
            ob[1] = f.getArrivalAirport();
            ob[2] = f.getDepartureTimeString();
            ob[3] = f.getArrivalTimeString();
            ob[4] = f.getDelay();
            ob[5] = f.getNewArrivalTimeString();
            defaultTableModel.addRow(ob);
        }


        jTable = new JTable(defaultTableModel);

        jTable.setBounds(0, 0, 1125, 150);
        // jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //jTable.setShowHorizontalLines(true);
        jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(0, 0, 1125, 150);


        ImageIcon icon = new ImageIcon("G:\\Java Project\\bcl\\src\\main\\resources\\img\\image.png");
        Font font = new Font("sp", Font.BOLD, 10);
        jLabelImg = new JLabel(icon);
        jLabelImg.setBounds(0, 150, 1125, 570);
        jLabelHND = new JLabel("HND");
        jLabelHND.setBounds(1000, 150, 40, 20);
        jLabelCDG = new JLabel("CDG");
        jLabelCDG.setFont(font);
        jLabelCDG.setBounds(500, 130, 40, 20);
        jLabelHKG = new JLabel("HKG");
        jLabelHKG.setFont(font);
        jLabelHKG.setBounds(915, 220, 50, 20);
        jLabelDXB = new JLabel("DXB");
        jLabelDXB.setFont(font);
        jLabelDXB.setBounds(690, 220, 40, 20);
        jLabelAMS = new JLabel("AMS");
        jLabelAMS.setFont(font);
        jLabelAMS.setBounds(510, 100, 60, 20);
        jLabelMAD = new JLabel("MAD");
        jLabelMAD.setFont(font);
        jLabelMAD.setBounds(470, 150, 40, 20);
        jLabelJFK = new JLabel("JFK");
        jLabelJFK.setFont(font);
        jLabelJFK.setBounds(250, 150, 60, 20);
        jLabelFCO = new JLabel("FCD");
        jLabelFCO.setFont(font);
        jLabelFCO.setBounds(540, 150, 60, 20);
        jLabelImg.add(jLabelCDG);
        jLabelSYD = new JLabel("SYD");
        jLabelSYD.setFont(font);
        jLabelSYD.setBounds(1030, 450, 60, 20);
        jLabelDEL = new JLabel("DEL");
        jLabelDEL.setFont(font);
        jLabelDEL.setBounds(780, 220, 60, 20);
        jLabelGRU = new JLabel("GRU");
        jLabelGRU.setFont(font);
        jLabelGRU.setBounds(320, 400, 60, 20);
        jLabelYYZ = new JLabel("YYZ");
        jLabelYYZ.setFont(font);
        jLabelYYZ.setBounds(230, 130, 60, 20);
        jLabelMEX = new JLabel("MEX");
        jLabelMEX.setFont(font);
        jLabelMEX.setBounds(110, 230, 60, 20);
        jLabelARN = new JLabel("ARN");
        jLabelARN.setFont(font);
        jLabelARN.setBounds(550, 70, 60, 20);
        jLabelCAI = new JLabel("CAI");
        jLabelCAI.setFont(font);
        jLabelCAI.setBounds(600, 200, 60, 20);
        jLabelLOS = new JLabel("LOS");
        jLabelLOS.setFont(font);
        jLabelLOS.setBounds(450, 170, 60, 20);
        jLabelRAK = new JLabel("RAK");
        jLabelRAK.setFont(font);
        jLabelRAK.setBounds(450, 200, 60, 20);
        jLabelSVO = new JLabel("SVO");
        jLabelSVO.setFont(font);
        jLabelSVO.setBounds(620, 90, 60, 20);
        jLabelLVS = new JLabel("LVS");
        jLabelLVS.setFont(font);
        jLabelLVS.addMouseListener(new BCLController(mapFlightUi));
        jLabelLVS.setBounds(50, 170, 60, 20);
        jLabelJNB = new JLabel("JNB");
        jLabelJNB.setFont(font);
        jLabelJNB.setBounds(160, 150, 70, 20);
        jLabelBKK = new JLabel("BKK");
        jLabelBKK.setFont(font);
        jLabelBKK.setBounds(870, 255, 60, 20);
        jLabelDUB = new JLabel("DUB");
        jLabelDUB.setFont(font);
        jLabelDUB.setBounds(480, 115, 60, 20);
        jLabelLIS = new JLabel("LIS");
        jLabelLIS.setFont(font);
        jLabelLIS.setBounds(485, 170, 60, 20);
        jLabelATH = new JLabel("ATH");
        jLabelATH.setFont(font);
        jLabelATH.setBounds(570, 170, 60, 20);
        jLabelDFW = new JLabel("DFW");
        jLabelDFW.setFont(font);
        jLabelDFW.setBounds(130, 200, 60, 20);
        jLabelBCL = new JLabel("BCD");
        jLabelBCL.setFont(font);
        jLabelBCL.setBounds(480, 105, 60, 20);
        jLabelImg.add(jLabelLVS);
        jLabelImg.add(jLabelJNB);
        jLabelImg.add(jLabelBKK);
        jLabelImg.add(jLabelDUB);
        jLabelImg.add(jLabelLIS);
        jLabelImg.add(jLabelATH);
        jLabelImg.add(jLabelDFW);
        jLabelImg.add(jLabelBCL);
        jLabelImg.add(jLabelSYD);
        jLabelImg.add(jLabelDEL);
        jLabelImg.add(jLabelHND);
        jLabelImg.add(jLabelHKG);
        jLabelImg.add(jLabelDXB);
        jLabelImg.add(jLabelAMS);
        jLabelImg.add(jLabelMAD);
        jLabelImg.add(jLabelJFK);
        jLabelImg.add(jLabelFCO);
        jLabelImg.add(jLabelGRU);
        jLabelImg.add(jLabelYYZ);
        jLabelImg.add(jLabelMEX);
        jLabelImg.add(jLabelARN);
        jLabelImg.add(jLabelCAI);
        jLabelImg.add(jLabelLOS);
        jLabelImg.add(jLabelSVO);
        jLabelImg.add(jLabelRAK);
        mapFlightUi.put("LVS", new JScrollPane(new FlightListUi("List of Today Departure Flights LVS", bclService.getFlightSum("LVS")),JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        mapFlightUi.put("JNB", new JScrollPane(new FlightListUi("List of Today Departure Flights JNB", bclService.getFlightSum("JNB"))));
        mapFlightUi.put("BKK", new JScrollPane(new FlightListUi("List of Today Departure Flights BKK", bclService.getFlightSum("BKK"))));
        mapFlightUi.put("DUB", new JScrollPane(new FlightListUi("List of Today Departure Flights DUB", bclService.getFlightSum("DUB"))));
        mapFlightUi.put("LIS", new JScrollPane(new FlightListUi("List of Today Departure Flights LIS", bclService.getFlightSum("LIS"))));
        mapFlightUi.put("ATH", new JScrollPane(new FlightListUi("List of Today Departure Flights ATH", bclService.getFlightSum("ATH"))));
        mapFlightUi.put("DFW", new JScrollPane(new FlightListUi("List of Today Departure Flights DFW", bclService.getFlightSum("DFW"))));
        mapFlightUi.put("BCL", new JScrollPane(new FlightListUi("List of Today Departure Flights BCL", bclService.getFlightSum("BCL"))));
        mapFlightUi.put("SYD", new JScrollPane(new FlightListUi("List of Today Departure Flights SYD", bclService.getFlightSum("SYD"))));
        mapFlightUi.put("DEL", new JScrollPane(new FlightListUi("List of Today Departure Flights DEL", bclService.getFlightSum("DEL"))));
        mapFlightUi.put("HND", new JScrollPane(new FlightListUi("List of Today Departure Flights HND", bclService.getFlightSum("HND"))));
        mapFlightUi.put("HKG", new JScrollPane(new FlightListUi("List of Today Departure Flights HKG", bclService.getFlightSum("HKG"))));
        mapFlightUi.put("DXB", new JScrollPane(new FlightListUi("List of Today Departure Flights DXB", bclService.getFlightSum("DXB"))));
        mapFlightUi.put("AMS", new JScrollPane(new FlightListUi("List of Today Departure Flights AMS", bclService.getFlightSum("AMS"))));
        mapFlightUi.put("MAD", new JScrollPane(new FlightListUi("List of Today Departure Flights MAD", bclService.getFlightSum("MAD"))));
        mapFlightUi.put("JFK", new JScrollPane(new FlightListUi("List of Today Departure Flights JFK", bclService.getFlightSum("JFK"))));
        mapFlightUi.put("FCO", new JScrollPane(new FlightListUi("List of Today Departure Flights FCO", bclService.getFlightSum("FCO"))));
        mapFlightUi.put("GRU", new JScrollPane(new FlightListUi("List of Today Departure Flights GRU", bclService.getFlightSum("GRU"))));
        mapFlightUi.put("YYZ", new JScrollPane(new FlightListUi("List of Today Departure Flights YYZ", bclService.getFlightSum("YYZ"))));
        mapFlightUi.put("MEX", new JScrollPane(new FlightListUi("List of Today Departure Flights MEX", bclService.getFlightSum("MEX"))));
        mapFlightUi.put("ARN", new JScrollPane(new FlightListUi("List of Today Departure Flights ARN", bclService.getFlightSum("ARN"))));
        mapFlightUi.put("CAI", new JScrollPane(new FlightListUi("List of Today Departure Flights CAI", bclService.getFlightSum("CAI"))));
        mapFlightUi.put("LOS", new JScrollPane(new FlightListUi("List of Today Departure Flights LOS", bclService.getFlightSum("LOS"))));
        mapFlightUi.put("SVO", new JScrollPane(new FlightListUi("List of Today Departure Flights SVO", bclService.getFlightSum("SVO"))));
        mapFlightUi.put("RAK", new JScrollPane(new FlightListUi("List of Today Departure Flights RAK", bclService.getFlightSum("RAK"))));
        jLabelImg.add(mapFlightUi.get("LVS"));
        JScrollPane jScrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        flightListUi = new FlightListUi("BCL Live Departure", bclService.getFlightDelay());
        jScrollPane2.setViewportView(flightListUi);
        jScrollPane2.setBounds(5, 270, 110, 250);
        jScrollPane.setBackground(null);
        jLabelImg.add(jScrollPane2);
    }
}
