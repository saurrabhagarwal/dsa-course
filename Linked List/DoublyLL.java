package dsa;

public class DoublyLL {
    static DNode createDoublyLL(int[] arr) {
        DNode head = new DNode();
        head.data = arr[0];
        head.next = null;
        head.prev = null;
        DNode last = head;
        for (int i = 1; i < arr.length; i++) {
            DNode t = new DNode();
            t.data = arr[i];
            t.next = null;
            t.prev = last;
            last.next = t; //link new node
            last = t;
        }
        return head;
    }

    static void printDoublyLL(DNode head) {
        DNode p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    static DNode insertInDoublyLL(DNode head, int k, int val) {
        DNode p = head;
        while (p.data != k) {
            p = p.next;
        }
        DNode t = new DNode();
        DNode q = p.next;
        t.data = val;
        t.prev = p;
        t.next = q;
        p.next = t;
        q.prev = t;
        return head;
    }

    static DNode deleteFromDoublyLL(DNode head, int k) {
        DNode p = head;
        while (p.data != k) {
            p = p.next;
        }
        //delete p
        DNode q = p.prev;
        q.next = p.next;
        p.next.prev = q;

        return head;
    }

    public static DNode reverseDoublyLL(DNode head) {
        DNode p = head;
        while (p != null) {
            //swap links pf p, prev & next
            DNode t = p.next;
            p.next = p.prev;
            p.prev = t;

            //move to next - next becomes prev
            p = p.prev;

            if (p!= null && p.next == null)
                head = p;
        }
        return head;
    }

    public static void main(String[] args) {
        printDoublyLL(createDoublyLL(new int[]{2, 1, 5, 4, 6}));
        DNode head = createDoublyLL(new int[]{2, 1, 5, 4, 6});
        System.out.println(insertInDoublyLL(head, 5, 10));
        System.out.println(deleteFromDoublyLL(head, 1));

        System.out.println(reverseDoublyLL(head));
    }
}

class DNode {
    int data;
    DNode next;
    DNode prev;

    @Override
    public String toString() {
        return data + "->" + next;
    }
}