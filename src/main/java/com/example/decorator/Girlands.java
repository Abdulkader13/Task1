package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Girlands extends TreeDecorator {
    private Color color;
    private double xPosition, yPosition;

    public Girlands(ChristmasTree tree, Color color, double xPosition, double yPosition) {
        super(tree);
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawWithGirlands(pane);
    }

    private void drawWithGirlands(Pane pane) {
        Circle circle = new Circle(xPosition, yPosition, 10, color);
        pane.getChildren().add(circle);
    }
}
