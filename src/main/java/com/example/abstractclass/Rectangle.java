package com.example.abstractclass;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.length = size;
        this.width = size;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Прямоугольник, " + "площадь : " + area();
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(fillColor);
        gr.setStroke(strokeColor);
        gr.fillRect(x, y, length, width);
        gr.strokeRect(x, y, length, width);
    }
}