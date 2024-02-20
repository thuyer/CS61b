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
    public ArrayDeque(ArrayDeque<T> other) {
        size = other.size;
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        for(int i = nextFirst + 1; i < nextLast; i++) {
            items[i] = other.items[i];
        }
    }
    public  int size() {return size;}
    public void resize() {
        T[] a = (T []) new Object[items.length*2];
        System.arraycopy(items,0,a,0,size);
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
    public void addFirst(T val) {
        if(size == items.length - 1) {
            resize();
        }
        items[nextFirst--] = val;
        size += 1;
        nextFirst = (nextFirst + items.length) % items.length;
    }
    public  void addLast(T val) {
        if(size == items.length - 1) {
            resize();
        }
        items[nextLast++] = val;
        size += 1;
        nextLast %= items.length;
    }
    public T removeFirst() {
        if(items == null) {
            return null;
        }
        nextFirst++;
        size -= 1;
        return items[nextFirst];
    }
    public T removeLast() {
        if(items == null) {
            return null;
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
            System.out.print(items[index]);
        }
    }
}

