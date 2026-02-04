package Homework.day3;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    // TODO DEFAULT_CAPACITY 상수를 이용해서 elemetns 프로퍼티를 초기화 하는 생성자 생성
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T data) {
        // TODO: 용량이 꽉 찼는지 확인하고, 필요하다면 resize()를 호출하세요.
        // TODO: 데이터를 배열 끝에 추가하세요.
        if (size == DEFAULT_CAPACITY) resize();
        elements[size] = data;
        size++;
    }

    private void resize() {
        // TODO: 기존 배열보다 2배 큰 새 배열을 만드세요.
        Object[] new_elements=new Object[elements.length*2];
        for(int i=0; i<elements.length; i++) new_elements[i]=elements[i];
        this.elements=new_elements;
    }

    @Override
    public T get(int index) {
        // TODO: 인덱스 범위를 체크(0 <= index < size)하고 데이터를 반환하세요.
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    @Override
    public T remove(int index) {
        // TODO: 삭제될 데이터를 백업하세요.
        // TODO: 삭제된 칸 뒤의 데이터들을 한 칸씩 앞으로 당기세요. (배열 복사 활용)
        T backup= (T) elements[index];

        for(int i=index; i<size-1; i++){
            elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;

        return backup;
    }

    @Override
    public int size() {
        return this.size;
    }
}