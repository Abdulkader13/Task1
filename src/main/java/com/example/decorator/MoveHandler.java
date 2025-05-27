package com.example.decorator;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class MoveHandler {
    private boolean moveModeEnabled;

    public void setMoveModeEnabled(boolean enabled) {
        this.moveModeEnabled = enabled;
    }

    public void makeDraggable(Node node) {
        final Delta dragDelta = new Delta();

        node.setOnMousePressed((MouseEvent event) -> {
            if (!moveModeEnabled) return;
            dragDelta.x = event.getX();
            dragDelta.y = event.getY();
            node.toFront();
        });

        node.setOnMouseDragged((MouseEvent event) -> {
            if (!moveModeEnabled) return;
            node.setLayoutX(node.getLayoutX() + event.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + event.getY() - dragDelta.y);
        });
    }

    private static class Delta {
        double x, y;
    }
}
