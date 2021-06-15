interface MyList<T> {
    void add(T obj);
    T get(int index);
    void remove(int index);
    int size();
    void remove(T obj);
}
