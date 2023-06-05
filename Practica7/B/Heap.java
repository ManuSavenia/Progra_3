

class Heap<T> implements Comparable<Heap<T>> {
    private int pos;
    private int costo;

    public Heap(int pos, int costo) {
        this.pos = pos;
        this.costo = costo;
    }

    public Heap() {
        
    }

    public int getPos() {
        return pos;
    }

    public int getCosto() {
        return costo;
    }

    @Override
    public int compareTo(Heap<T> otro) {
        return Integer.compare(costo, otro.getCosto());
    }
}