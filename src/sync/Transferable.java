package sync;

public interface Transferable {
    boolean transfer(int fromId, int toId, int amount);
}