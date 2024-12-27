package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        double[] x = {150, 180, 210, 180, 120};
        double[] y = {50, 100, 150, 200, 200};
        gc.fillPolygon(x, y, 5);
    }

    @Override
    public String descriptor() {
        return "Pentagon";
    }
}