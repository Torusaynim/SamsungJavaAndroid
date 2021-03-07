package com.company;

public class Circle extends Figure implements Moveable {
    float radius;

    Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    float getArea() {
        return (float) (radius*radius*Math.PI);
    }

    @Override
    float getPerimeter() {
        return (float) (2*Math.PI*radius);
    }

    @Override
    public void move(float dx, float dy) {
        x+=dx;
        y+=dy;
    }

    @Override
    public void resize(float koeff) {
        radius*=koeff;
    }

    public String toString() {
        return "Circle"+"\n"+"Center: ("+x+", "+y+")"+"\n"+"Radius: "+radius;
    }
}
