import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private static final int CAPACITY = 3;
    private Object[] data;
    private int size;
    private int index;

    public MyArrayList() {
        data = new Object[CAPACITY];
        size = CAPACITY;
    }

    @Override
    public void add(T obj) {
        if (index == size - 1) {
            increaseSize();
        }
        data[index++] = obj;
    }

    private void increaseSize() {
        size = size + CAPACITY;
        Object[] temp = new Object[size];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.index)
            throw new MyListIndexOutOfBoundException();
        return (T) data[index];
    }

    @Override
    public void remove(int index) {
        int lastIndex = this.index - 1;
        if (this.index - index >= 0)
            System.arraycopy(data, index + 1, data, index, this.index - index);
        data[this.index - 1] = null;
        this.index--;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void remove(T obj) {
        for (int i = 0; i < index; i++) {
            if (data[i].equals(i)) {
                remove(i);
                break;
            }
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index) {
            throw new MyListIndexOutOfBoundException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < index; i++) {
            sb.append(data[i].toString());
            if (i != index -1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}
