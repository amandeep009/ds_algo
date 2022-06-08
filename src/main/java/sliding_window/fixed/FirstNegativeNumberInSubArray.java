package sliding_window.fixed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,-3,4,-5,3,-2,8,9,10};
        System.out.println(Arrays.toString(firstNegativeNumber(arr,3)));
    }


    public static int[] firstNegativeNumber(int[] arr, int n){
        int l = 0;
        LinkedList<Integer> integers = new LinkedList<>();
        int[] answer = new int[arr.length-n+1];
        int ansIndex = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                integers.add(arr[i]);
            }
            if(i>=n-1){
                answer[ansIndex] = integers.isEmpty()?0:integers.getFirst();
                ansIndex++;
                if(!integers.isEmpty() && arr[l]==integers.getFirst()){
                    integers.removeFirst();
                }
                l++;
            }
        }

        return answer;

    }

}
