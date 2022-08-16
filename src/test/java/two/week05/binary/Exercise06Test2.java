package two.week05.binary;

/**
 * @author liusha
 * @date 2022/8/16
 */
public class Exercise06Test2 {

    // words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) return -1;
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (words[mid].compareTo(s) == 0) {
                return mid;
            } else if (words[mid].equals("")) {
                if (words[left].equals(s)) {
                    return left;
                }
                left = left + 1;
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
