import javax.swing.*;
import java.awt.*;

public class Page_Replacement_Policy extends JFrame {
    Container contentPane = getContentPane();

    public static void main(String[] args){
        Page_Replacement_Policy frame = new Page_Replacement_Policy();
        frame.setVisible(true);
    }

    public Page_Replacement_Policy(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        setTitle("Page Replacement Policy 21812105");
        contentPane.setLayout(null);
        SET_GUI();
    }

    private void SET_GUI(){
        JLabel policy = new JLabel("Policy");
        JLabel reference_string = new JLabel("Reference String");
        JLabel frame = new JLabel("#Frame");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        JScrollPane panel_pane = new JScrollPane(panel);
        panel_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JComboBox chooseAlgorithm = new JComboBox();
        chooseAlgorithm.addItem("FIFO");
        chooseAlgorithm.addItem("Optimal");
        chooseAlgorithm.addItem("LRU");
        chooseAlgorithm.addItem("LFU");
        chooseAlgorithm.addItem("MFU");
        chooseAlgorithm.addItem("Mine");    // 스케줄링 이름 추후 수정 필요
        JTextField reference_string_text = new JTextField();
        JTextField frame_text = new JTextField();
        policy.setBounds(50, 10, 50, 20);
        reference_string.setBounds(250, 10, 100, 20);
        frame.setBounds(470, 10, 50, 20);
        chooseAlgorithm.setBounds(20, 30, 100, 20);
        reference_string_text.setBounds(150, 30, 300, 20);
        frame_text.setBounds(470, 30, 50,20);
        panel.setBounds(20, 70, 500, 400);
        contentPane.add(policy);
        contentPane.add(reference_string);
        contentPane.add(chooseAlgorithm);
        contentPane.add(reference_string_text);
        contentPane.add(frame);
        contentPane.add(frame_text);
        contentPane.add(panel);
    }
}
