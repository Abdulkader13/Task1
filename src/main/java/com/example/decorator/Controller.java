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
    private CheckBox multiSelectCheckBox; // Only this remains

    private ChristmasTree tree;

    private boolean isStarSelected = false;
    private boolean isrectanglesSelected = false;
    private boolean isGirlandsSelected = false;
    private boolean isMultiSelectEnabled = false;

    private final MoveHandler moveHandler = new MoveHandler();
    private final UndoManager undoManager = new UndoManager();
    private final List<Node> selectedNodes = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
        updateStatus();
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
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
            undoManager.register(added);
            moveHandler.makeDraggable(added, isMultiSelectEnabled, selectedNodes);
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
        undoManager.clear();
        selectedNodes.clear();
        updateStatus();
    }

    @FXML
    public void undoLastDecoration() {
        undoManager.undoLast(paneTree);
    }

    @FXML
    private void toggleMultiSelectMode() {
        isMultiSelectEnabled = multiSelectCheckBox.isSelected();
        selectedNodes.clear(); // start fresh
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
