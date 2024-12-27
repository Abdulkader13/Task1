package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillPolygon(new double[]{100, 150, 200}, new double[]{100, 50, 100}, 3);
    }

    @Override
    public String descriptor() {
        return "Triangle";
    }
}