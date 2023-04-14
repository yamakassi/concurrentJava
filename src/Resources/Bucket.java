package Resources;
import net.jcip.annotations.Immutable;

@Immutable
public class Bucket<T> {
    private final Bucket<T> next;
    private final T value;

    public Bucket(Bucket<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public Bucket<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
}
