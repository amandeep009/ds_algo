package recursion;

import java.util.Arrays;

public class MergeSortRecursion {
    public static void main(String[] args) {
        int[] arr = {10,5,3,2,4};
        arr = mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }

    static int[] mergeSort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        return merge(mergeSort(Arrays.copyOfRange(arr,0,mid)),mergeSort(Arrays.copyOfRange(arr,mid,arr.length)));
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int m =  0;
        int n =  0;
        int [] result = new int[nums1.length+nums2.length];
        int i=0;
        while(m<nums1.length && n<nums2.length){
            if(nums1[m]<nums2[n]){
                result[i]=nums1[m];
                m++;
            }else{
                result[i] = nums2[n];
                n++;
            }
            i++;
        }

        if(m==nums1.length){
            for(int j=n,resultIndex = i;j< nums2.length;j++,resultIndex++){
                result[resultIndex]= nums2[j];
            }
        }
        if(n==nums2.length){
            for(int j=m,resultIndex = i;j< nums1.length;j++,resultIndex++){
                result[resultIndex]= nums1[j];
            }
        }
        return result;
        }
    }
