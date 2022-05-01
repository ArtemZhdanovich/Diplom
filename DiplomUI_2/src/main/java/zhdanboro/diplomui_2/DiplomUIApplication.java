package zhdanboro.diplomui_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class DiplomUIApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DiplomUIApplication.class.getResource("analyzerXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Analyzer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void iks(HashMap<String, String> map) {
        System.out.println(map);
    }
}