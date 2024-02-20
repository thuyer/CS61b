public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public  int size() {return size;}
    private void enlarge() {
        T[] a = (T []) new Object[items.length*2];
        System.arraycopy(items,0,a,0,size);
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }
    private void reduce(){
        T[] a = (T []) new Object[items.length/2];
        int temp = nextFirst + 1;
        for (int i = 0; i<items.length; i++){
            a[i] = items[temp % items.length];
            temp += 1;
        }
        items = a;
        nextFirst = items.length;
        nextLast = size - 1;
    }
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    public void addFirst(T val) {
        if(size == items.length - 1) {
            enlarge();
        }
        items[nextFirst--] = val;
        size += 1;
        nextFirst = (nextFirst + items.length) % items.length;
    }
    public  void addLast(T val) {
        if(size == items.length - 1) {
            enlarge();
        }
        items[nextLast++] = val;
        size += 1;
        nextLast %= items.length;
    }
    public T removeFirst() {
        if(items == null) {
            return null;
        }
        if(items.length / size >= 4) {
            reduce();
        }
        nextFirst++;
        size -= 1;
        return items[nextFirst];
    }
    public T removeLast() {
        if(items == null) {
            return null;
        }
        if(items.length / size >= 4) {
            reduce();
        }
        nextLast--;
        size -= 1;
        return items[nextLast];
    }
    public T get(int i) {
        return items[(nextFirst+i+1) % items.length];
    }
    public void printDeque() {
        int index = nextFirst + 1;
        for (int i = 0; i < size; i++){
            System.out.print(items[index++]);
            index %= items.length;
        }
    }
}

