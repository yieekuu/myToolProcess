package liye.carlos.myToolProcess.schema;

import lombok.Data;

import java.util.Date;

/**
 * Created by xianren on 16/11/23.
 */
@Data
public class MGNews {
    private String name;
    private int age;

    @Override
    public Object clone(){
        Object o = null;
        try{
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public String toString() {
        return "MGNews{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
