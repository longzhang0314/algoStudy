import org.openjdk.jol.info.ClassLayout;

/**
 * @author liusha
 * @date 2022/7/27
 */
public class MyObjectDemo {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new MyObject()).toPrintable());
    }
}
