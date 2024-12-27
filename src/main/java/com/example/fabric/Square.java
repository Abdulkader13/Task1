package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(100, 100, 100, 100);
    }

    @Override
    public String descriptor() {
        return "Sqaure";
    }
}