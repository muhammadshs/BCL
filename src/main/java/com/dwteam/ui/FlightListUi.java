package com.dwteam.ui;

import com.dwteam.ListPro;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class FlightListUi extends JPanel {
    private JLabel jLabelTitle, jLabelItem;

    public FlightListUi(String title, ListPro<String,Integer> flight) {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        setBorder(blackLine);
        Font font = new Font("sp", Font.BOLD, 9);
        Font font2 = new Font("title", Font.PLAIN, 10);
        setBackground(new Color(0, 0, 0, 0));
        // setSize(120,300);
        jLabelTitle = new JLabel(title);
        jLabelTitle.setFont(font2);
        jLabelTitle.setSize(100, 40);
        jLabelTitle.setForeground(Color.BLUE);
        add(jLabelTitle);

        for (int i=0;i<flight.size();i++
        ) {
            String[] s=flight.get(i);
            jLabelItem = new JLabel(s[0]);
            if(s[1].equals("1")){
                jLabelItem.setForeground(Color.RED);
            }
            jLabelItem.setFont(font);
            add(jLabelItem);
            System.out.println(flight.toString(i));

        }
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
    }
}
