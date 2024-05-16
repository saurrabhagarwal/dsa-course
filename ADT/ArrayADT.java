package dsa;

public class ArrayADT {
    static class Array {
        private int[] items;
        private int length;
        private int size;

        public Array(int size) {
            this.size = size;
            this.items = new int[size];
            this.length = 0;
        }

        public void display() {
            System.out.println("displaying items of array");
            for (int i = 0; i < length; i++) {
                System.out.println(items[i]);
            }
        }

        public void add(int el) {
            if (length == size) {
                int[] newArray = new int[size * 2];
                for (int i = 0; i < length; i++) {
                    newArray[i] = items[i];
                }
                items = newArray;
                size = size * 2;
            }
            items[length++] = el;
        }

        public void insert(int index, int el) {
            if (index >= 0 && index < length) {
                for (int i = length; i > index; i--) {
                    items[i] = items[i - 1];
                }
                items[index] = el;
                length++;
            }
        }

        public void delete(int index) {
            if (index >= 0 && index < length) {
                for (int i = index; i < length - 1; i++) {
                    items[i] = items[i + 1];
                }
                length--;
            }
        }

        public int binarySearch(int el) {
            int l = 0;
            int h = length - 1;

            while (l <= h) {
                int m = (l + h) / 2;
                if (items[m] == el)
                    return m;
                else if (items[m] < el) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
            return -1;
        }

        public int get(int index) {
            return items[index];
        }

        public void set(int index, int el) {
            items[index] = el;
        }

        public int max() {
            int max = items[0];
            for (int i = 1; i < length; i++) {
                if (items[i] > max)
                    max = items[i];
            }
            return max;
        }

        public int min() {
            int min = items[0];
            for (int i = 1; i < length; i++) {
                if (items[i] < min)
                    min = items[i];
            }
            return min;
        }

        public int sum() {
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += items[i];
            }
            return sum;
        }

        public double avg() {
            double sum = 0;
            for (int i = 0; i < length; i++) {
                sum += items[i];
            }
            return sum / length;
        }
        
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.display();
        array.insert(3, 70);
        array.display();
        array.delete(2);
        array.display();
        System.out.println("----");
        System.out.println(array.binarySearch(70));
        System.out.println(array.sum());
        System.out.println(array.max());
        System.out.println(array.min());
        System.out.println(array.avg());
    }
}
