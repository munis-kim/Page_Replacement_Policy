package GUI;

import datatype.ColorBox;
import datatype.Result_data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Result extends JPanel {
    ArrayList<Result_data> data = new ArrayList<>();
    int frame;

    public Result() {
        setBackground(Color.BLACK);
        setBounds(20, 70, 500, 400);
        setLayout(null);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        int y = 20;
        int i = 1;
        for (Result_data resultData : data) {
            int j = 50;
            char c = resultData.getHead();
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(c), i * 40, y);
            for (int k = 1; k <= frame; ++k) {
                g.drawRect(i * 40 - 15, k * 35, 35, 35);
            }
            char[] str = resultData.getStr();
            ColorBox box = resultData.getBox();
            int index = box.getIndex();
            for (int k = 1; k <= frame; ++k) {
                if (index == k - 1) {
                    if (Objects.equals(box.getColor(), "RED"))
                        g.setColor(Color.RED);
                    else if (Objects.equals(box.getColor(), "GREEN"))
                        g.setColor(Color.GREEN);
                    else if (Objects.equals(box.getColor(), "MAGENTA"))
                        g.setColor(Color.MAGENTA);

                    g.fillRect(i * 40 - 15, k * 35, 35, 35);
                    g.setColor(Color.WHITE);
                    g.drawString(String.valueOf(str[k-1]), i * 40, k * 35 + 20);
                } else{
                    g.drawString(String.valueOf(str[k-1]), i * 40, k * 35 + 20);
                }
            }
            i++;
        }
    }

    public void setData(ArrayList<Result_data> data1, int frame) {
        data = data1;
        this.frame = frame;
    }
}


