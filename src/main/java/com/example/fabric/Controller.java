package com.example.fabric;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private TextField sidesField;

    @FXML
    private MenuButton colorMenu;

    @FXML
    private Canvas canvas;

    @FXML
    private Label descriptionLabel;

    private ShapeFactory shapeFactory = new ShapeFactory();
    private Color selectedColor = Color.ORANGE;

    @FXML
    public void initialize() {
        // Adding handlers for color selection
        MenuItem redItem = new MenuItem("Red");
        redItem.setOnAction(e -> selectedColor = Color.RED);

        MenuItem greenItem = new MenuItem("Green");
        greenItem.setOnAction(e -> selectedColor = Color.GREEN);

        MenuItem blueItem = new MenuItem("Blue");
        blueItem.setOnAction(e -> selectedColor = Color.BLUE);

        MenuItem orangeItem = new MenuItem("Orange");
        orangeItem.setOnAction(e -> selectedColor = Color.ORANGE);

        MenuItem blackItem = new MenuItem("Black");
        blackItem.setOnAction(e -> selectedColor = Color.BLACK);

        MenuItem pinkItem = new MenuItem("Pink");
        pinkItem.setOnAction(e -> selectedColor = Color.PINK);

        colorMenu.getItems().addAll(redItem, greenItem, blueItem, orangeItem, blackItem, pinkItem);
    }

    @FXML
    public void drawShape() {
        if (sidesField.getText().isEmpty()) {
            descriptionLabel.setText("Please enter the number of sides.");
            return;
        }
        int sides;
        try {
            sides = Integer.parseInt(sidesField.getText());
            if (sides < 0) {
                descriptionLabel.setText("The number of sides must be 0 or more.");
                return;
            }
        } catch (NumberFormatException e) {
            descriptionLabel.setText("Please enter a valid number of sides.");
            return;
        }

        // Create the shape using the factory method
        Shape shape = shapeFactory.createPolygon(sides, selectedColor);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (shape != null) {
            String description = shape.descriptor();
            descriptionLabel.setText("Shape: " + description);
            shape.draw(gc);
        } else {
            descriptionLabel.setText("Invalid number of sides!");
        }
    }
}
