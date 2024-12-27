package com.task6.module;

import javafx.scene.canvas.GraphicsContext;

public class TrUg extends Figuri {
    private static final double SIDE = 60;

    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        gc.setFill(color);
        // Переворачиваем треугольник, изменяя координаты для вершин
        double[] xPoints = new double[]{
                x,
                x - SIDE / 2,
                x + SIDE / 2
        };
        double[] yPoints = new double[]{
                y + SIDE * Math.sqrt(3) / 2, // Нижняя вершина теперь будет ниже
                y - SIDE * Math.sqrt(3) / 6, // Левая вершина выше
                y - SIDE * Math.sqrt(3) / 6  // Правая вершина выше
        };
        gc.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
