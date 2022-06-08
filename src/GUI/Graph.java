package GUI;

import datatype.Page_Fault_Rate;

import javax.swing.*;
import java.awt.*;

public class Graph extends JPanel {

    Page_Fault_Rate data;
    double fault_ratio;
    double hit_ratio;
    double page_fault_ratio;
    double migrated_ratio;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GRAY);
        g.fillArc(50, 20, 150, 150, 0, (int)hit_ratio);
        g.fillRect(30, 180, 30, 10);
        g.setColor(Color.orange);
        g.fillArc(50, 20, 150, 150, (int)hit_ratio, (int)page_fault_ratio);
        g.fillRect(120, 180, 30, 10);
        g.setColor(Color.blue);
        g.fillArc(50, 20, 150, 150, (int)hit_ratio + (int)page_fault_ratio, (int)migrated_ratio);
        g.fillRect(30, 200, 30, 10);
        g.setColor(Color.black);
        g.drawString("Hit : " + String.valueOf(data.getHit()), 65, 190);
        g.drawString("Page Fault : " + String.valueOf(data.getPage_fault()), 155, 190);
        g.drawString("Migrated : " + String.valueOf(data.getMigrated()), 65, 210);
        g.drawString("Page Fault Rate (%) = " + String.valueOf(fault_ratio) + "%", 30, 230);
    }

    public void setData(Page_Fault_Rate result){
        data = result;
        int sum = data.getHit() + data.getMigrated() + data.getPage_fault();
        fault_ratio = (double)(data.getMigrated() + data.getPage_fault()) / sum;
        fault_ratio = ((double) Math.round(fault_ratio * 10000) / 100);
        if(data.getHit() == 0)
            hit_ratio = 0;
        else hit_ratio = data.getHit() / (double)sum;
        page_fault_ratio = data.getPage_fault() / (double)sum;
        if(data.getMigrated() == 0)
            migrated_ratio = 0;
        else migrated_ratio = data.getMigrated() / (double)sum;
        hit_ratio *= 360;
        page_fault_ratio *= 360;
        migrated_ratio *= 360;
    }
}
