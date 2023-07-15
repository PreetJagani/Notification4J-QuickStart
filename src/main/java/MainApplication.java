import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.application.LauncherImpl.launchApplication;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launchApplication(MainApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/main_scene.fxml"));
        try {
            Parent root = loader.load();
            Scene s = new Scene(root);
            primaryStage.setHeight(500);
            primaryStage.setWidth(500);
            primaryStage.setScene(s);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}