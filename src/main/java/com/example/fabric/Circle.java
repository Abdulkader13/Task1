package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(100, 100, 100, 100);
    }

    @Override
    public String descriptor() {
        return "Круг";
    }
}