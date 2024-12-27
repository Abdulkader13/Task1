package com.example.keeper;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Pane drawingPanel;
    private double initialX;
    private double initialY;
    private double mouseX;
    private double mouseY;
    private List<Shape> picture;
    private List<Shape> selectedShapes;
    private Caretaker caretaker;
    private Originator originator = new Originator();

    public void initialize() {
        caretaker = new Caretaker();

        picture = new ArrayList<>();
        selectedShapes = new ArrayList<>();

    }

    @FXML
    public void addCircle1() {
        Circle circle1 = new Circle(50, 50, 40);
        circle1.setFill(Color.BLUE);
        addShape(circle1);
    }

    @FXML
    public void addCircle2() {
        Circle circle2 = new Circle(100, 100, 40, Color.YELLOW);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(2.0);
        addShape(circle2);
    }

    @FXML
    public void addRectangle1() {
        Rectangle rectangle1 = new Rectangle(20, 50, Color.GREEN);
        addShape(rectangle1);
    }

    @FXML
    public void addRectangle2() {
        Rectangle rectangle2 = new Rectangle(30, 20, 100, 50);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setArcWidth(10);
        addShape(rectangle2);
    }

    @FXML
    public void addTriangle() {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 0.0, 0.0, 50.0, 100.0, 50.0);
        triangle.setFill(Color.PURPLE);
        triangle.setStroke(Color.RED);
        addShape(triangle);
    }

    @FXML
    public void addParallelogram() {
        Polygon parallelogram = new Polygon();
        parallelogram.getPoints().addAll(30.0, 0.0, 130.0, 0.0, 100.0, 50.0, 0.0, 50.0);
        parallelogram.setFill(Color.YELLOW);
        parallelogram.setStroke(Color.BLACK);
        addShape(parallelogram);
    }

    @FXML
    public void addHexagon() {
        Polygon hexagon = new Polygon(100.0, 0.0, 120.0, 20.0, 120.0, 40.0, 100.0, 60.0, 80.0, 40.0, 80.0, 20.0);
        hexagon.setFill(Color.ORANGE);
        hexagon.setStroke(Color.BLACK);
        addShape(hexagon);
    }

    private void addShape(Shape shape) {
        picture.add(shape);
        drawingPanel.getChildren().add(shape);

        shape.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> handleShapePress(shape, event));
        shape.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onDrag);
        shape.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onEnd);
    }

    private void handleShapePress(Shape shape, MouseEvent event) {
        originator.setShape(shape);
        caretaker.push(originator.createMemento());

        if (event.isControlDown()) {
            if (selectedShapes.contains(shape)) {
                selectedShapes.remove(shape);
                shape.setStroke(null);
            } else {
                selectedShapes.add(shape);
                shape.setStroke(Color.RED);
            }
        } else {
            selectedShapes.clear();
            selectedShapes.add(shape);
            shape.setStroke(Color.RED);
        }

        initialX = shape.getLayoutX();
        initialY = shape.getLayoutY();
        mouseX = event.getSceneX();
        mouseY = event.getSceneY();
    }

    public void onDrag(MouseEvent mouseEvent) {
        if (!selectedShapes.isEmpty()) {
            double offsetX = mouseEvent.getSceneX() - mouseX;
            double offsetY = mouseEvent.getSceneY() - mouseY;

            for (Shape shape : selectedShapes) {
                shape.setLayoutX(initialX + offsetX);
                shape.setLayoutY(initialY + offsetY);
            }
        }
    }

    public void onEnd(MouseEvent mouseEvent) {
        if (!selectedShapes.isEmpty()) {
            initialX = selectedShapes.get(0).getLayoutX();
            initialY = selectedShapes.get(0).getLayoutY();
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
        }
    }
    @FXML
    public void removeLastShape() {
        if (!picture.isEmpty()) {
            Shape lastShape = picture.remove(picture.size() - 1);
            drawingPanel.getChildren().remove(lastShape);
        }
    }
}
