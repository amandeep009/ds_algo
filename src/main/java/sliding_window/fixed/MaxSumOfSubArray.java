package sliding_window.fixed;

public class MaxSumOfSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{100,2,3,4,5,3,2,8};
        System.out.println(maxSumSubArray(arr,10));

    }
    public static int maxSumSubArray(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(i<n){
                sum = sum + arr[i];
            }else{
                sum = sum - arr[l] + arr[r];
                l++;
            }
            if(sum>max){
                max = sum;
            }
            r++;
        }
        return max;
    }
}
