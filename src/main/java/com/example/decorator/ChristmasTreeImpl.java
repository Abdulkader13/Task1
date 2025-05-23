package com.example.decorator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class ChristmasTreeImpl implements ChristmasTree {
    @Override
    public void draw(Pane pane) {
        // Draw the tree as a triangle
        Polygon tree = new Polygon();
        tree.getPoints().addAll(
                239.0, 90.0,   // Top point (coordinates of the star)
                100.0, 370.0,  // Left corner (modified for elongation)
                380.0, 370.0   // Right corner (modified for elongation)
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
        return 100; // Base cost of the tree
    }
}
