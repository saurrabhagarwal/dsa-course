package dsa.recursion;

public class TreeRecursion {
    //multiple recursion call
    public static void main(String[] args) {
        func(3);
        //3 2 1 1 2 1 1

        //n+1 tree level
        // 2.power(n+1) -1 calls
        //O(2.power(n)) Time Complexity
        //O(n) - Space Complexity

    }

    static void func(int n){
        if(n>0){
            System.out.println(n);
            func(n-1);
            func(n-1);
        }
    }
}
