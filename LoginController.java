import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginController implements Initializable  {
    

    @FXML
    private AnchorPane frame;

    @FXML
    private Label logo_img;

    @FXML
    private AnchorPane Sign_frame;

    @FXML
    private Label sign_label;

    @FXML
    private TextField user_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button LoginBtn;

    @FXML
    private Button close;

    @FXML
    private Label sumbit;

    @FXML
    private Label label_pass;

    @FXML
    private Label password_label;

    @FXML
    private Button eye;

    public void close(){
        System.exit(0);
    }
    
    
     
 @Override
public void initialize(URL location, ResourceBundle resources) {
   
}

    
  

    

    public void show(ActionEvent event){
        String password= password_field.getText();
        password_label.setText(password);
       
    }
    
    private static Connection connect;
    private static PreparedStatement prepare;
    private static ResultSet result;

    public void LoginAdmin(){
        
          

        String sql="SELECT * FROM admin WHERE username = ? and password = ? ;";

        connect= database.connectDB();

        try{
            prepare= connect.prepareStatement(sql);
            prepare.setString(1, user_field.getText());
            prepare.setString(2, password_field.getText());
            result = prepare.executeQuery();

            Alert alert;
            if(user_field.getText().isEmpty() || password_field.getText().isEmpty()){
                alert= new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields.");
                alert.showAndWait();
            }else{
                if(result.next()){
                alert= new Alert(AlertType.INFORMATION);
                alert.setTitle("INFORMATION message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Logged in.");
                alert.showAndWait();
                LoginBtn.getScene().getWindow().hide();;
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                
                Stage stage= new Stage();
                Scene scene= new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
                }
                else{
                    alert= new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Credentials.");
                alert.showAndWait();
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
