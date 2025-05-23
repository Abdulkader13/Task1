package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangles extends TreeDecorator {
    private final Color color;
    private final double xPosition;
    private final double yPosition;

    public Rectangles(ChristmasTree tree, Color color, double xPosition, double yPosition) {
        super(tree);
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void draw(Pane pane) {
        super.draw(pane);
        drawWithRectangles(pane);
    }

    private void drawWithRectangles(Pane pane) {
        Rectangle Rectangle = new Rectangle(xPosition, yPosition, 60, 40);
        Rectangle.setFill(color);
        pane.getChildren().add(Rectangle);
    }
}
