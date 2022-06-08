package algorithm;

import datatype.ColorBox;
import datatype.Page_Fault_Rate;
import datatype.Result_data;

import javax.swing.*;
import java.util.ArrayList;

public class ALFU {
    public ArrayList<Result_data> run(String str, String frame, JTextArea textArea, Page_Fault_Rate data) {
        int frame_len = Integer.parseInt(frame);
        char[] result = new char[frame_len];
        int[] lru_count = new int[frame_len];
        for (int i = 0; i < frame_len; ++i)
            result[i] = '\0';
        int count = 0;
        ArrayList<Result_data> result_dataArrayList = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
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
                    lru_count[j] += frame_len;
                } else lru_count[j]--;
            }
            if (!find) {
                if (count < frame_len) {
                    data.setPage_fault();
                    result[count] = c;
                    box.set(count, "RED");
                    s += "Page Fault\n";
                    lru_count[count] = frame_len;
                    count++;
                } else {
                    data.setMigrated();
                    int min = Integer.MAX_VALUE;
                    int idx = 0;
                    for (int j = 0; j < frame_len; ++j) {
                        if (lru_count[j] < min) {
                            min = lru_count[j];
                            idx = j;
                        }
                    }
                    box.set(idx, "MAGENTA");
                    result[idx] = c;
                    lru_count[idx] = frame_len;
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
