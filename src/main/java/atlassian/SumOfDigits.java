package atlassian;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(12345));
        System.out.println(sumOfDigits(12345123));
        System.out.println(sumOfDigits(1));
    }

    private static int sumOfDigits(int i) {
        int sum = 0;
        while(i>0){
            sum=sum + (i%10);
            i = i/10;
        }
        if((int)Math.log10(sum)+1==1){ // This is important step...
            return sum;
        }else{
            return sumOfDigits(sum);
        }
    }

}
