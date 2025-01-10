package practiceProblems;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Comparator<Integer> compare = (a, b) -> b-a;
        Arrays.stream(arr).boxed().sorted(compare).forEach(n -> System.out.println(n));
    }
}
