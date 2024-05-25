package dsa;

public class LL {
    static Node first;
    static Node last;

    static void create(int[] arr) {
        first = new Node();
        first.data = arr[0];
        first.next = null;
        last = first;
        for (int i = 1; i < arr.length; i++) {
            Node t = new Node();
            t.data = arr[i];
            t.next = null;
            last.next = t; //link
            last = t; //pointing to last
        }
    }

    static Node create2(int[] arr) {
        Node first = new Node();
        first.data = arr[0];
        first.next = null;
        last = first;
        for (int i = 1; i < arr.length; i++) {
            Node t = new Node();
            t.data = arr[i];
            t.next = null;
            last.next = t; //link
            last = t; //pointing to last
        }
        return first;
    }

    static void display() {
        int count = 0;
        Node p = first;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
            count++;
        }
        System.out.println("count " + count);
    }

    static void display(Node p) {
        if (p != null) {
            System.out.println(p.data);
            display(p.next);
        }
    }

    static void displayReverse(Node p) {
        if (p != null) {
            displayReverse(p.next);
            System.out.println(p.data);
        }
    }

    static int count(Node p) {

        if (p == null) {
            return 0;
        }
        return count(p.next) + 1;
    }

    static int sum(Node p) {

        if (p == null) {
            return 0;
        }
        return sum(p.next) + p.data;
    }

    static int max(Node p) {
        int max = 0;
        while (p != null) {
            if (p.data > max) max = p.data;
            p = p.next;
        }
        return max;
    }

    static int max_recursive(Node p) {
        System.out.println("called");
        if (p == null) return 0;
        int x = max_recursive(p.next);
        if (x > p.data) return x;
        return p.data;
    }

    static Node search(Node p, int key) {
        while (p != null) {
            if (p.data == key) return p;
            p = p.next;
        }
        return null;
    }

    static Node searchAndMoveToHead(Node p, int key) {
        Node q = null;
        while (p != null) {
            if (p.data == key) {
                q.next = p.next;
                p.next = first;
                first = p;
                return p;
            }
            q = p;
            p = p.next;
        }
        return null;
    }

    static Node insertAtStart(int key) {
        Node t = new Node();
        t.data = key;
        t.next = first;
        first = t;
        return first;
    }

    static Node insertAtPosition(Node p, int pos, int key) {
        for (int i = 0; i < pos - 1; i++) {
            p = p.next;
        }
        Node t = new Node();
        t.data = key;
        t.next = p.next;
        p.next = t;
        return first;
    }

    static Node insertAtEnd(Node p, int key) {
        while (p.next != null) {
            p = p.next;
        }
        Node t = new Node();
        t.data = key;
        t.next = null;
        p.next = t;
        return first;
    }

    static Node insertInSortedList(Node p, int key) {
        //key less than start
        if (key < p.data) {
            Node t = new Node();
            t.data = key;
            t.next = p;
            first = t;
            return first;
        }
        Node q = null;
        while (p != null && p.data < key) {
            q = p;
            p = p.next;
        }
        Node t = new Node();
        t.data = key;
        t.next = p;
        q.next = t;
        return first;
    }

    static Node deleteFirst() {
        first = first.next;

        return first;
    }

    static Node deleteKey(Node p, int key) {
        Node q = null;
        while (p != null && p.data != key) {
            q = p;
            p = p.next;
        }
        if (p == null) return null;
        if (p == first) {
            first = first.next;
            return first;
        }

        //delete p
        q.next = p.next;
        p.next = null;

        return first;
    }

    public static boolean checkSorted(Node p) {
        int num = p.data;
        while (p != null) {
            if (num > p.data) return false;
            num = p.data;
            p = p.next;
        }
        return true;
    }

    public static Node deleteDuplicatesInSortedList(Node p) {
        //p->q
        Node q = p.next;
        while (q != null) {
            if (p.data == q.data) {
                //delete q
                p.next = q.next;
                q = q.next;
            } else {
                q = q.next;
                p = p.next;
            }
        }
        return first;
    }

    public static Node deleteDuplicatesInUnSortedList(Node p) {

        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.data == q.data) {
                    //delete q
                    p.next = q.next;
                }
                q = q.next;
            }
            p = p.next;
        }
        return first;


    }
    //reverse - two approach
    // reverse elements - use array to store elements
    //reverse links

    public static Node reverseList(Node p) {
        Node q = null;
        Node r;
        while (p != null) {
            //slide p,q,r
            r = q;
            q = p;
            p = p.next;

            //link change
            q.next = r;
        }
        first = q;
        return first;
    }

    //reverse with recursive call
    public static void reverseList_Recursive(Node q, Node p) {
        if (p != null) {
            reverseList_Recursive(p, p.next);
            p.next = q;
        } else first = q;
    }

    //add two lists
    public static Node concatLists(Node first, Node second) {
        Node p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = second;
        return first;
    }

    //merge sorted lists in a single sorted list
    public static Node mergeLists(Node first, Node second) {
        Node third;
        Node last;
        if (first.data < second.data) {
            third = last = first;
            first = first.next;
            last.next = null;
        } else {
            third = second;
            last = second;
            second = second.next;
            last.next = null;
        }
        while (first != null && second != null) {
            if (first.data < second.data) {
                last.next = first;
                last = first;
                first = first.next;
                last.next = null;
            } else {
                last.next = second;
                last = second;
                second = second.next;
                last.next = null;
            }
        }
        if (first != null) last.next = first;
        if (second != null) last.next = second;
        return third;
    }

    public static boolean checkLoop(Node first) {
        Node p = first;
        Node q = first;
        do {
            p = p.next;
            q = q.next;
            if (q != null) q = q.next;
        } while (p != null && q != null && p != q);
        return p == q;
    }

    public static Node findMiddleNode(Node head) {
        Node p = head;
        Node q = head;
        while (q != null) {
            q = q.next;
            if (q != null) q = q.next;
            if (q != null) p = p.next;
        }
        System.out.println("middle element " + p.data);
        return p;
    }

    public static Node findIntersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node p = head1;
            while (p != null) {
                if (p == head2) {
                    System.out.println("intersection element " + head2.data);
                    return head2;
                }
                p = p.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {

        create(new int[]{3, 5, 2, 8, 9});
        display();
//       display(first);
//        displayReverse(first);
        System.out.println("count " + count(first));
        System.out.println("sum " + sum(first));
        System.out.println("max " + max(first));
        System.out.println("max " + max_recursive(first));
        System.out.println(search(first, 8));
        System.out.println(searchAndMoveToHead(first, 8));
        System.out.println(insertAtStart(1));
        System.out.println(insertAtPosition(first, 4, 10));
        System.out.println(insertAtEnd(first, 30));
        System.out.println("sorted - " + checkSorted(first));
        create(new int[]{1, 3, 5, 6});
        display();
        System.out.println(insertInSortedList(first, 4));
        System.out.println(insertInSortedList(first, 0));
        System.out.println(insertInSortedList(first, 6));
        System.out.println(insertInSortedList(first, 16));
        System.out.println(deleteFirst());
        System.out.println(deleteKey(first, 16));
        System.out.println(deleteKey(first, 1));
        System.out.println(deleteKey(first, 16));
        System.out.println("sorted - " + checkSorted(first));

        create(new int[]{1, 3, 3, 4, 5, 5, 5, 6});
        display();
        System.out.println(deleteDuplicatesInSortedList(first));
        create(new int[]{3, 3, 4, 1, 5, 5, 5, 6, 2});
        display();
        System.out.println(deleteDuplicatesInUnSortedList(first));
        reverseList_Recursive(null, first);
        System.out.println(first);
        System.out.println(reverseList(first));
        System.out.println(concatLists(create2(new int[]{1, 3, 2, 5}), create2(new int[]{4, 3, 1, 6})));

        System.out.println(mergeLists(create2(new int[]{1, 3, 4, 6}), create2(new int[]{0, 2, 6, 7, 8})));

        Node p = create2(new int[]{1, 3, 4, 6});
        Node q = create2(new int[]{2, 5});
        p.next = q;
        q.next = p;
        System.out.println(checkLoop(p));
        System.out.println(checkLoop(create2(new int[]{1, 3, 4, 6})));

        System.out.println(findMiddleNode(create2(new int[]{1, 3, 4, 6})));
        System.out.println(findMiddleNode(create2(new int[]{1, 3, 4, 6, 7})));
        System.out.println(findMiddleNode(create2(new int[]{1, 3, 4, 6, 7, 2})));
        System.out.println(findMiddleNode(create2(new int[]{1, 3, 4, 6, 7, 2, 3})));

        Node c = create2(new int[]{7, 8, 9});

        System.out.println(findIntersectionNode(concatLists(create2(new int[]{1, 3, 4, 6}), c), concatLists(create2(new int[]{11, 32}), c)));
    }
}

class Node {
    int data;
    Node next;

    @Override
    public String toString() {
        return data + "->" + next;
    }
}
