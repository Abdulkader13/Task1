package com.example.fabric;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected Color color;

    // Конструктор для установки цвета фигуры
    public Shape(Color color) {
        this.color = color;
    }

    // Абстрактные методы
    public abstract void draw(GraphicsContext gc);
    public abstract String descriptor();
}