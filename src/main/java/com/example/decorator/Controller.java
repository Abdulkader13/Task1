package com.example.decorator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Pane paneTree;
    @FXML
    private CheckBox circlesCheckBox;
    @FXML
    private CheckBox rectanglesCheckBox;
    @FXML
    private CheckBox starCheckBox;
    @FXML
    private Label statusLabel;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private CheckBox moveCheckBox;

    private ChristmasTree tree;

    private boolean isStarSelected = false;
    private boolean isrectanglesSelected = false;
    private boolean isGirlandsSelected = false;
    private boolean isMoveModeEnabled = false;

    private final List<Node> addedDecorations = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
        updateStatus();
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        if (isMoveModeEnabled) return; // Prevent adding while moving is enabled

        double xClicked = event.getX();
        double yClicked = event.getY();
        Color color = colorPicker.getValue();

        Node added = null;

        if (isGirlandsSelected) {
            Circles circle = new Circles(tree, color, xClicked, yClicked);
            circle.draw(paneTree);
            added = circle.getCircle();
        } else if (isrectanglesSelected) {
            Rectangles rect = new Rectangles(tree, color, xClicked, yClicked);
            rect.draw(paneTree);
            added = rect.getRectangle();
        } else if (isStarSelected) {
            Star star = new Star(tree, color, xClicked, yClicked);
            star.draw(paneTree);
            added = star.getStar();
        }

        if (added != null) {
            addedDecorations.add(added);
            makeDraggable(added); // Enable drag behavior
        }

        updateStatus();
    }

    @FXML
    private void toggleStar() {
        isStarSelected = !isStarSelected;
        if (isStarSelected) {
            isrectanglesSelected = false;
            isGirlandsSelected = false;
            starCheckBox.setSelected(true);
            rectanglesCheckBox.setSelected(false);
            circlesCheckBox.setSelected(false);
        }
    }

    @FXML
    private void toggleRectangles() {
        isrectanglesSelected = !isrectanglesSelected;
        if (isrectanglesSelected) {
            isStarSelected = false;
            isGirlandsSelected = false;
            rectanglesCheckBox.setSelected(true);
            starCheckBox.setSelected(false);
            circlesCheckBox.setSelected(false);
        }
    }

    @FXML
    private void toggleCircles() {
        isGirlandsSelected = !isGirlandsSelected;
        if (isGirlandsSelected) {
            isStarSelected = false;
            isrectanglesSelected = false;
            circlesCheckBox.setSelected(true);
            starCheckBox.setSelected(false);
            rectanglesCheckBox.setSelected(false);
        }
    }

    @FXML
    public void removeAllDecorations() {
        circlesCheckBox.setSelected(false);
        rectanglesCheckBox.setSelected(false);
        starCheckBox.setSelected(false);
        paneTree.getChildren().clear();
        tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
        addedDecorations.clear();
        updateStatus();
    }

    @FXML
    public void undoLastDecoration() {
        if (!addedDecorations.isEmpty()) {
            Node last = addedDecorations.remove(addedDecorations.size() - 1);
            paneTree.getChildren().remove(last);
        }
    }

    @FXML
    private void toggleMoveMode() {
        isMoveModeEnabled = moveCheckBox.isSelected(); // Reflect checkbox state
    }

    private void makeDraggable(Node node) {
        final Delta dragDelta = new Delta();

        node.setOnMousePressed(event -> {
            if (!isMoveModeEnabled) return;
            dragDelta.x = event.getX();
            dragDelta.y = event.getY();
            node.toFront();
        });

        node.setOnMouseDragged(event -> {
            if (!isMoveModeEnabled) return;
            node.setLayoutX(node.getLayoutX() + event.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + event.getY() - dragDelta.y);
        });
    }

    private static class Delta {
        double x, y;
    }

    private void updateStatus() {
        StringBuilder status = new StringBuilder("Decor: Christmas Tree");
        float totalCost = tree.cost();

        if (isGirlandsSelected) {
            status.append(", Rectangles");
            totalCost += 50;
        }
        if (isrectanglesSelected) {
            status.append(", Circles");
            totalCost += 80;
        }
        if (isStarSelected) {
            status.append(", Star");
            totalCost += 100;
        }

        statusLabel.setText(status + " | Total cost: " + totalCost);
    }
}
