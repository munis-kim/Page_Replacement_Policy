package algorithm;

import datatype.ColorBox;
import datatype.Page_Fault_Rate;
import datatype.Result_data;

import javax.swing.*;
import java.util.ArrayList;

public class FIFO {
    public ArrayList<Result_data> run(String str, String frame, JTextArea textArea, Page_Fault_Rate data) {
        int frame_len = Integer.parseInt(frame);
        char[] result = new char[frame_len];
        for(int i = 0; i < frame_len; ++i)
            result[i] = '\0';
        int count = 0;
        ArrayList<Result_data> result_dataArrayList = new ArrayList<>();
        for(int i = 0; i < str.length(); ++i){
            ColorBox box = new ColorBox();
            boolean find = false;
            char c = str.charAt(i);
            String s = "Data " + c + " is ";
            for(int j = 0; j < count; ++j){
                if(result[j] == c){
                    box.set(j, "GREEN");
                    data.setHit();
                    find = true;
                    s += "Hit\n";
                    break;
                }
            }
            if(!find){
                if(count < frame_len){
                    data.setPage_fault();
                    result[count] = c;
                    box.set(count, "RED");
                    s += "Page Fault\n";
                    count++;
                } else{
                    data.setMigrated();
                    if (count - 1 >= 0) System.arraycopy(result, 1, result, 0, count - 1);
                    result[count - 1] = c;
                    box.set(count - 1, "MAGENTA");
                    s += "Migrated\n";
                }
            }
            Result_data result_data = new Result_data(box, c, result);
            result_dataArrayList.add(result_data);
            textArea.append(s);
        }
        return result_dataArrayList;
    }
}
