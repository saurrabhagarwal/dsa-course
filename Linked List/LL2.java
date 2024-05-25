package dsa;

public class LL2 {
    static Node createCircularList(int[] arr) {
        Node head = new Node();
        head.data = arr[0];
        head.next = head;
        Node last = head;
        for (int i = 1; i < arr.length; i++) {
            Node t = new Node();
            t.data = arr[i];
            t.next = last.next; //new node to head (circular)
            last.next = t; //link new node
            last = t;
        }
        return head;
    }

    static void printCircularList(Node head) {
        Node p = head;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != head);
        System.out.println();
    }

    static void printCircularList_Recursive(Node head, Node p, boolean firstTime) {
        if (p != head || firstTime) {
            System.out.print(p.data + " ");
            printCircularList_Recursive(head, p.next, false);
        }
    }

    public static boolean checkLoop(Node first) {
        Node p = first;
        Node q = first;
        do {
            p = p.next;
            q = q.next;
            if (q != null)
                q = q.next;
        } while (p != null && q != null && p != q);
        return p == q;
    }

    public static Node insertInCircularList(Node head, int pos, int k) {
        Node p = head;
        if (pos > 0) {
            for (int i = 0; i < pos - 1; i++) {
                p = p.next;
            }
            Node t = new Node();
            t.data = k;
            t.next = p.next;
            p.next = t;
        } else {
            while (p.next != head) {
                p = p.next;
            }
            Node t = new Node();
            t.data = k;
            t.next = head.next;
            p.next = t;
            head = t;
        }
        return head;
    }

    public static Node deleteInCircularList(Node head, int pos) {
        if (pos > 1) {
            Node p = head;
            for (int i = 0; i < pos - 2; i++) {
                p = p.next;
            }
            //delete q
            Node q = p.next;
            p.next = q.next;
            return head;
        } else {
            //delete head node
            Node p = head;
            while (p.next != head) {
                p = p.next;
            }
            p.next = head.next;
            head = p.next;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 6, 4, 8};
        Node head = createCircularList(arr);
        printCircularList(head);
        printCircularList_Recursive(head, head, true);
        System.out.println();
        System.out.println(checkLoop(head));
        printCircularList(insertInCircularList(head, 3, 10));
        head = insertInCircularList(head, 0, 20);
        printCircularList(head);
        printCircularList(deleteInCircularList(head, 2));
        printCircularList(deleteInCircularList(head, 1));
    }
}