package blocking;

import Resources.Bucket;

public class SimpleStack<T> {
    private Node<T> head;

    public void push(T el){
        if(head==null){
            head = new Node<>(el);
        }else{
           Node newHead = new Node<>(el);
           newHead.next=head;
           head=newHead;
        }
    }
    public T poll(){
        if(head==null) return null;
        else{
            T value = head.value;
            head=head.next;
            return value;
        }
    }




    private static final class Node<T> {
        private final T value;

        private Node<T> next;

        public Node(final T value) {
            this.value = value;
        }
    }
}
