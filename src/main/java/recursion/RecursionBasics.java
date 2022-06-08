package recursion;

public class RecursionBasics {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
        System.out.println(sumOfDigits(505));
        System.out.println(sumOfDigits(-12345));
        System.out.println(reverseNumberIterative(902));

        int digits = (int) (Math.log10(902)+1);
        System.out.println(reverseNumberRecursive(902,digits-1));
        System.out.println(countNumberOfZeros(902050));

    }
    static int factorial(int n){
        if (n<=1) return 1;
        return n*factorial(n-1);
    }

    static int sumOfDigits(int n){
        if (n==0) return 0;

        int mod = n%10;
        return mod + sumOfDigits(n/10);
    }

    static int reverseNumberIterative(int n){
        int rev = 0;
        while(n>0){
            int mod = n%10;
            rev = (rev+mod)*10 ;
            n = n/10;

        }
        return rev/10;
    }

    static int reverseNumberRecursive(int n,int base){
        if (n==0){
            return 0;
        }
        int mod = n%10;
        return (int)Math.pow(10,base) * mod + reverseNumberRecursive(n/10,--base);
    }

    static int countNumberOfZeros(int n){
        if (n==0) return 0;
        int mod = n%10;
        return (mod==0?1:0) + countNumberOfZeros(n/10);
    }
}
