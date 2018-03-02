package liye.carlos.myToolProcess.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import liye.carlos.myToolProcess.dto.PlayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liye3 on 2017/9/22.
 */
public class Music163 {
    public List<PlayList> getPlayList() {
        String file = "/Users/carlos/code/music163.json";
        List<PlayList> result = new ArrayList<>();
        String json = FileUtil.readFile(file);
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONObject("playlist").getJSONArray("tracks");
        Iterator<Object> it = jsonArray.iterator();
        while (it.hasNext()) {
            JSONObject object = (JSONObject) it.next();
            PlayList playList = new PlayList();
            playList.setName(object.getString("name"));
            JSONArray artistArray = object.getJSONArray("ar");
            if(artistArray!=null) {
                Iterator<Object> itArtist = artistArray.iterator();
                String artist = "";
                while (itArtist.hasNext()) {
                    JSONObject artistObject = (JSONObject) itArtist.next();
                    artist += artistObject.getString("name") + ",";
                }
                playList.setArtist(artist);
            }

            playList.setAlbum(object.getJSONObject("al").getString("name"));
            result.add(playList);
        }

        return result;
    }

    public static void main(String[] arg) {
        Music163 music163 = new Music163();
        List<PlayList> result = music163.getPlayList();
        try {
            String fileName = "/Users/carlos/code/music163PlayList.txt";
            FileUtil.write(result.toString(), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }

}
