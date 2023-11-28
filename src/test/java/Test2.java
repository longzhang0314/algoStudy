import java.util.HashSet;
import java.util.Set;

/**
 * @author liusha
 * @date 2022/9/9
 */
public class Test2 {

    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            System.out.println(set.add(null));
        }
    }
}
