package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Angle extends Shape {

    public Angle(Color color) {
        super(color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(2);
        gc.strokeLine(200, 200, 150, 150); // Первая линия
        gc.strokeLine(200, 200, 250, 150); // Вторая линия
    }

    @Override
    public String descriptor() {
        return "Угол";
    }
}