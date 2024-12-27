package com.example.decorator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

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

    private ChristmasTree tree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tree = new ChristmasTreeImpl();
        tree.draw(paneTree);
        updateStatus();
    }

    public void addLights(ActionEvent actionEvent) {
        if (girlandsCheckBox.isSelected()) {
            tree = new Girlands(tree); // Обновляем ссылку на tree
            tree.draw(paneTree);
            updateStatus();
        }
    }

    public void addPresents(ActionEvent actionEvent) {
        if (presentsCheckBox.isSelected()) {
            tree = new Presents(tree); // Обновляем ссылку на tree
            tree.draw(paneTree);
            updateStatus();
        }
    }

    public void addStar(ActionEvent actionEvent) {
        if (starCheckBox.isSelected()) {
            tree = new Star(tree); // Обновляем ссылку на tree
            tree.draw(paneTree);
            updateStatus();
        }
    }

    public void addAllDecorations(ActionEvent actionEvent) {
        girlandsCheckBox.setSelected(true);
        presentsCheckBox.setSelected(true);
        starCheckBox.setSelected(true);
        addLights(actionEvent);
        addPresents(actionEvent);
        addStar(actionEvent);
    }

    public void removeAllDecorations(ActionEvent actionEvent) {
        girlandsCheckBox.setSelected(false);
        presentsCheckBox.setSelected(false);
        starCheckBox.setSelected(false);
        paneTree.getChildren().clear(); // Очищаем только содержимое
        tree = new ChristmasTreeImpl(); // Сбрасываем ссылку на базовую елку
        tree.draw(paneTree); // Рисуем только елку
        updateStatus();
    }

    private void updateStatus() {
        StringBuilder status = new StringBuilder("Decor: Christmas Tree");
        float totalCost = tree.cost();

        if (girlandsCheckBox.isSelected()) {
            status.append(", Garland");
            totalCost += 50; // стоимость гирлянды
        }
        if (presentsCheckBox.isSelected()) {
            status.append(", Presents");
            totalCost += 80; // стоимость подарков
        }
        if (starCheckBox.isSelected()) {
            status.append(", Star");
            totalCost += 100; // стоимость звезды
        }

        statusLabel.setText(status.toString() + " | Total cost: " + totalCost);
    }
}