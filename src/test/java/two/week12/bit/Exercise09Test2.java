package two.week12.bit;

/**
 * @author 流沙
 * @date 2024/7/4
 */
public class Exercise09Test2 {

    public int[] swapNumbers(int[] numbers) {
        if (numbers == null || numbers.length < 2) return numbers;
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
