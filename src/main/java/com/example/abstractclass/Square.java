package com.example.abstractclass;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Square extends Shape {
    double side;

    public Square(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.side = size;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Квадрат," + "площадь : " + area();
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(fillColor);
        gr.setStroke(strokeColor);
        gr.fillRect(x, y, side, side);
        gr.strokeRect(x, y, side, side);
    }
}