package dsa.Trees;

public class BSTMain {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = {1,4,3,5,2};
        bst.populate(arr);
        bst.display();
        bst.display2();
        System.out.println(bst.balanced());
        int[] arr2 = {5,6,3,4,2};
        BST bst2 = new BST();
        bst2.populate(arr2);
        bst2.display();
        bst2.display2();
        System.out.println(bst2.balanced());

        int[] arr3 = {1,2,3,4,5};
        BST bst3 = new BST();
        bst3.populateSorted(arr3);
        bst3.display();
        bst3.display2();
        System.out.println(bst3.balanced());
    }
}
