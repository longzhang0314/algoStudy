package cn.zl.algo.week03.exercise;

import java.util.LinkedList;

/**
 * @author: longzhang
 * @date: 2021/12/15
 */
public class Exercise14Test {
}

class AnimalShelf {
    private LinkedList<Integer> cat;
    private LinkedList<Integer> dog;

    public AnimalShelf() {
        this.cat = new LinkedList<>();
        this.dog = new LinkedList<>();
    }

    // 0 编号 1 猫狗
    public void enqueue(int[] animal) {
        if (animal == null || animal.length == 0) return;
        if (animal[1] == 0) {
            cat.addLast(animal[0]);
        } else {
            dog.addLast(animal[0]);
        }
    }

    public int[] dequeAny() {
        if (cat.isEmpty() && dog.isEmpty()) return new int[]{-1, -1};
        if (cat.isEmpty()) return new int[]{dog.removeFirst(), 1};
        if (dog.isEmpty()) return new int[]{cat.removeFirst(), 0};
        if (cat.getFirst() <= dog.getFirst()) {
            return new int[]{cat.removeFirst(), 0};
        } else {
            return new int[]{dog.removeFirst(), 1};
        }
    }

    public int[] dequeCat() {
        if (cat.isEmpty()) return new int[]{-1, -1};
        return new int[]{cat.removeFirst(), 0};
    }

    public int[] dequeDog() {
        if (dog.isEmpty()) return new int[]{-1, -1};
        return new int[]{dog.removeFirst(), 1};
    }


}
