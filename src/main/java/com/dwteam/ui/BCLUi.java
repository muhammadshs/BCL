package com.dwteam.ui;

import com.dwteam.controller.BCLController;
import com.dwteam.model.Flight;
import com.dwteam.reader.CsvReader;
import com.dwteam.service.BCLService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
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
    Container container;
    private static Map<String, JScrollPane> mapFlightUi = new HashMap<>();

    public BCLUi() throws HeadlessException {

        setBounds(200, 100, 1140, 720);
        container= getContentPane();
        try {
            csvReader = new CsvReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        init();



        setLayout(null);
        setVisible(true);
    }

    private void init() {
        bclService = new BCLService();
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
        bclController = new BCLController(mapFlightUi);
        String url=new File("src/main/resources/img/image.png").getAbsolutePath();
        ImageIcon icon = new ImageIcon(url);
        Font font = new Font("sp", Font.BOLD, 10);
        jLabelImg = new JLabel(icon);
        jLabelImg.setBounds(0, 150, 1125, 570);
        createFlightListUi();
        creatLocJLabel(font);
        addTojLabelImg();
        JScrollPane jScrollPane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        flightListUi = new FlightListUi("BCL Live Departure", bclService.getFlightDelay());
        jScrollPane2.setViewportView(flightListUi);
        jScrollPane2.setBounds(5, 270, 110, 250);
        jScrollPane.setBackground(null);
        jLabelImg.add(jScrollPane2);
        container.add(jScrollPane);
        container.add(jLabelImg);
    }

    private void createFlightListUi() {
        JScrollPane jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights LVS</html>", bclService.getFlightSum("LVS")), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(75, 170, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("LVS", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights JNB</html>",
                bclService.getFlightSum("JNB")), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(185, 150, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("JNB", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights BKK</html>", bclService.getFlightSum("BKK")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(895, 255, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("BKK", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights DUB</html>", bclService.getFlightSum("DUB")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(505, 115, 110, 200);
        mapFlightUi.put("DUB", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights LIS</html>", bclService.getFlightSum("LIS")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(510, 170, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("LIS", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights ATH</html>",
                bclService.getFlightSum("ATH")), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(595, 170, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("ATH", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights DFW</html>",
                bclService.getFlightSum("DFW")), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(155, 200, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("DFW", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights BCL</html>", bclService.getFlightSum("BCL")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(505, 105, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("BCL", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights SYD</html>", bclService.getFlightSum("SYD")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(910, 250, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("SYD", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights DEL</html>", bclService.getFlightSum("DEL")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(805, 220, 110, 200);
        mapFlightUi.put("DEL", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights HND</html>", bclService.getFlightSum("HND")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(900, 150, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("HND", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights HKG</html>", bclService.getFlightSum("HKG")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(930, 220, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("HKG", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights DXB</html>", bclService.getFlightSum("DXB")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(715, 220, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("DXB", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights AMS</html>", bclService.getFlightSum("AMS")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(535, 100, 110, 200);
        mapFlightUi.put("AMS", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights MAD</html>", bclService.getFlightSum("MAD")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(495, 150, 110, 200);
        mapFlightUi.put("MAD", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights JFK</html>", bclService.getFlightSum("JFK")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(275, 150, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("JFK", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights FCO</html>", bclService.getFlightSum("FCO")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(565, 150, 110, 200);
        mapFlightUi.put("FCO", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights CDG</html>", bclService.getFlightSum("CDG")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(525, 130, 110, 200);
        mapFlightUi.put("CDG", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights GRU</html>", bclService.getFlightSum("GRU")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(345, 220, 110, 200);
        mapFlightUi.put("GRU", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights YYZ</html>", bclService.getFlightSum("YYZ")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(255, 130, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("YYZ", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights MEX</html>", bclService.getFlightSum("MEX")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(135, 230, 110, 200);
        mapFlightUi.put("MEX", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights ARN</html>", bclService.getFlightSum("ARN")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(575, 70, 110, 200);
        mapFlightUi.put("ARN", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights CAI</html>", bclService.getFlightSum("CAI")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(625, 200, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("CAI", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights LOS</html>", bclService.getFlightSum("LOS")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(475, 170, 110, 200);
        mapFlightUi.put("LOS", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights SVO</html>", bclService.getFlightSum("SVO")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(645, 90, 110, 200);
        jScrollPane.setVisible(false);
        mapFlightUi.put("SVO", jScrollPane);
        jScrollPane = new JScrollPane(new FlightListUi("<html>List of Today<br>Departure Flights RAK</html>", bclService.getFlightSum("RAK")),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVisible(false);
        jScrollPane.setBounds(475, 200, 110, 200);
        mapFlightUi.put("RAK", jScrollPane);
        jLabelImg.add(mapFlightUi.get("LVS"));
        jLabelImg.add(mapFlightUi.get("JNB"));
        jLabelImg.add(mapFlightUi.get("RAK"));
        jLabelImg.add(mapFlightUi.get("SVO"));
        jLabelImg.add(mapFlightUi.get("LOS"));
        jLabelImg.add(mapFlightUi.get("CAI"));
        jLabelImg.add(mapFlightUi.get("ARN"));
        jLabelImg.add(mapFlightUi.get("MEX"));
        jLabelImg.add(mapFlightUi.get("YYZ"));
        jLabelImg.add(mapFlightUi.get("GRU"));
        jLabelImg.add(mapFlightUi.get("FCO"));
        jLabelImg.add(mapFlightUi.get("JFK"));
        jLabelImg.add(mapFlightUi.get("MAD"));
        jLabelImg.add(mapFlightUi.get("AMS"));
        jLabelImg.add(mapFlightUi.get("DXB"));
        jLabelImg.add(mapFlightUi.get("HKG"));
        jLabelImg.add(mapFlightUi.get("HND"));
        jLabelImg.add(mapFlightUi.get("DEL"));
        jLabelImg.add(mapFlightUi.get("SYD"));
        jLabelImg.add(mapFlightUi.get("BCL"));
        jLabelImg.add(mapFlightUi.get("DFW"));
        jLabelImg.add(mapFlightUi.get("ATH"));
        jLabelImg.add(mapFlightUi.get("LIS"));
        jLabelImg.add(mapFlightUi.get("DUB"));
        jLabelImg.add(mapFlightUi.get("BKK"));
        jLabelImg.add(mapFlightUi.get("CDG"));

    }
    private void addTojLabelImg(){
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
        jLabelImg.add(jLabelCDG);
    }
    private void creatLocJLabel(Font font){
        jLabelHND = new JLabel("HND");
        jLabelHND.setBounds(1000, 150, 40, 20);
        jLabelHND.setFont(font);
        jLabelHND.addMouseListener(bclController);
        jLabelCDG = new JLabel("CDG");
        jLabelCDG.setFont(font);
        jLabelCDG.setBounds(500, 130, 40, 20);
        jLabelCDG.addMouseListener(bclController);
        jLabelHKG = new JLabel("HKG");
        jLabelHKG.setFont(font);
        jLabelHKG.setBounds(915, 220, 40, 20);
        jLabelHKG.addMouseListener(bclController);
        jLabelDXB = new JLabel("DXB");
        jLabelDXB.setFont(font);
        jLabelDXB.setBounds(690, 220, 40, 20);
        jLabelDXB.addMouseListener(bclController);
        jLabelAMS = new JLabel("AMS");
        jLabelAMS.setFont(font);
        jLabelAMS.setBounds(510, 100, 40, 20);
        jLabelAMS.addMouseListener(bclController);
        jLabelMAD = new JLabel("MAD");
        jLabelMAD.setFont(font);
        jLabelMAD.setBounds(470, 150, 40, 20);
        jLabelMAD.addMouseListener(bclController);
        jLabelJFK = new JLabel("JFK");
        jLabelJFK.setFont(font);
        jLabelJFK.setBounds(250, 150, 40, 20);
        jLabelJFK.addMouseListener(bclController);
        jLabelFCO = new JLabel("FCO");
        jLabelFCO.setFont(font);
        jLabelFCO.setBounds(540, 150, 40, 20);
        jLabelFCO.addMouseListener(bclController);
        jLabelSYD = new JLabel("SYD");
        jLabelSYD.setFont(font);
        jLabelSYD.setBounds(1030, 450, 40, 20);
        jLabelSYD.addMouseListener(bclController);
        jLabelDEL = new JLabel("DEL");
        jLabelDEL.setFont(font);
        jLabelDEL.setBounds(780, 220, 40, 20);
        jLabelDEL.addMouseListener(bclController);
        jLabelGRU = new JLabel("GRU");
        jLabelGRU.setFont(font);
        jLabelGRU.setBounds(320, 400, 40, 20);
        jLabelGRU.addMouseListener(bclController);
        jLabelYYZ = new JLabel("YYZ");
        jLabelYYZ.setFont(font);
        jLabelYYZ.setBounds(230, 130, 40, 20);
        jLabelYYZ.addMouseListener(bclController);
        jLabelMEX = new JLabel("MEX");
        jLabelMEX.setFont(font);
        jLabelMEX.setBounds(110, 230, 40, 20);
        jLabelMEX.addMouseListener(bclController);
        jLabelARN = new JLabel("ARN");
        jLabelARN.setFont(font);
        jLabelARN.setBounds(550, 70, 40, 20);
        jLabelARN.addMouseListener(bclController);
        jLabelCAI = new JLabel("CAI");
        jLabelCAI.setFont(font);
        jLabelCAI.setBounds(600, 200, 40, 20);
        jLabelCAI.addMouseListener(bclController);
        jLabelLOS = new JLabel("LOS");
        jLabelLOS.setFont(font);
        jLabelLOS.setBounds(450, 170, 40, 20);
        jLabelLOS.addMouseListener(bclController);
        jLabelRAK = new JLabel("RAK");
        jLabelRAK.setFont(font);
        jLabelRAK.setBounds(450, 200, 40, 20);
        jLabelRAK.addMouseListener(bclController);
        jLabelSVO = new JLabel("SVO");
        jLabelSVO.setFont(font);
        jLabelSVO.setBounds(620, 90, 40, 20);
        jLabelSVO.addMouseListener(bclController);
        jLabelLVS = new JLabel("LVS");
        jLabelLVS.setFont(font);
        jLabelLVS.setBounds(50, 170, 40, 20);
        jLabelLVS.addMouseListener(bclController);
        jLabelJNB = new JLabel("JNB");
        jLabelJNB.setFont(font);
        jLabelJNB.setBounds(160, 150, 40, 20);
        jLabelJNB.addMouseListener(bclController);
        jLabelBKK = new JLabel("BKK");
        jLabelBKK.setFont(font);
        jLabelBKK.setBounds(870, 255, 40, 20);
        jLabelBKK.addMouseListener(bclController);
        jLabelDUB = new JLabel("DUB");
        jLabelDUB.setFont(font);
        jLabelDUB.setBounds(480, 115, 40, 20);
        jLabelDUB.addMouseListener(bclController);
        jLabelLIS = new JLabel("LIS");
        jLabelLIS.setFont(font);
        jLabelLIS.setBounds(485, 170, 40, 20);
        jLabelLIS.addMouseListener(bclController);
        jLabelATH = new JLabel("ATH");
        jLabelATH.setFont(font);
        jLabelATH.setBounds(570, 170, 40, 20);
        jLabelATH.addMouseListener(bclController);
        jLabelDFW = new JLabel("DFW");
        jLabelDFW.setFont(font);
        jLabelDFW.setBounds(130, 200, 40, 20);
        jLabelDFW.addMouseListener(bclController);
        jLabelBCL = new JLabel("BCL");
        jLabelBCL.setFont(font);
        jLabelBCL.setBounds(480, 105, 40, 20);
        jLabelBCL.addMouseListener(bclController);
    }


    public void refresh(){
        container.removeAll();

        init();
        this.revalidate();
        this.repaint();
    }

    public JTable getjTable() {
        return jTable;
    }

    public JLabel getjLabelCDG() {
        return jLabelCDG;
    }

    public FlightListUi getFlightListUi() {
        return flightListUi;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public static Map<String, JScrollPane> getMapFlightUi() {
        return mapFlightUi;
    }
}
