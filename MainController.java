import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane main_anchor;

    @FXML
    private AnchorPane side_anchor;

  

    @FXML
    private Button close;

    @FXML
    private Button Log_out_button;

    @FXML
    private Label Hello;

    @FXML 
    private Label name_Label;

    LoginController l1= new LoginController();
    public void displayname(String username){
        name_Label.setText(username);
    }

    public void close(){
        System.exit(0);
    }
    
    public void SwitchToLoginPage(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("CarMain.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToHatchBackPage(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("Hatchback_cars.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO 
    }
    
    
    
}
