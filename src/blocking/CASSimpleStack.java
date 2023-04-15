package blocking;

import java.util.concurrent.atomic.AtomicReference;

public class CASSimpleStack<T> {
    private final AtomicReference<Node<T>> head = new AtomicReference<>();
    public void push(T el){
        Node<T> tmp = new Node<>(el);
        Node<T> ref;
        do {
            ref = head.get();
            tmp.next = ref;

        }while(!head.compareAndSet(ref,tmp));
    }
    public T poll(){
        Node<T> tmp;
        Node<T> ref;
        do{
            ref=head.get();
            if (ref == null) {
                throw new IllegalStateException("Stack i,s empty");
            }
            tmp=ref.next;
        }while (!head.compareAndSet(ref, tmp));
        ref.next=null;
        return ref.value;

    }




    private static final class Node<T> {
        private final T value;

        private Node<T> next;

        public Node(final T value) {
            this.value = value;
        }
    }
}
