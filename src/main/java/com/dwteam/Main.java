package com.dwteam;

import com.dwteam.ui.BCLUi;

public class Main {

    public static void main(String[] args) {


        BCLUi bclUi = new BCLUi();
        try {
            while (true) {
                bclUi.refresh();
                Thread.sleep(300000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
