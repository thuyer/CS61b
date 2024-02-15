public class ArrayDeque<Glorp> {
    private Glorp[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    public ArrayDeque() {
        items = (Glorp []) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }
    public ArrayDeque(ArrayDeque<Glorp> other) {
        size = other.size;
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        for(int i = nextFirst + 1; i < nextLast; i++) {
            items[i] = other.items[i];
        }
    }
    public  int size() {return size;}
    public void resize() {
        Glorp[] a = (Glorp []) new Object[items.length*2];
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
    public void addFirst(Glorp val) {
        if(size == items.length) {
            resize();
        }
        items[nextFirst--] = val;
        size += 1;
        nextFirst = (nextFirst + items.length) % items.length;
    }
    public  void addLast(Glorp val) {
        if(size == items.length) {
            resize();
        }
        items[nextLast++] = val;
        size += 1;
        nextLast %= items.length;
    }
    public Glorp[] removeFirst() {
        nextFirst++;
        size -= 1;
        return items;
    }
    public Glorp[] removeLast() {
        nextLast--;
        size -= 1;
        return items;
    }
    public Glorp get(int index) {
        return items[index];
    }
    public Glorp getLast() {
        int i = nextLast-1;
        return items[i];
    }
}
