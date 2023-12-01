
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainStage extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        try {
            
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CarMain.fxml"));
            Pane root = loader.load();
            
            // Create the scene and set it on the stage
            Scene scene = new Scene(root);
          
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.setTitle("CARSTAR Application");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}