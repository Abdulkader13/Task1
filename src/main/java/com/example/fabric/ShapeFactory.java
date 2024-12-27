package com.example.fabric;
import javafx.scene.paint.Color;

public class ShapeFactory {
    public Shape createPolygon(int numberOfSides, Color color) {
        if (numberOfSides == 5) {
            return new Pentagon(color);
        } else if (numberOfSides == 4) {
            return new Square(color);
        } else if (numberOfSides == 3) {
            return new Triangle(color);
        } else if (numberOfSides == 2) {
            return new Angle(color);
        } else if (numberOfSides == 1) {
            return new Straight(color);
        } else if (numberOfSides == 0) {
            return new Circle(color);
        } else {
            return null;
        }
    }
}