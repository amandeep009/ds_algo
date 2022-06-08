package sliding_window.variable;

public class LargestSubArrayOfSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,2,3,5};
        System.out.println(maxLenghtSubArrayWithSumK(arr,3));
        System.out.println(maxLenghtSubArrayWithSumK(arr,6));

    }

    private static int maxLenghtSubArrayWithSumK(int[] arr, int k) {

        int l=0,r=0,max=Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            sum = sum + arr[i];
            if(sum==k){
                max = Math.max(max,r-l+1);
            }
            else if(sum>k){
                sum = sum - arr[l];
                l++;
            }
            r++;
        }
        return max;
    }
}
