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

    }
}
