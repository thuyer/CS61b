public class LinkedListDeque<T> {
    private int size;
    private DNode sentinel;
    private class DNode {
        public DNode prev;
        public T item;
        public DNode next;
        public DNode(DNode p, T i, DNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new DNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new DNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for(int i = 0; i < other.size; i++){
            addLast((T)other.get(i));
        }
    }

    public void addFirst(T item) {
        sentinel.next = new DNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next; //don`t forget to update origin node.prev
        size += 1;
    }
    public void addLast(T item) {
        sentinel.prev = new DNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        DNode tmp = sentinel;
        while (tmp.next != sentinel) {
            System.out.print(tmp.next.item+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public T removeFirst() {
        DNode p = sentinel.next;
        if(p == sentinel) {
            return null;
        }
        sentinel.next = p.next;
        p.next.prev = sentinel;
        size--;
        return p.item;
    }
    public T removeLast() {
        DNode p = sentinel.prev;
        if(p == sentinel) {
            return null;
        }
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        size--;
        return p.item;
    }
    public T get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        DNode tmp = sentinel.next;
        int i = 0;
        while (i < index) {
            tmp = tmp.next;
            i++;
        }
        return tmp.item;
    }
    private T help(DNode p, int index) {
        if(index == 0) {
            return p.item;
        }
        return help(p.next, index-1);
    }
    public T getRecursive(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return help(sentinel.next,index);
    }
}



