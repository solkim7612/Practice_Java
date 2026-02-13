package Homework.day3;

public class MyLinkedList<T> implements MyList {
    private Node<T> head;
    private int size = 0;

    // 내부 클래스로 노드 정의
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T data) {
        // TODO: 새 노드를 생성하세요.
        // TODO: head가 null이면 head로 지정하고, 아니면 마지막 노드까지 찾아가서 연결하세요.
        Node<T> newNode = new Node<>(data);
        if (head == null) head = newNode;
        else {
            Node<T> cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        // TODO: head부터 시작해서 index번만큼 next를 타고 이동하세요.
        Node<T> start = head;
        for (int i = 0; i < index; i++) start = start.next;

        return start.data;
    }

    @Override
    public T remove(int index) {
        // TODO: 삭제할 노드의 '이전 노드'를 찾아 '다음 노드'와 직접 연결하세요.
        // TODO: 끊어진 노드의 연결을 정리하세요.
        T del=null;
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) prev = prev.next;
            del= (T) prev.next;
            prev.next=prev.next.next;
        }
        size--;
        return del.data;
    }

    @Override
    public int size() {
        return this.size = size;
    }
}
