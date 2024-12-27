package com.example.keeper;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Memento {
    private Shape shape;
    private double width;
    private Color color;

    public Memento(Shape state) {
        this.shape = state;
        width = shape.getStrokeWidth();
        color = (Color) shape.getStroke();
    }

    public double getWidth() {
        return width;
    }

    public Color getStrokeColor() {
        return color;
    }

    public Shape getState() {
        shape.setStrokeWidth(width);
        shape.setStroke(color);
        return shape;
    }

    public Shape initState() {
        shape.setStrokeWidth(2);
        shape.setStroke(Color.RED);
        return shape;
    }
}