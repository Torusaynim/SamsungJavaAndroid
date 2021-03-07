package com.company;

public class PointIndexException extends Exception {
    private final int index;
    public PointIndexException (int index) {
        super("Некоректный номер точки");
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
}
