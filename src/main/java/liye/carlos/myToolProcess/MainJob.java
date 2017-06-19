package liye.carlos.myToolProcess;

import com.alibaba.fastjson.JSONObject;
import liye.carlos.myToolProcess.schema.MGNews;

import java.io.*;

import liye.carlos.myToolProcess.dto.User;


/**
 * Created by xianren on 16/11/23.
 */
public class MainJob {
    public static String date = "2016-12-25";
    public static String first = "http://tradeactivitivs.meilishuo.com/activities/givingseason/v1/addWinningList/h5?key=1iCXdbmbcbRQFKrRXIRAH9EAsG9ToYvgNRQyD06t513aanNEOPnMjZVRdKkirk7&date=";
    public static String second = "&uid=";
    public static String third = "&uname=";
    public static String fourth = "&wid=";
    public static String fifth = "&wname=";

    public static void main(String[] args) throws Exception {
//        String fileName = "/Users/xianren/code/excelBatchProcess/luckyDraw1225.xls";
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
            String jsonContext = readFile("/Users/xianren/code/excelBatchProcess/administrativeDivision.json");
            JSONObject jsonObject = JSONObject.parseObject(jsonContext);
            JSONObject result = jsonObject.getJSONObject("result");
            res = result.toString();
        }catch (Exception e){
        }
        return res;
    }

    public static String readFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}
