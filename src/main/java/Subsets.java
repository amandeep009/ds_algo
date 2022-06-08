public class Subsets {
    public static void main(String[] args) {
        subsequence("","abc");
    }

    static void subsequence(String processed,String unProcessed){
        if(unProcessed.isEmpty())
        {
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);
        subsequence(processed+ch,unProcessed.substring(1));
        subsequence(processed,unProcessed.substring(1));
    }
}
