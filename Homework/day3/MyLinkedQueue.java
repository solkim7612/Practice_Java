package Homework.day3;

public class MyLinkedQueue<T> implements MyQueue<T> {
    private Node<T> head; // 가장 오래된 노드 (나가는 곳)
    private Node<T> tail; // 가장 최근 노드 (들어오는 곳)
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void enqueue(T data) {
        // TODO: 새 노드를 생성하고 줄의 맨 뒤(tail)에 붙이세요.
        // 힌트 1: 큐가 비어있다면(head == null) head와 tail은 모두 새 노드가 됩니다.
        // 힌트 2: 비어있지 않다면 기존 tail의 next를 새 노드로 연결하고 tail을 갱신하세요.
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public T dequeue() {
        // TODO: 맨 앞(head)의 데이터를 꺼내고 리스트에서 제거하세요.
        // 힌트 1: 큐가 비어있으면 예외를 던지거나 null을 반환하세요.
        // 힌트 2: head를 다음 노드로 옮기세요. 만약 마지막 노드였다면 tail도 null이 되어야 합니다.
        if (isEmpty()) throw new IllegalArgumentException("QUEUE 없음");

        T copy = head.data;
        head = head.next;

        if (head == null) tail = null;
        size--;

        return copy;
    }

    @Override
    public T peek() {
        // TODO: head의 데이터만 반환하세요. (제거X)
        if (head == null) return null;
        return head.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
