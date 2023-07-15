package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    public TextField title;
    @FXML
    public TextField subTitle;
    @FXML
    public ComboBox soundPicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        soundPicker.setItems(FXCollections.observableArrayList("Default", "a", "b"));

        soundPicker.getSelectionModel().select(0);
    }

}
