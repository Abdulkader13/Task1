package com.example.decorator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ColorPicker;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Pane paneTree;
    @FXML
    private CheckBox girlandsCheckBox;
    @FXML
    private CheckBox presentsCheckBox;
    @FXML
    private CheckBox starCheckBox;
    @FXML
    private Label statusLabel;
    @FXML
    private ColorPicker colorPicker;

    private ChristmasTree tree;

    // Boolean flags to track the selected decoration
    private boolean isStarSelected = false;
    private boolean isPresentsSelected = false;
    private boolean isGirlandsSelected = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
        updateStatus();
    }

    // Handle mouse click to add decoration at clicked position
    @FXML
    private void handleMouseClick(MouseEvent event) {
        double xClicked = event.getX(); // X-coordinate where clicked
        double yClicked = event.getY(); // Y-coordinate where clicked
        Color color = colorPicker.getValue(); // Get the selected color from the color picker

        // Add decoration based on the selected checkbox
        if (isGirlandsSelected) {
            tree = new Girlands(tree, color, xClicked, yClicked);
            tree.draw(paneTree);
        } else if (isPresentsSelected) {
            tree = new Presents(tree, color, xClicked, yClicked);
            tree.draw(paneTree);
        } else if (isStarSelected) {
            tree = new Star(tree, color, xClicked, yClicked);
            tree.draw(paneTree);
        }

        updateStatus();
    }

    // Toggle Star selection
    @FXML
    private void toggleStar() {
        // Ensure only one checkbox is selected at a time
        isStarSelected = !isStarSelected;
        if (isStarSelected) {
            isPresentsSelected = false;
            isGirlandsSelected = false;
            starCheckBox.setSelected(true);
            presentsCheckBox.setSelected(false);
            girlandsCheckBox.setSelected(false);
        }
    }

    // Toggle Presents selection
    @FXML
    private void togglePresents() {
        // Ensure only one checkbox is selected at a time
        isPresentsSelected = !isPresentsSelected;
        if (isPresentsSelected) {
            isStarSelected = false;
            isGirlandsSelected = false;
            presentsCheckBox.setSelected(true);
            starCheckBox.setSelected(false);
            girlandsCheckBox.setSelected(false);
        }
    }

    // Toggle Girlands selection
    @FXML
    private void toggleGirlands() {
        // Ensure only one checkbox is selected at a time
        isGirlandsSelected = !isGirlandsSelected;
        if (isGirlandsSelected) {
            isStarSelected = false;
            isPresentsSelected = false;
            girlandsCheckBox.setSelected(true);
            starCheckBox.setSelected(false);
            presentsCheckBox.setSelected(false);
        }
    }

    // Remove all decorations
    public void removeAllDecorations(ActionEvent actionEvent) {
        girlandsCheckBox.setSelected(false);
        presentsCheckBox.setSelected(false);
        starCheckBox.setSelected(false);
        paneTree.getChildren().clear(); // Clear all decorations
        tree = new ChristmasTreeImpl(); // Reset to basic tree
        tree.draw(paneTree); // Draw only the basic tree
        updateStatus(); // Update the status after clearing decorations
    }

    private void updateStatus() {
        StringBuilder status = new StringBuilder("Decor: Christmas Tree");
        float totalCost = tree.cost();

        if (isGirlandsSelected) {
            status.append(", Garland");
            totalCost += 50; // Cost of the garland
        }
        if (isPresentsSelected) {
            status.append(", Presents");
            totalCost += 80; // Cost of the presents
        }
        if (isStarSelected) {
            status.append(", Star");
            totalCost += 100; // Cost of the star
        }

        statusLabel.setText(status.toString() + " | Total cost: " + totalCost);
    }
}
