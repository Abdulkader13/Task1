package com.task6;

import com.task6.module.Figuri;
import com.task6.module.TrUg;
import com.task6.module.krug;
import com.task6.module.PrUg;
import com.task6.module.kvadr;  // Добавляем импорт для квадрата

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<Figuri> listView; // Используем ListView для выбора фигуры
    @FXML
    private Canvas canvas; // Область рисования
    @FXML
    private ColorPicker colorPicker; // Выбор цвета

    private ObservableList<Figuri> content; // Коллекция фигур
    private GraphicsContext gc; // Контекст для рисования

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Создаем экземпляры фигур
        krug circle = new krug();
        PrUg rectangle = new PrUg();
        TrUg triangle = new TrUg();
        kvadr square = new kvadr(50); // Создаем квадрат с размером 50

        // Заполняем список фигур
        content = FXCollections.observableArrayList(circle, rectangle, triangle, square);
        listView.setItems(content); // Устанавливаем ListView для выбора фигуры

        // Получаем GraphicsContext для рисования на Canvas
        gc = canvas.getGraphicsContext2D();

        // Нарисуем границу вокруг области рисования (Canvas)
        drawCanvasBorder();
    }

    // Метод для рисования границ вокруг Canvas
    private void drawCanvasBorder() {
        gc.setStroke(Color.BLACK); // Устанавливаем цвет границы
        gc.setLineWidth(2); // Устанавливаем толщину линии
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Рисуем прямоугольник
    }

    @FXML
    public void drawShape(MouseEvent mouseEvent) {
        // Проверяем, что фигура выбрана
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            // Создаем копию фигуры из списка
            Figuri shape = (Figuri) content.get(index).clone();
            shape.setColor(colorPicker.getValue()); // Устанавливаем выбранный цвет
            shape.draw(gc, mouseEvent.getX(), mouseEvent.getY()); // Рисуем фигуру
        }
    }
}
