package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Straight extends Shape {

    public Straight(Color color) {
        super(color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(2);
        gc.strokeLine(50, 100, 250, 100);
    }

    @Override
    public String descriptor() {
        return "Straight";
    }
}