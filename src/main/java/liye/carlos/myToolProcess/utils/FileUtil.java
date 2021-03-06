package liye.carlos.myToolProcess.utils;

import java.io.*;
import java.text.SimpleDateFormat;

import liye.carlos.myToolProcess.MainJob;
import jxl.*;
import liye.carlos.myToolProcess.constant.Constant;


/**
 * Created by xianren on 16/11/23.
 */
public class FileUtil {

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void write(String luckyDraw,  String date, int type) {
        try {
            mkdir("luckyDraw");
            mkdir("luckyDraw/" + date);
            String fileName = "luckyDraw/" + date + "/" + "_" + simpleDateFormat.format(System.currentTimeMillis());
            write(luckyDraw, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void mkdir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static void write(String msg, String path) throws IOException {
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
        os.write(msg.getBytes("utf-8"));
        os.close();
    }

    public static String readExcel(String fileName) {

        StringBuilder sb = new StringBuilder();
        try {
            Workbook book;
            book = Workbook.getWorkbook(new File(fileName));

            //Sheet的下标是从0开始
            //获取第一张Sheet表
            Sheet readSheet = book.getSheet(0);

            //获取Sheet表中所包含的总列数
            int rsColumns = readSheet.getColumns();

            //获取Sheet表中所包含的总行数
            int rsRows = readSheet.getRows();

            //获取指定单元格的对象引用
            for (int i = 1; i < rsRows; i++) {
                for (int j = 0; j < rsColumns; j++) {

                    Cell cell = readSheet.getCell(j, i);
                    String str = cell.getContents();

                    if (j == 0) {
                        sb.append(Constant.first).append(Constant.date).append(Constant.second).append(str);
                    }
                    if (j == 1) {
                        sb.append(Constant.third).append(str);
                    }
                    if (j == 2) {
                        sb.append(Constant.fourth).append(str);
                    }
                    if (j == 3) {
                        sb.append(Constant.fifth).append(str);
                    }
                }
                sb.append(System.getProperty("line.separator"));
                System.out.println(sb.toString());
            }
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
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
