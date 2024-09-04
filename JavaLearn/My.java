package dsa.javaCourse;

public class My implements MyLambda {
    @Override
    public int display(int a, int b) {
        return a + b;
    }

    public int useLambda(MyLambda myLambda, int a, int b) {
        return myLambda.display(a, b);
    }
}
