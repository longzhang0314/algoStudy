import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liusha
 * @date 2022/9/9
 */
public class Test2 {

    public static void main(String[] args) {
        String s = "{\"hello\":[{\"enen\":\"oo\"}]}";
        JSONObject jsonObject = JSON.parseObject(s);
        Collection<Object> values = jsonObject.values();
        if (values == null) {
            return;
        }
        Object next = values.iterator().next();
        System.out.println(next);
        System.out.println(next.getClass().getName());
    }
}
