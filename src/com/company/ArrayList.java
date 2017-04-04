package com.company;


public class ArrayList <T>{
    T[] array;
    int lastIndex = 0;
    int capacity = 9;

    public ArrayList() {
        this.array = (T[]) new Object[capacity+1];
    }

    public void add(T element) {
        if (lastIndex == capacity)
        {
            Expand();
        }
        array[lastIndex] = element;
        lastIndex++;
    }

    public void Expand() {
        int oldcapacity = capacity;
        capacity = capacity*3/2 + 1;
        T[] arrayNew = (T[]) new Object[capacity];
        for (int i = 0; i<oldcapacity; i++)
        {
            arrayNew[i] = array[i];
        }
        array = arrayNew;
    }

    public void addByIndex(T element, int index){
        if (lastIndex == capacity)
        {
            Expand();
        }
        for (int i= capacity; i>=index; i--)
        {
            array[i] = array[i-1];
        }
        array[index] = element;
    }

    public void remove(int index) {
        for (int i = index; i< capacity + 1; i++)
        {
            array[i] = array[i+1];
        }
        array[capacity] = null;
        //тут еще надо добавить проверку, если capacity уменьшилась в 3/2+1 раз, то уменьшать массив
    }

    public <T> T find(int index) {
        return (T) array[index];
    }
}
