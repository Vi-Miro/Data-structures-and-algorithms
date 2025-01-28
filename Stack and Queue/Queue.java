public class Queue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        array = new int[size];
        front = 0;
        rear = -1;
        this.size = 0;
    }

    public void enqueue(int value){
        if(size == array.length) {
            System.out.println("Очередь переполнена!");
            return;
        }
        rear = (rear + 1)% array.length;
        array[rear] = value;
        size ++;
    }

    public int dequeue(){
        if(size == 0) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        int value = array[front];
        front = (front + 1)% array.length;
        size --;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[(front + i)% array.length] + " ");
        }
        System.out.println();
    }

}
