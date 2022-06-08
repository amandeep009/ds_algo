public class SearchInRotatedSortedArray {


    public static void main(String[] args) {
        int [] nums1 = {4,5,6,7,0,1,2};
        search(nums1,0);
    }
    private static int search(int[] nums, int target){
        int l=0,r=nums.length-1;

        while(l<=r){
            int mid =(l + r)/2;
            if(nums[mid]==target)
                return target;

            if(nums[l]<=nums[mid])//left sorted array
            {
                if ((target<nums[mid] && target<nums[l]) || target>=nums[mid]) {
                    l = mid + 1;
                }else if(target<nums[mid] && target>=nums[l]){
                    r =mid-1;
                }
            }else{ //right sorted array
                if(target<nums[mid] || (target>nums[mid] && target>nums[r])){
                    r = mid-1;
                }else if(target>nums[mid] && target<nums[r]){
                    l = mid+1;
                }
            }
        }
        return -1;
    }

}
