package com.example.abstractclass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.ActionEvent;


public class HelloController {
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private ColorPicker strokeColorPicker;
    @FXML
    private Slider sizeSlider;
    @FXML
    private TextField xTextField;
    @FXML
    private TextField yTextField;
    @FXML
    private TextField shapeCount;
    @FXML
    private Button rectangleButton;
    @FXML
    private Button ellipseButton;
    @FXML
    private Button roundedRectangleButton;
    @FXML
    private Button squareButton;
    @FXML
    private Label lastShapeLabel;

    private GraphicsContext graphicsContext;

    @FXML
    public void initialize() {
        graphicsContext = canvas.getGraphicsContext2D();
    }

    private void drawShapes(Shape shape, int count) {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < count; i++) {
            shape.draw(graphicsContext);
            shape.x += 200;
        }
        lastShapeLabel.setText("Последняя фигура: " + shape.toString());
    }

    @FXML
    public void Rectangle(ActionEvent actionEvent) {
        int count = Integer.parseInt(shapeCount.getText());
        drawShapes(new Rectangle(fillColorPicker.getValue(), strokeColorPicker.getValue(),
                Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText()), sizeSlider.getValue()), count);
    }

    @FXML
    public void Ellipse(ActionEvent actionEvent) {
        int count = Integer.parseInt(shapeCount.getText());
        drawShapes(new Ellipse(fillColorPicker.getValue(), strokeColorPicker.getValue(),
                Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText()), sizeSlider.getValue()), count);
    }

    @FXML
    public void RoundedRectangle(ActionEvent actionEvent) {
        int count = Integer.parseInt(shapeCount.getText());
        drawShapes(new RoundedRectangle(fillColorPicker.getValue(), strokeColorPicker.getValue(),
                Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText()), sizeSlider.getValue()), count);
    }

    @FXML
    public void Square(ActionEvent actionEvent) {
        int count = Integer.parseInt(shapeCount.getText());
        drawShapes(new Square(fillColorPicker.getValue(), strokeColorPicker.getValue(),
                Double.parseDouble(xTextField.getText()), Double.parseDouble(yTextField.getText()), sizeSlider.getValue()), count);
    }
}