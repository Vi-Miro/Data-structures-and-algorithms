public class Linked_Stack {
    private LinkedList top;

    public void push(int value) {
        LinkedList newList = new LinkedList(value);
        newList.next = top;
        top = newList;
    }

    public int pop() {
        if(top == null) {
            System.out.println("Стэк пуст!");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        LinkedList current = top;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
