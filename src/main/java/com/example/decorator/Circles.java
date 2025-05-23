package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circles extends TreeDecorator {
    private final Color color;
    private final double xPosition;
    private final double yPosition;

    // Store the circle so it can be accessed later for undo
    private Circle circle;

    public Circles(ChristmasTree tree, Color color, double xPosition, double yPosition) {
        super(tree);
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void draw(Pane pane) {
        drawCircle(pane);
    }

    private void drawCircle(Pane pane) {
        circle = new Circle(xPosition, yPosition, 10, color);
        pane.getChildren().add(circle);
    }

    // Allow access to the circle for undo functionality
    public Circle getCircle() {
        return circle;
    }
}
