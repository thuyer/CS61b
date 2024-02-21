public class ArrayDeque<T> {
    private T[] items;
    private int first;
    private int last;
    private int size;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        first = 3;
        last = 3;
    }

    public  int size() {return size;}
    private void enlarge() {
        T[] a = (T []) new Object[items.length * 2];
        System.arraycopy(items,0,a,0,size);
        items = a;
        first = 0;
        last = size - 1;
    }
    private void reduce(){
        T[] a = (T []) new Object[items.length / 2];
        int temp = first;
        for (int i = 0; i<items.length; i++){
            a[i] = items[temp % items.length];
            temp += 1;
        }
        items = a;
        first = 0;
        last = size - 1;
    }
    private int module(int number){
        number = (number + items.length)% items.length;
        return number;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addFirst(T val) {
        if(size == items.length - 1) {
            enlarge();
        }
        first = module(--first);
        items[first] = val;
        size += 1;
    }
    public  void addLast(T val) {
        if(size == items.length - 1) {
            enlarge();
        }
        last = module(++last);
        items[last] = val;
        size += 1;
    }
    public T removeFirst() {
        if(items == null) {
            return null;
        }
        if(items.length / size >= 4 && items.length > 8) {
            reduce();
        }
        T res = items[first];
        first = module(++first);
        size -= 1;
        return res;
    }
    public T removeLast() {
        if(items == null) {
            return null;
        }
        if(items.length / size >= 4 && items.length > 8) {
            reduce();
        }
        T res = items[last];
        last = module(--last);
        size -= 1;
        return res;
    }
    public T get(int i) {
        if(i >= size) {
            return null;
        }
        int ptr = module(first+i);
        return items[ptr];
    }
    public void printDeque() {
        int index = first;
        for (int i = 0; i < size; i++){
            System.out.print(items[index++]);
            index = module(index);
        }
    }
}

