package sliding_window.fixed;

import java.util.*;

public class MaxInSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,-3,4,-5,3,-2,8,9,10};
        System.out.println(Arrays.toString(maxInSubArray(arr,3)));
    }

    /*
    General code for any fixed size sliding window problem
        Do calculations - In this case build queue always containing first element as the max of window.
            The important point is element in the right of max which are lesser than max can still become max
            but elements in left of max can never become max hence keep on clearing them.
        Check if window size is reached - (r-l+1==n)
            1. Store the answer
            2. Slide the window.(l++ and r++)
            3. Remove anything present in queue for l.
     */
    private static int[] maxInSubArray(int[] arr, int n) {
        int l=0, r=0;
        Deque<Integer> queue = new LinkedList<>();
        int[] answer = new int[arr.length-n+1];
        int answerIndex = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(!queue.isEmpty() && arr[i]>queue.getFirst()){
                queue.clear();
                queue.addFirst(arr[i]);
            }else{
                //Remove all the elements smaller than arr[i]
                int index = i;
                while(queue.size()>0 && index>=0){
                    if(queue.getLast()<arr[i]){
                        queue.removeLast();
                    }
                    index--;
                }
                queue.addLast(arr[i]);
            }
            if(r-l+1==n){
                answer[answerIndex] = queue.getFirst();
                if(queue.getFirst()==arr[l]){
                    queue.remove();
                }
                answerIndex++;
                l++;
            }
            r++;
        }
        return answer;
    }


}
