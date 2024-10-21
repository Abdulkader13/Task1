package com.example.abstractclass;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class RoundedRectangle extends Shape {
    double length;
    double width;
    double arcWidth;
    double arcHeight;

    public RoundedRectangle(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.length = size;
        this.width = size;
        this.arcWidth = size / 2;
        this.arcHeight = size / 2;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Скругленный прямоугольник, " + "площадь : " + area();
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(fillColor);
        gr.setStroke(strokeColor);
        gr.fillRoundRect(x, y, length, width, arcWidth, arcHeight);
        gr.strokeRoundRect(x, y, length, width, arcWidth, arcHeight);
    }
}
