public class ArrayDeque {
    int[] items;
    int nextFirst;
    int nextLast;
    int size;
    public ArrayDeque(){
        items = new int[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }
    public ArrayDeque(ArrayDeque other){
        size = other.size;
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        for(int i = nextFirst+1;i<nextLast;i++){
            items[i] = other.items[i];
        }
    }
    public  int size(){return size;}
    public void resize(){
        int[] a= new int[items.length*2];
        System.arraycopy(items,0,a,0,size);
        items = a;
        nextFirst = items.length-1;
        nextLast = size;
    }
    public void addFirst(int val){
        if(size == items.length){
            resize();
        }
        items[nextFirst--] = val;
        size += 1;
        nextFirst = (nextFirst + items.length)%items.length;
    }
    public  void addLast(int val){
        if(size == items.length){
            resize();
        }
        items[nextLast++] = val;
        size += 1;
        nextLast %= items.length;
    }
    public void removeFirst(){
        nextFirst++;
        size -= 1;
    }
    public void removeLast(){
        nextLast--;
        size -= 1;
    }
    public int get(int index){
        return items[index];
    }
    public int getLast(){
        int i = nextLast-1;
        return items[i];
    }
}
