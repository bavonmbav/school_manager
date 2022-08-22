
package school_manager;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class School_manager extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      
        Parent root ;
        FXMLLoader racine = new FXMLLoader(getClass().getResource("/splashe/splash.fxml"));
        root = racine.load();
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
      
    }

 
    public static void main(String[] args) {
        launch(args);
    }
    
}
