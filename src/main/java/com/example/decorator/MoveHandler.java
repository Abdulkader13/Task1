package com.example.decorator;

import javafx.scene.Node;

import java.util.List;

public class MoveHandler {

    public void makeDraggable(Node node, boolean multiMode, List<Node> selectionList) {
        final Delta dragDelta = new Delta();

        // Click to select (or multi-select)
        node.setOnMouseClicked(event -> {
            if (multiMode) {
                if (selectionList.contains(node)) {
                    selectionList.remove(node);
                    node.setStyle(""); // remove highlight
                } else {
                    selectionList.add(node);
                    node.setStyle("-fx-opacity: 0.7; -fx-stroke: black; -fx-stroke-width: 1;");
                }
            } else {
                for (Node n : selectionList) n.setStyle(""); // clear previous styles
                selectionList.clear();
                selectionList.add(node);
                node.setStyle("-fx-opacity: 0.7; -fx-stroke: black; -fx-stroke-width: 1;");
            }
        });

        // Start drag
        node.setOnMousePressed(event -> {
            if (!selectionList.contains(node)) return;
            dragDelta.x = event.getX();
            dragDelta.y = event.getY();
        });

        // Move all selected nodes
        node.setOnMouseDragged(event -> {
            if (!selectionList.contains(node)) return;
            for (Node selected : selectionList) {
                selected.setLayoutX(selected.getLayoutX() + event.getX() - dragDelta.x);
                selected.setLayoutY(selected.getLayoutY() + event.getY() - dragDelta.y);
            }
        });
    }

    private static class Delta {
        double x, y;
    }
}
