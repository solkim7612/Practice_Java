package Homework.day3;

interface MyList<T> {
    void add(T data);
    T get(int index);
    T remove(int index);
    int size();
}