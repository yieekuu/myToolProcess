package liye.carlos.myToolProcess.utils;

import java.text.DecimalFormat;

/**
 * Created by liye3 on 2017/7/5.
 */
public class NumConversion {
    public static String numConversion(Double num, String format) {
        if (num == null) {
            num = 0d;
        }
        try {
            DecimalFormat df = new DecimalFormat(format);
            return df.format(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num.toString();
    }
}
