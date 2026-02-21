package Homework.day3;

public class MyCircularQueue<T> implements MyQueue {
    private T[] array;
    private int front = 0; // 데이터를 뺄 위치
    private int rear = 0;  // 데이터를 넣을 위치
    private int size = 0;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        // 자바에서 제네릭 배열은 직접 생성이 안 되므로 Object 배열 생성 후 형변환
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T data) {
        // TODO 1: 큐가 가득 찼는지 확인하고 예외를 던지세요.
        // TODO 2: 현재 rear 위치에 데이터를 넣으세요.
        // TODO 3: rear를 다음 칸으로 옮기세요. (단, 배열 끝이면 0으로 돌아와야 함)
        // 힌트: (rear + 1) % capacity

        if (isFull()) {
            throw new IllegalArgumentException("가득참");
        }

        array[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public Object dequeue() {
        // TODO 1: 큐가 비었는지 확인하고 예외를 던지세요.
        // TODO 2: 현재 front 위치의 데이터를 꺼내세요.
        // TODO 3: 해당 칸을 null로 비워주고, front를 다음 칸으로 옮기세요.
        if (isEmpty()) throw new IllegalArgumentException("비었음");

        T copy = array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size--;

        return copy;
    }

    @Override
    public Object peek() {
        if (isEmpty()) return null;
        return array[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        // 힌트: (rear + 1) % capacity
        return size == capacity;
    }
}
