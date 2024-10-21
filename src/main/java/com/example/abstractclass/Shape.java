package com.example.abstractclass;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected Color fillColor;
    protected Color strokeColor;
    protected double x, y;
    protected double size;

    public Shape(Color fillColor, Color strokeColor, double x, double y, double size) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    abstract double area();

    abstract void draw(GraphicsContext gr);
}