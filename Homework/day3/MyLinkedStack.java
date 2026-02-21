package Homework.day3;

public class MyLinkedStack<T> implements MyStack<T> {
    private Node<T> top; // 스택의 맨 위를 가리키는 노드
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void push(T data) {
        // TODO: 새 노드를 생성하고 현재 top 위에 올리세요.
        // 힌트: newNode.next를 현재 top으로 지정하고, top을 newNode로 바꿉니다.
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        // TODO: top의 데이터를 꺼내고 top을 다음 노드로 옮기세요.
        // 5단계 고민: 스택이 비어있을 때 pop을 하면 어떤 예외가 적절할까요?
        if (isEmpty()) throw new RuntimeException("스택 비었음");

        T copy = top.data;
        top = top.next;
        size--;

        return copy;
    }

    @Override
    public T peek() {
        // TODO: 현재 top의 데이터를 반환하세요.
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
