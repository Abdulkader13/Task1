package com.example.keeper;
import javafx.scene.shape.Shape;
public class Originator {
    private Shape shape;

    // Установка фигуры
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    // Создание снимка (Memento)
    public Memento createMemento() {
        return new Memento(shape);
    }

    // Восстановление состояния из Memento
    public void restoreFromMemento(Memento memento) {
        shape.setStrokeWidth(memento.getWidth());
        shape.setStroke(memento.getStrokeColor());
        // Восстановление других свойств при необходимости
    }
}