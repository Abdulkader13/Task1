package com.task6.module;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class kvadr extends Figuri {

    private double size;

    // Конструктор квадрата с размером
    public kvadr(double size) {
        this.size = size;
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y) {
        setXY(x - size / 2, y - size / 2); // Центрируем квадрат на курсоре
        gc.setFill(color); // Устанавливаем цвет
        gc.fillRect(x - size / 2, y - size / 2, size, size); // Рисуем квадрат с учетом сдвига
    }

    @Override
    public String toString() {
        return "Square";
    }
}
