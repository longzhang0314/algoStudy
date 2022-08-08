/**
 * @author liusha
 * @date 2022/7/27
 */
public class MyObject {


    private long a;
    private int b;
    private Integer c;

    private static final int s = 1;

    public MyObject() {
    }

    public MyObject(long a, int b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }
}
