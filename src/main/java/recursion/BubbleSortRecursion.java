package recursion;

public class BubbleSortRecursion {

    static int n = 0;
    public static void main(String[] args) {
        int[] arr ={4,2,2,15,18,-10};
        bubbleSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }

    static int[] bubbleSort(int [] arr,int row,int column){
        if(column==0){
            return arr;
        }
        if(row==arr.length-1){
            return bubbleSort(arr,0,--column);
        }
        if(arr[row]>arr[row+1]){ // swap
            int temp = arr[row];
            arr[row] = arr[row+1];
            arr[row+1] = temp;
        }
        return bubbleSort(arr,++row,column);
    }


}
