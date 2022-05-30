import algorithm.FIFO;
import datatype.Page_Fault_Rate;
import jdk.jfr.Event;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Page_Replacement_Policy extends JFrame {
    Container contentPane = getContentPane();
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                Page_Replacement_Policy frame = new Page_Replacement_Policy();
                frame.setVisible(true);
            }
        });

    }

    public Page_Replacement_Policy(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setTitle("Page Replacement Policy 21812105");
        contentPane.setLayout(null);
        JLabel policy = new JLabel("Policy");
        JLabel reference_string = new JLabel("Reference String");
        JLabel frame = new JLabel("#Frame");
        JPanel panel = new JPanel();
        JScrollPane panel_pane = new JScrollPane(panel);
        JTextArea result_area = new JTextArea();
        JScrollPane result_text = new JScrollPane(result_area);
        result_area.setEditable(false);
        panel_pane.getViewport().setBackground(Color.black);
        panel_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        result_text.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JComboBox chooseAlgorithm = new JComboBox();
        chooseAlgorithm.addItem("FIFO");
        chooseAlgorithm.addItem("Optimal");
        chooseAlgorithm.addItem("LRU");
        chooseAlgorithm.addItem("LFU");
        chooseAlgorithm.addItem("MFU");
        chooseAlgorithm.addItem("Mine");    // 스케줄링 이름 추후 수정 필요
        JButton run = new JButton("Run");
        JButton random = new JButton("Random");
        JTextField reference_string_text = new JTextField();
        JTextField frame_text = new JTextField();
        frame_text.setText("4");
        policy.setBounds(50, 10, 50, 20);
        reference_string.setBounds(250, 10, 100, 20);
        frame.setBounds(470, 10, 50, 20);
        chooseAlgorithm.setBounds(20, 30, 100, 20);
        reference_string_text.setBounds(150, 30, 300, 20);
        frame_text.setBounds(470, 30, 50,20);
        panel_pane.setBounds(20, 70, 500, 400);
        result_text.setBounds(550, 70, 300, 150);
        random.setBounds(530, 30, 100, 20);
        run.setBounds(640, 30, 80, 20);
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int len = (int)(Math.random()*30) + 1;
                Random rnd = new Random();
                StringBuffer str = new StringBuffer();
                for(int i = 0; i < len; ++i){
                    if(rnd.nextBoolean()){
                        str.append((char)((int)(rnd.nextInt(26)) + 97));
                    } else{
                        str.append((rnd.nextInt(10)));
                    }
                }
                reference_string_text.setText(String.valueOf(str));
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Page_Fault_Rate result_data = new Page_Fault_Rate();
                result_area.setText(null);
                int policy_num = chooseAlgorithm.getSelectedIndex();
                switch(policy_num){
                    case 0:
                        FIFO run = new FIFO();
                        run.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                        break;
                }

                Graph draw_graph = new Graph();
                draw_graph.setData(result_data);
                draw_graph.setBounds(550, 300, 200, 200);
                contentPane.add(draw_graph);
                draw_graph.revalidate();
                draw_graph.repaint();
                repaint();
            }
        });

        contentPane.add(policy);
        contentPane.add(reference_string);
        contentPane.add(chooseAlgorithm);
        contentPane.add(reference_string_text);
        contentPane.add(frame);
        contentPane.add(frame_text);
        contentPane.add(panel_pane);
        contentPane.add(random);
        contentPane.add(run);
        contentPane.add(result_text);
    }
}
