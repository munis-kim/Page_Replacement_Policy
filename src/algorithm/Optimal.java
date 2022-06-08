package algorithm;

import datatype.ColorBox;
import datatype.Page_Fault_Rate;
import datatype.Result_data;

import javax.swing.*;
import java.util.ArrayList;

public class Optimal {
    public ArrayList<Result_data> run(String str, String frame, JTextArea textArea, Page_Fault_Rate data) {
        int frame_len = Integer.parseInt(frame);
        char[] result = new char[frame_len];
        Boolean[] optimal_result = new Boolean[frame_len];
        for (int i = 0; i < frame_len; ++i)
            result[i] = '\0';
        int count = 0;
        ArrayList<Result_data> result_dataArrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            for (int j = 0; j < frame_len; ++j)
                optimal_result[j] = false;
            int optimal_count = 0;
            ColorBox box = new ColorBox();
            boolean find = false;
            char c = str.charAt(i);
            String s = "Data " + c + " is ";
            for (int j = 0; j < count; ++j) {
                if (result[j] == c) {
                    box.set(j, "GREEN");
                    data.setHit();
                    find = true;
                    s += "Hit\n";
                    break;
                }
            }
            if (!find) {
                if (count < frame_len) {
                    data.setPage_fault();
                    result[count] = c;
                    box.set(count, "RED");
                    s += "Page Fault\n";
                    count++;
                } else {
                    data.setMigrated();
                    for (int j = i + 1; j < str.length(); ++j) {
                        for (int k = 0; k < frame_len; ++k) {
                            if (result[k] == str.charAt(j)) {
                                if(optimal_result[k]) break;
                                optimal_count++;
                                optimal_result[k] = true;
                                break;
                            }
                        }
                        if (optimal_count == frame_len - 1)
                            break;
                    }
                    for (int j = 0; j < frame_len; ++j)
                        if (!optimal_result[j]) {
                            box.set(j, "MAGENTA");
                            result[j] = c;
                            break;
                        }
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
