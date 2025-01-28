public class Linked_Queue {
    private LinkedList front, rear;

    public Linked_Queue() {
        front = rear = null;
    }

    public void enqueue(int value) {
        LinkedList newList = new LinkedList(value);
        if(rear == null) {
            front = rear = null;
            return;
        }
        rear.next = newList;
        rear = newList;
    }

    public int dequeue(){
        if(front.data == 0) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        int value = front.data;
        front = front.next;

        if(front == null) {
            rear = null;
        }
        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        LinkedList current = front;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
