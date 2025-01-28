public class Stack {
    private int[] array;
    private int top;

    public Stack(int size) {
        array = new int[size];
        top = -1;
    }

    public void push(int value) {
        if(top == array.length - 1) {
            System.out.println("Стэк переполнен!");
            return;
        }
        array[++top] = value;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Стэк пуст!");
            return -1;
        }
        return array[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = top; i >=0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

