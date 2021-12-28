package cn.zl.algo.week05.hash.common;

import java.util.LinkedList;

/**
 * 哈希表
 *
 * @author: longzhang
 * @date: 2021/12/28
 */
public class MyHashTable {

    private static class Student {
        String id;
        String name;
    }

    private LinkedList<Student>[] slots;
    private int n;

    public MyHashTable(int n) {
        this.n = n;
        this.slots = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            slots[i] = new LinkedList<>();
        }
    }

    public void put(String id, Student student) {
        int hashValue = hasFunction(id);
        LinkedList<Student> list = slots[hashValue];
        list.addFirst(student);
    }

    public Student get(String id) {
        int hashValue = hasFunction(id);
        LinkedList<Student>  list = slots[hashValue];
        for (Student student : list) {
            if (student.id.equals(id)) {
                return student;
            }
        }
        return null;
    }

    private int hasFunction(String id) {
        int hashKey = Integer.parseInt(id);
        return hashKey % n;
    }
}
