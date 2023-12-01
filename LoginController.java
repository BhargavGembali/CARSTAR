import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class LoginController implements Initializable  {
    

     @FXML
    private Button LoginBtn;

    @FXML
    private AnchorPane Sign_frame;

    @FXML
    private AnchorPane Sign_up_frame;

    @FXML
    private Button close;

    @FXML
    private Button eye;

    @FXML
    private AnchorPane frame;

    @FXML
    private Label label_pass;

    @FXML
    private Label label_pass1;

    @FXML
    private Label logo_img;

    @FXML
    private PasswordField password_field;

    @FXML
    private Label password_label;

    @FXML
    private Button register_here_btn;

    @FXML
    private AnchorPane side_frame;

    @FXML
    private Label sign_label;

    @FXML
    private PasswordField sign_password_field;

    @FXML
    private Button sign_up_btn;

    @FXML
    private Button sign_up_eye;

    @FXML
    private Rectangle sign_up_field;

    @FXML
    private Label sign_up_label;

    @FXML
    private Label sign_up_password_label;

    @FXML
    private TextField sign_up_user_field;

    @FXML
    private Label sumbit;

    @FXML
    private Label sumbit1;

    @FXML
    private TextField user_field;

    
    @FXML
    private Button already_have_btn;
    private Alert alert;

    public void register(){
        if(sign_up_user_field.getText().isEmpty() || sign_password_field.getText().isEmpty()){
            alert= new Alert(AlertType.ERROR);
            alert.setTitle("ERROR MESSAGE");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blank fields");
            alert.showAndWait();
        }else{
            String regData= "INSERT INTO admin2(username , password)"+"VALUES(?,?)";
            connect= database.connectDB();
            try{
                prepare= connect.prepareStatement(regData);
                prepare.setString(1, sign_up_user_field.getText());
                prepare.setString(2, sign_password_field.getText());
                prepare.executeUpdate();
                alert= new Alert(AlertType.INFORMATION);
                alert.setTitle("INFO MESSAGE");
                alert.setHeaderText(null);
                alert.setContentText("Registered successfully");
                alert.showAndWait();
                sign_up_user_field.setText("");
                sign_password_field.setText("");

                TranslateTransition slider= new TranslateTransition();

                slider.setNode(side_frame);
                slider.setToX(0);
                slider.setDuration(Duration.seconds(0.5));
                slider.setOnFinished((ActionEvent e) -> {
                already_have_btn.setVisible(false);
                register_here_btn.setVisible(true);
                });
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void SwitchLoggedForm(ActionEvent event){
        TranslateTransition slider= new TranslateTransition();
        if(event.getSource()== register_here_btn){
        slider.setNode(side_frame);
        slider.setToX(450);
        slider.setDuration(Duration.seconds(0.5));
        slider.setOnFinished((ActionEvent e) -> {
            already_have_btn.setVisible(true);
            register_here_btn.setVisible(false);
        });
        slider.play();
        }
        else if(event.getSource()== already_have_btn){
            slider.setNode(side_frame);
        slider.setToX(0);
        slider.setDuration(Duration.seconds(0.5));
        slider.setOnFinished((ActionEvent e) -> {
            already_have_btn.setVisible(false);
            register_here_btn.setVisible(true);
        });
        slider.play();
        }
    }
    

    public void close(){
        System.exit(0);
    }
    
    
     
 @Override
public void initialize(URL location, ResourceBundle resources) {
   
}

    
  

    
    public void show_sign_up(ActionEvent event){
        String sign_up_pass= sign_password_field.getText();
        sign_up_password_label.setText(sign_up_pass);
    }

    public void show(ActionEvent event){
        String password= password_field.getText();
        password_label.setText(password);
       
    }
    
    private static Connection connect;
    private static PreparedStatement prepare;
    private static ResultSet result;

    public void LoginAdmin(){
        
          

        String sql="SELECT * FROM admin2 WHERE username = ? and password = ? ;";

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
                    getData.username= user_field.getText();
                    
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
