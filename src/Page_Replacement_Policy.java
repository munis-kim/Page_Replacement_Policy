import GUI.Graph;
import GUI.Result;
import algorithm.*;
import datatype.Page_Fault_Rate;
import datatype.Result_data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Page_Replacement_Policy extends JFrame {
    Container contentPane = getContentPane();
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                try {
                    Page_Replacement_Policy frame = new Page_Replacement_Policy();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
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
        JTextArea result_area = new JTextArea();
        JScrollPane result_text = new JScrollPane(result_area);
        result_area.setEditable(false);
        result_text.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JComboBox chooseAlgorithm = new JComboBox();
        chooseAlgorithm.addItem("FIFO");
        chooseAlgorithm.addItem("Optimal");
        chooseAlgorithm.addItem("LRU");
        chooseAlgorithm.addItem("LFU");
        chooseAlgorithm.addItem("MFU");
        chooseAlgorithm.addItem("ALFU");
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
        result_text.setBounds(550, 70, 300, 150);
        random.setBounds(530, 30, 100, 20);
        run.setBounds(640, 30, 80, 20);
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int len = (int)(Math.random()*10000) + 1;
                Random rnd = new Random();
                StringBuilder str = new StringBuilder();
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

        Graph draw_graph = new Graph();
        Result draw_result = new Result();
        contentPane.add(draw_graph);
        JScrollPane panel_pane = new JScrollPane(draw_result);
        panel_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel_pane.setBounds(20, 70, 500, 400);

        run.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Result_data> data = new ArrayList<>();
                Page_Fault_Rate result_data = new Page_Fault_Rate();
                result_area.setText(null);
                int policy_num = chooseAlgorithm.getSelectedIndex();
                switch (policy_num) {
                    case 0 -> {
                        FIFO fifo = new FIFO();
                        data = fifo.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                    }
                    case 1 -> {
                        Optimal optimal = new Optimal();
                        data = optimal.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                    }
                    case 2 -> {
                        LRU lru = new LRU();
                        data = lru.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                    }
                    case 3 -> {
                        LFU lfu = new LFU();
                        data = lfu.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                    }
                    case 4 -> {
                        MFU mfu = new MFU();
                        data = mfu.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                    }
                    case 5 -> {
                        ALFU alfu = new ALFU();
                        data = alfu.run(reference_string_text.getText(), frame_text.getText(), result_area, result_data);
                    }
                }
                draw_result.setPreferredSize(new Dimension((reference_string_text.getText().length() + 1) * 40, 40 * Integer.parseInt(frame_text.getText())));
                draw_result.setData(data, Integer.parseInt(frame_text.getText()));
                draw_graph.setData(result_data);
                draw_graph.setBounds(550, 230, 400, 300);
                draw_result.revalidate();
                draw_result.repaint();
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
