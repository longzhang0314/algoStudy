package two.week03;

import java.util.LinkedList;

/**
 * @author liusha
 * @date 2022/6/29
 */
public class Exercise14Test2 {

    //animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
    class AnimalShelf {

        LinkedList<Integer> cats;
        LinkedList<Integer> dogs;

        public AnimalShelf() {
            this.cats = new LinkedList<>();
            this.dogs = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            if (animal == null || animal.length == 0) return;
            if (animal[1] == 0) {
                cats.add(animal[0]);
            } else {
                dogs.add(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (dogs.isEmpty()) return dequeueCat();
            if (cats.isEmpty()) return dequeueDog();
            if (cats.getFirst() < dogs.getFirst()) {
                return dequeueCat();
            } else {
                return dequeueDog();
            }
        }

        public int[] dequeueDog() {
            if (dogs.isEmpty()) return new int[]{-1, -1};
            return new int[]{dogs.pollFirst(), 1};
        }

        public int[] dequeueCat() {
            if (cats.isEmpty()) return new int[]{-1, -1};
            return new int[]{cats.pollFirst(), 0};
        }
    }

}
