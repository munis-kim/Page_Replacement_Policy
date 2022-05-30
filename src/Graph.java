import datatype.Page_Fault_Rate;

import javax.swing.*;
import java.awt.*;

public class Graph extends JPanel {

    Page_Fault_Rate data;
    double hit_ratio;
    double page_fault_ratio;
    double migrated_ratio;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GRAY);
        g.fillArc(20, 20, 100, 100, 0, (int)hit_ratio);
        //g.fillArc(20, 20, 100, 100, 0, 90);
        g.setColor(Color.orange);
        g.fillArc(20, 20, 100, 100, (int)hit_ratio, (int)page_fault_ratio);
        //g.fillArc(20, 20, 100, 100, (int)hit_ratio, 180);
        g.setColor(Color.blue);
        g.fillArc(20, 20, 100, 100, (int)page_fault_ratio, (int)migrated_ratio);
        //g.fillArc(20, 20, 100, 100, 270, 90);
    }

    public void setData(Page_Fault_Rate result){
        data = result;
        int sum = data.getHit() + data.getMigrated() + data.getPage_fault();
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
        int total = (int)hit_ratio + (int)page_fault_ratio + (int)migrated_ratio;
        System.out.println(total);
    }
}
