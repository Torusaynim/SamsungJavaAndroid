package com.company;

public abstract class Figure {
    float x, y;

    Figure (float x, float y) {
        this.x = x;
        this.y = y;
    }

    abstract float getArea();
    abstract float getPerimeter();
}
