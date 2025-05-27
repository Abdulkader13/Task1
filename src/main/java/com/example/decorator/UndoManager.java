package com.example.decorator;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class UndoManager {
    private final List<Node> decorations = new ArrayList<>();

    public void register(Node node) {
        decorations.add(node);
    }

    public void undoLast(Pane pane) {
        if (!decorations.isEmpty()) {
            Node last = decorations.remove(decorations.size() - 1);
            pane.getChildren().remove(last);
        }
    }

    public void clear() {
        decorations.clear();
    }
}
