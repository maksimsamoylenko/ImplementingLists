package edu.greenriver.sdev333;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int n;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size()
    { return n;}

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public int rank(Key key){
        int lo = 0, hi = n-1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
        }
        return lo;
    }

    public void put(Key key, Value val){
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0){
            vals[i] = val; return;
        }
        for (int j = n; j > i; j--){
            keys[j] = keys[j-1]; vals[j] = vals[j-1];
        }
        keys[i] = key; vals[i] = val;
        n++;
    }
}
