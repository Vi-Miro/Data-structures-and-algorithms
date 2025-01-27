import java.util.Arrays;

public class Massive_Operations {
    int[] array;
    int size;
    int cur_index = 0;

    public Massive_Operations(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public void sum() {
        int sum = 0;
        for(int i:array) {
            sum += i;
        }
        System.out.println("Array sum: " + sum);
    }

    public void change(int value, int cur_index) {
        if(cur_index < size) {
            array[cur_index] = value;
        }
        System.out.println(Arrays.toString(array));
    }

    public void add(int value) {
        int[] new_array = new int[size + 1];

        for (int i = 0; i < size; i++) {
            new_array[i] = array[i];
        }

        new_array[size] = value;

        array = new_array;
        size++;

        System.out.println(Arrays.toString(array));
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Out of range");
            return;
        }

        int[] new_array = new int[size-1];

        for (int i = 0, j = 0; i < size; i++) {
            if(i != index) {
                new_array[j++] = array[i];
            }
        }
    }

    public class LinkedList_1 {
        int data;
        LinkedList_1 next;

        public LinkedList_1(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList_1_Operations {
        private LinkedList_1 head;

        public void add(int data) {
            LinkedList_1 newList_1 = new LinkedList_1(data);

            if(head == null){
                head = newList_1;
            }
            else {
                LinkedList_1 current = head;
                while(current.next != null) {
                    current = current.next;
                }
                current.next = newList_1;
            }
        }
        public void display() {
            LinkedList_1 current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public class LinkedList_2 {
        int data;
        LinkedList_2 next;
        LinkedList_2 prev;

        public LinkedList_2(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    class LinkedList_2_Operations {
        private LinkedList_2 head;

        public void add(int data) {
            LinkedList_2 newList = new LinkedList_2(data);
            if(head == null) {
                head = newList;
            }
            else {
                LinkedList_2 current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newList;
                newList.prev = current;
            }
        }

        public void display() {
            LinkedList_2 current = head;
            while(current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Работа с массивами
        int[] test_array = {11, 5, 10, 7, 3, 5, 2, 80, 100};
        Massive_Operations mass_op = new Massive_Operations(test_array);

        mass_op.sum();
        mass_op.change(185,5);
        mass_op.add(15);

        System.out.println(mass_op.get(0));

        // Работа с односвязными списками
        Massive_Operations.LinkedList_1_Operations List_1 = mass_op.new LinkedList_1_Operations();
        List_1.add(15);
        List_1.add(37);
        List_1.add(10);
        List_1.add(1);
        List_1.add(7);
        List_1.add(0);

        System.out.print("Элементы односвязного списка: ");
        List_1.display();

        // Работа с двусвязными спсиками
        Massive_Operations.LinkedList_2_Operations List_2 = mass_op.new LinkedList_2_Operations();
        List_2.add(10);
        List_2.add(0);
        List_2.add(5);
        List_2.add(12);
        List_2.add(8);
        List_2.add(1);

        System.out.print("Элементы двусвязного списка: ");
        List_2.display();
    }
}

