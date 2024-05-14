package dsa.recursion;

public class IndirectRecursion {
    public static void main(String[] args) {
        funA(50);
        //50 49 24 23 11 10 5 4 2 1
    }

    static void funA(int n){
        if(n>0){
            System.out.println(n +"-");
            funB(n-1);
        }
    }

    private static void funB(int n) {
        if (n>0){
            System.out.println(n +"--");
            funA(n/2);
        }
    }
}
