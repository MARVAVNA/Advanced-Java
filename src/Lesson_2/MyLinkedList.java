import java.util.Objects;

public class MyLinkedList<T> implements MyList<T>{
    private Node<T> begin;
    public int size;

    @Override
    public void add(T obj) {
        if (begin == null) {
            begin = new Node<>(obj);
        } else {
            getNode(size - 1).next = new Node<>(obj);
        }

        size++;
    }

    private Node<T> getNode(int index) {
        Node<T> first = begin;

        int count = 0;

        while (count < index) {
            first = first.next;
            count++;
        }
        return first;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            begin = begin.next;
            return;
        } else {
            Node<T> temp = getNode(index - 1);
            temp.next = temp.next.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(T obj) {
        Node<T> cursor = begin;

        if (Objects.equals(cursor.data, obj)) {
            begin = begin.next;
            size--;
            return;
        }

        Node<T> prev;

        while (cursor != null) {
            prev = cursor;
            cursor = cursor.next;

            if (cursor != null && Objects.equals(cursor.data, obj)) {
                prev.next = cursor.next;
                size--;
                return;
            }
        }

    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new MyListIndexOutOfBoundException();
        }
    }

    @Override
    public String toString() {
        if (begin == null) {
            return "[]";
        }
        Node<T> cursor = begin;
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(cursor.data.toString());
            if (i != size - 1) {
                sb.append(", ");
            }

            cursor = cursor.next;
        }
        
        sb.append("]");

        return sb.toString();
    }
}
