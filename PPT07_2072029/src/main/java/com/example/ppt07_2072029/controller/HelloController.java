package com.example.ppt07_2072029.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class HelloController {
    @FXML
    private TextArea txtFile;
    private Path path;

    public void OnOpen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(txtFile.getScene().getWindow());
        path = Paths.get(file.toURI());
        try {
            txtFile.clear();
            List<String> allLines = Files.readAllLines(path);
            for (String string: allLines) {
                txtFile.appendText(string + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void OnSave(ActionEvent actionEvent) {
        if (path != null) {
            try {
                Files.write(path, txtFile.getText().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            OnSaveAs();
        }
        txtFile.clear();
    }

    public void OnSaveAs() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showSaveDialog(txtFile.getScene().getWindow());
        path = Paths.get(file.toURI());
        if (file != null) {
            path = Paths.get(file.toURI());
            try {
                Files.write(path, txtFile.getText().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        txtFile.clear();
    }
}