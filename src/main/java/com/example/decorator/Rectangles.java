package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangles extends TreeDecorator {
    private final Color color;
    private final double xPosition;
    private final double yPosition;

    // Store the rectangle for undo purposes
    private Rectangle rectangle;

    public Rectangles(ChristmasTree tree, Color color, double xPosition, double yPosition) {
        super(tree);
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void draw(Pane pane) {
        drawRectangle(pane);
    }

    private void drawRectangle(Pane pane) {
        rectangle = new Rectangle(xPosition, yPosition, 60, 40);
        rectangle.setFill(color);
        pane.getChildren().add(rectangle);
    }

    // Getter to access the rectangle node
    public Rectangle getRectangle() {
        return rectangle;
    }
}
