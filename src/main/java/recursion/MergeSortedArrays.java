package recursion;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,3,4};
        merge(nums1,3,nums2,3);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        int i= last;
        int mPointer = m-1;
        int nPointer = n-1;
        for(;i>=0;i--){
            if(mPointer<0 || nPointer<0){
                break;
            }
            if(nums1[mPointer]>nums2[nPointer]){
                nums1[i] = nums1[mPointer];
                mPointer--;
            }else{
                nums1[i] = nums2[nPointer];
                nPointer--;
            }
        }
        if(mPointer<0){
            for(int j=i;j>=0 || nPointer>=0;j--){
                nums1[j]=nums2[nPointer];
                nPointer--;
            }
        }
        if(nPointer<0){
            for(int j=i;j>=0 || mPointer>=0;j--){
                nums1[j]=nums1[mPointer];
                mPointer--;
            }
        }
    }
}
