package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class ChristmasTreeImpl implements ChristmasTree {
    @Override
    public void draw(Pane pane) {
        // Рисуем елку в виде треугольника
        Polygon tree = new Polygon();
        tree.getPoints().addAll(
                239.0, 90.0,   // Вершина (по координатам звезды)
                100.0, 370.0,  // Левый угол (изменено для удлинения)
                380.0, 370.0   // Правый угол (изменено для удлинения)
        );
        tree.setFill(Color.GREEN);
        pane.getChildren().add(tree);
    }

    @Override
    public String decorate() {
        return "Christmas Tree";
    }

    @Override
    public float cost() {
        return 100; // Базовая стоимость елки
    }
}
