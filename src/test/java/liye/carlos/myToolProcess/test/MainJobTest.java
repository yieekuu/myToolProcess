package liye.carlos.myToolProcess.test;

import com.alibaba.fastjson.JSONObject;
import liye.carlos.myToolProcess.dto.User;
import liye.carlos.myToolProcess.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianren on 17/2/17.
 */
public class MainJobTest {

    private static User test() {
        User u = new User();
        try{
            u.setName("123");

        } finally {
            System.out.println("---------");
            u = null;
        }
        return u;
    }

    public static String getAdministrativeDivision() {
        String res = "";
        try {
            String jsonContext = FileUtil.readFile("/Users/xianren/code/excelBatchProcess/administrativeDivision.json");
            JSONObject jsonObject = JSONObject.parseObject(jsonContext);
            JSONObject result = jsonObject.getJSONObject("result");
            res = result.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/xianren/code/excelBatchProcess/luckyDraw1225.xls";
        List<String> aa = new ArrayList<>();
        Long bb = (long)aa.size();
        System.out.println(bb);
//        File sss = new File(MainJob.class.getResource("/sendCouponTel.txt").getPath());
//        String res = readFile(sss.getPath());
//        List<String> mobileList = Arrays.asList(res.split(","));
//        int type = -1;

//        FileUtil.write(FileUtil.readExcel(fileName), date, type);

//        String a = getAdministrativeDivision();

//        String startTime = "2016-12-22 12:00:00";
//        Long updateTime = DateTimeUtils.toSecond(startTime,"yyyy-MM-dd HH:mm:ss");

//        System.out.println(mobileList+ "-----" +mobileList.size());
    }
}
