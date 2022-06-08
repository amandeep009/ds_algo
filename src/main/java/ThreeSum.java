//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> finalResult = new LinkedList<>();
//        for(int i=0;i<nums.length-1;i++){
//            int temp = nums[i]*(-1);//Complement...
//            if(i==0 || nums[i-1]!=nums[i]){
//                twoSum(i,temp,nums, finalResult);
//            }
//        }
//        return finalResult;
//    }
//
//    private ArrayList<Integer> twoSum(int i, int target, int[] nums,
//                                      List<List<Integer>> finalResult ){
//
//        int low=i+1;
//        int hi=nums.length-1;
//        while(low<hi){
//            int sum = nums[low] + nums[hi];
//            if(sum==target){
//                finalResult.add(Arrays.asList(nums[i],nums[low],nums[high]));
//                while (low < hi && nums[low] == nums[low - 1])
//                    ++low;
//            }else if(sum<target){
//                low++;
//            }else{
//                hi--;
//            }
//        }
//        return res;
//    }
//
//
//
//
//}