package org.khomenko.homework.ex.one;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class DynamicArray<T> implements List<T> {
    public DynamicArray() {
        this(0);
    }

    public DynamicArray(int size) {
        this.size = size;
        this.top = 0;
        this.data = null;

        if (size != 0) {
            this.data = AllocateArray(size);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (this.top == ) {
            int size = K *
            T[] data = AllocateArray(kthis.size)
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int i) {
        return null;
    }

    @Override
    public T set(int i, T t) {
        return null;
    }

    @Override
    public void add(int i, T t) {

    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    @Override
    public Spliterator<T> spliterator() {
        // TODO: implement spliterator
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    private static T[] AllocateArray(int size) {
        return (T[])new ArrayList<T>(size).toArray();
    }

    private static int K = 2;

    private int size;
    private int top;
    private T[] data;
}
