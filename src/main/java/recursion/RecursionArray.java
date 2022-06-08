package recursion;

import java.util.ArrayList;

public class RecursionArray {
    public static void main(String[] args) {
        int [] arr = {1,1,0,1};
        System.out.println(arrayIsSorted(arr,0));
        ArrayList<Integer> output = new ArrayList<>();
        findArrayIndexes(arr,0,1, output);
        System.out.println(output);
    }
    static boolean arrayIsSorted(int[] arr, int index){
        if(index==arr.length-1) return true;

        return  arr[index+1]>=arr[index]&& arrayIsSorted(arr,++index);

    }

    static void findArrayIndexes(int[] arr, int index, int target, ArrayList<Integer> output){
        if(index==arr.length) return;
        if(arr[index]==target) output.add(index);
        findArrayIndexes(arr,++index,target,output);
    }
}
