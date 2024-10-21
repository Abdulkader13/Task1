package com.example.abstractclass;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Ellipse extends Shape {
    double radiusX;
    double radiusY;

    public Ellipse(Color fillColor, Color strokeColor, double x, double y, double size) {
        super(fillColor, strokeColor, x, y, size);
        this.radiusX = size;
        this.radiusY = size;
    }

    @Override
    double area() {
        return Math.PI * radiusX * radiusY;
    }

    @Override
    public String toString() {
        return "Эллипс, " + "площадь : " + area();
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(fillColor);
        gr.setStroke(strokeColor);
        gr.fillOval(x, y, radiusX, radiusY);
        gr.strokeOval(x, y, radiusX, radiusY);
    }
}