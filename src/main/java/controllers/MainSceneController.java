package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.NotificationManager;
import main.NotificationSound;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    public TextField title;
    @FXML
    public TextField subTitle;
    @FXML
    public ComboBox soundPicker;
    @FXML
    public Spinner actions;
    @FXML
    public Button showBtn;
    @FXML
    public CheckBox avatar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> sounds = new ArrayList<>();
        for (NotificationSound sound : NotificationSound.values()) {
            sounds.add(sound.value);
        }
        soundPicker.setItems(FXCollections.observableArrayList(sounds));

        soundPicker.getSelectionModel().select(0);

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 1);

        actions.setValueFactory(valueFactory);

        showBtn.setOnMouseClicked(event -> {

            String avatarPath = null;

            if (avatar.isSelected()) {
                avatarPath = new File(this.getClass().getResource("/avatar.png").getPath()).getAbsolutePath();
            }

            int action = (Integer)actions.getValue();

            ArrayList<String> actions = new ArrayList<>();
            for (int i = 0; i < action; i++) {
                actions.add("Action " + (i + 1));
            }

            String act[] = actions.toArray(new String[actions.size()]);

            NotificationManager.getInstance().postNotification(title.getText(), subTitle.getText(), 1, avatarPath,
                    NotificationSound.valueOf(sounds.get(soundPicker.getSelectionModel().getSelectedIndex())), act);

        });
    }

}
