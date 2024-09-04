package dsa.javaCourse;

public class LambdaLearn {
    public static void main(String[] args) {

        MyLambda myLambda1 = (a,b) -> {
            int c =10;
            c++;
            return a+b+c;
        };
        System.out.println(myLambda1.display(3,6));

        My my = new My();
        System.out.println(my.useLambda((a,b)-> a+b,8,9));


    }
}

