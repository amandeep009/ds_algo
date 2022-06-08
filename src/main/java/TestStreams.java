import java.util.Arrays;
import java.util.List;

public class TestStreams {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int[] ints = Arrays.stream(nums).map(num -> (num * num)).toArray();
        Arrays.sort(ints);

    }
}
