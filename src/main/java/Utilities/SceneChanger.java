package Utilities;

import com.example.f21comp1011assignment1.BitcoinApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void changeScenes(ActionEvent event, String fxmlFile, String sceneTitle) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(BitcoinApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(sceneTitle);
        stage.setScene(scene);
        stage.show();
    }
}
