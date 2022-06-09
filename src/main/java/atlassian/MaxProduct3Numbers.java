package atlassian;

public class MaxProduct3Numbers {
    public static void main(String[] args) {
        int [] arr = {-11,2,4,9,20,-10};
        int [] arr2 = {-1,-2,-3,-4,-5,-6};
        System.out.println(maxProduct3Nums(arr));
        System.out.println(maxProduct3Nums(arr2));
    }

    private static int maxProduct3Nums(int[] arr) {
        int maxA=Integer.MIN_VALUE,maxB=Integer.MIN_VALUE,maxC=Integer.MIN_VALUE;
        int minA=Integer.MAX_VALUE,minB=Integer.MAX_VALUE;

        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>maxA){
                maxC = maxB;
                maxB = maxA;
                maxA =  arr[i];
            }
            else if(arr[i]>maxB){
                maxC = maxB;
                maxB = arr[i];
            }else if(arr[i]>maxC){
                maxC = arr[i];
            }
            if(arr[i]<minA){
                minB = minA;
                minA = arr[i];
            }
            else if(arr[i]<minB){
                minB = arr[i];
            }
        }

        return Math.max(maxA*maxB*maxC,maxA*minA*minB);
    }
}
