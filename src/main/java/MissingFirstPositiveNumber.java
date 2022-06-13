public class MissingFirstPositiveNumber {

    public static void main(String[] args) {

        System.out.println(findFirstMissingNumber(new int[]{1,3,7,4}));
        System.out.println(findFirstMissingNumber(new int[]{1,2,5,3}));
        System.out.println(findFirstMissingNumber(new int[]{-1,2,5,3}));
    }

    private static int findFirstMissingNumber(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int correctPosition = arr[i]-1;
            while(arr[i]>=1 && arr[i]<=arr.length && arr[i]!=arr[correctPosition]){
                int temp = arr[correctPosition];
                arr[correctPosition] = arr[i];
                arr[i] = temp;
                correctPosition = arr[i]-1;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return -1;
    }
}
