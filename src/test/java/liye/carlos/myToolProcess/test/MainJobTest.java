package liye.carlos.myToolProcess.test;

import com.alibaba.fastjson.JSONObject;
import liye.carlos.myToolProcess.dto.User;
import liye.carlos.myToolProcess.utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

import static liye.carlos.myToolProcess.utils.NumConversion.numConversion;

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

    /**
     * 生成热度,页数越大值越小。
     *
     * @param page 当前页数
     * @param hour 发表时间距当前时间小时差
     * @return 热度小于1，大于0
     */
    public static String calcHotRank(Integer page, Integer hour) {
        Double result = 0d;
        if (page < 1 || hour < 0) {
            return "0.01";
        }
        result = 100*(1-0.1*(page-1)-0.03*hour)*(1-Math.random()*0.1);
        return numConversion(result < 0.01 ? 0.01 : result, "#0.00");
    }

    public static void main(String[] args) throws Exception {
//        Strings fileName = "/Users/xianren/code/excelBatchProcess/luckyDraw1225.xls";
//        List<Strings> aa = new ArrayList<>();
//        Long bb = (long)aa.size();
        System.out.println(calcHotRank(1,1));
//        File sss = new File(MainJob.class.getResource("/sendCouponTel.txt").getPath());
//        Strings res = readFile(sss.getPath());
//        List<Strings> mobileList = Arrays.asList(res.split(","));
//        int type = -1;

//        FileUtil.write(FileUtil.readExcel(fileName), date, type);

//        Strings a = getAdministrativeDivision();

//        Strings startTime = "2016-12-22 12:00:00";
//        Long updateTime = DateTimeUtils.toSecond(startTime,"yyyy-MM-dd HH:mm:ss");

//        System.out.println(mobileList+ "-----" +mobileList.size());
    }
}
