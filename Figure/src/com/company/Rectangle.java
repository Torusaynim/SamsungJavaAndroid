package com.company;

public class Rectangle extends Figure implements Moveable {
    float height, width;

    Rectangle(float x, float y, float height, float width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    float getArea() {
        return height*width;
    }

    @Override
    float getPerimeter() {
        return (height+width)*2;
    }

    @Override
    public void move(float dx, float dy) {
        x+=dx;
        y+=dy;
    }

    @Override
    public void resize(float koeff) {
        height*=koeff;
        width*=koeff;
    }

    public String toString() {
        return "Rectangle"+"\n"+"Center: ("+(float)(x+width/2)+", "+(float)(y+height/2)+")"+"\n"+"Height: "+height+"\n"+"Width: "+width;
    }
}
