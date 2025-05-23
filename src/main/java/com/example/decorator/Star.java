package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Star extends TreeDecorator {
    private final Color color;
    private final double xPosition;
    private final double yPosition;

    // Store the star shape for undo
    private Path star;

    public Star(ChristmasTree tree, Color color, double xPosition, double yPosition) {
        super(tree);
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void draw(Pane pane) {
        drawStar(pane);
    }

    private void drawStar(Pane pane) {
        star = new Path();
        star.getElements().addAll(
                new MoveTo(xPosition, yPosition - 20),
                new LineTo(xPosition - 20, yPosition + 10),
                new LineTo(xPosition + 20, yPosition + 10),
                new ClosePath()
        );

        star.setFill(color);
        pane.getChildren().add(star);
    }

    // Getter to access the star node for undo
    public Path getStar() {
        return star;
    }
}
