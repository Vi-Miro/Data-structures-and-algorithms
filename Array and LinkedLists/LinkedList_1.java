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
            System.out.println(current.data + " ");
        }
        System.out.println();
    }
}
