/**
 * @author liusha
 * @date 2022/9/9
 */
public class Test1 extends Thread {

    private static int i = 31;
    public static void main(String[] args) throws InterruptedException {

        Test1 t1 = new Test1();
        Test1 t2 = new Test1();
        Test1 t3 = new Test1();
        Test1 t4 = new Test1();
        Test1 t5 = new Test1();
        Test1 t6 = new Test1();
        Test1 t7 = new Test1();
        t1.start();
        t2.start();
        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();

        t1.join();
        t2.join();
        t3.join();
//        t4.join();
//        t5.join();
//        t6.join();
//        t7.join();
        System.out.println("最终i: " + i); // 0
    }

    @Override
    public void run() {

        while (i > 0) {
            // 1 2 3
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            i--;
            System.out.println("当前i：" + i + "===" +Thread.currentThread().getName());
//            if (i < 0) {
//                System.out.println("超了-----------------------------------------------------");
//            }
        }
    }
}
