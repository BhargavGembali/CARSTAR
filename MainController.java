import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private ImageView User_icon;

    @FXML
    private Button Log_out_button;

    @FXML
    private Button car_news_btn;

    @FXML
    private Text Welcoming_text;

    @FXML
    private AnchorPane car_news_form;

    @FXML
    private WebView car_types_web_view;

    @FXML
    private Button car_types_btn;

    @FXML
    private AnchorPane car_types_form;

    @FXML
    private Button close;
    
    @FXML
    private Button car_news_load;

    @FXML
    private HBox cardlayout;

    @FXML
    private Label comp_name;

    @FXML
    private Button latest_car_btn;

    @FXML
    private AnchorPane latest_car_form;

    @FXML
    private AnchorPane main_anchor;

    @FXML
    private AnchorPane side_anchor;

    @FXML 
    private Label greet_user;

    @FXML
    private Button Cars_24_btn;

    @FXML
    private Button Carwale_btn;

    @FXML 
    private Button Zig_Wheels_btn;

    
    @FXML
    private WebView car_news_web_view;

    @FXML
    private Button Explore_btn;

    @FXML
    private WebView Exp_cars_web_view;

    @FXML
    private AnchorPane Explore_pane;

    @FXML
    private AnchorPane insurances_form;
    
    @FXML
    private Button Insurances_btn;

    @FXML
    private WebView   Insurance_web_view;

    @FXML
    private AnchorPane car_wash_and_services_form;

    @FXML
    private Button car_wash_btn;

    @FXML
    private WebView car_wash_web_view1;

    @FXML
    private ImageView  car_services_img;

    @FXML
    private TextField location_field;

    @FXML
    private Label location_label;


    
    @FXML
    private Button search_location_btn;

    private WebEngine engine;

    private WebEngine engine1;

    private WebEngine engine2;

    private WebEngine engine4;

    public void displayUserName(){
        String SpaceString="";
        for(int i=1; i<=28-getData.username.length(); i++){
            SpaceString+=" ";
        }

        greet_user.setText(SpaceString+getData.username);
        Welcoming_text.setText("Hey "+getData.username+"!\nWelcome To \n CarStar");
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
        displayUserName();
        engine= car_news_web_view.getEngine();
        engine1= Exp_cars_web_view.getEngine();
        engine2= Insurance_web_view.getEngine();
        car_wash_web_view1.getEngine();
        engine4= car_types_web_view.getEngine();
        
        loadPage();
        // TODO 
        ArrayList<Book> recentlyadded = new ArrayList<>(recentlyadded());
        
        for(int i=0; i<recentlyadded.size();i++){
            try {
            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Card.fxml"));
                
                    HBox cardBox= fxmlLoader.load();
                    CardController cardController= fxmlLoader.getController();
                    cardController.setData(recentlyadded.get(i));
                    cardlayout.getChildren().add(cardBox);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                };
        }
    }
    
    public void SwitchForm(ActionEvent event){
        if(event.getSource() == car_types_btn){
            loadTypesPage(event, "https://www.carandbike.com/news/types-of-cars-1450327");
           
           car_types_form.setVisible(true);
           car_news_form.setVisible(false);
           latest_car_form.setVisible(false);
           Explore_pane.setVisible(false);
           insurances_form.setVisible(false);
           
           car_types_btn.setStyle(" -fx-background-color: white");
           car_news_btn.setStyle(" -fx-background-color: transparent");
           latest_car_btn.setStyle(" -fx-background-color: transparent");
           Explore_btn.setStyle(" -fx-background-color: transparent");
           Insurances_btn.setStyle("-fx-background-color: transparent");
           car_wash_btn.setStyle("-fx-background-color: transparent");
        }
        else if(event.getSource()== car_news_btn){
            
            car_types_form.setVisible(false);
            car_news_form.setVisible(true);
            latest_car_form.setVisible(false);
            Explore_pane.setVisible(false);
            insurances_form.setVisible(false);
            

            car_types_btn.setStyle(" -fx-background-color: transparent");
           car_news_btn.setStyle(" -fx-background-color: white");
           latest_car_btn.setStyle(" -fx-background-color: transparent");
           Explore_btn.setStyle(" -fx-background-color: transparent");
           Insurances_btn.setStyle("-fx-background-color: transparent");
           car_wash_btn.setStyle("-fx-background-color: transparent");
            
        }
        else if(event.getSource()== latest_car_btn){
           
            car_types_form.setVisible(false);
            car_news_form.setVisible(false);
            latest_car_form.setVisible(true);
            Explore_pane.setVisible(false);
            insurances_form.setVisible(false);
            

            car_types_btn.setStyle(" -fx-background-color: transparent");
           car_news_btn.setStyle(" -fx-background-color: transparent");
           latest_car_btn.setStyle(" -fx-background-color: white");
           Explore_btn.setStyle(" -fx-background-color: transparent");
           Insurances_btn.setStyle("-fx-background-color: transparent");
           car_wash_btn.setStyle("-fx-background-color: transparent");
           
        }
        else if(event.getSource()== Explore_btn){
            loadExplorePage(event,"https://www.cardekho.com/");
           
            car_types_form.setVisible(false);
            car_news_form.setVisible(false);
            latest_car_form.setVisible(false);
            Explore_pane.setVisible(true);
            insurances_form.setVisible(false);
            
            car_types_btn.setStyle(" -fx-background-color: transparent");
           car_news_btn.setStyle(" -fx-background-color: transparent");
           latest_car_btn.setStyle(" -fx-background-color: transparent");
           Explore_btn.setStyle(" -fx-background-color: white");
           Insurances_btn.setStyle("-fx-background-color: transparent");
           car_wash_btn.setStyle("-fx-background-color: transparent");
           
        }
        else if(event.getSource()== Insurances_btn){
            loadInsuranePage(event ,"https://www.acko.com/car-insurance");
            
            car_types_form.setVisible(false);
            car_news_form.setVisible(false);
            latest_car_form.setVisible(false);
            Explore_pane.setVisible(false);
            insurances_form.setVisible(true);
            
            
           car_types_btn.setStyle(" -fx-background-color: transparent");
           car_news_btn.setStyle(" -fx-background-color: transparent");
           latest_car_btn.setStyle(" -fx-background-color: transparent");
           Explore_btn.setStyle(" -fx-background-color: transparent");
           Insurances_btn.setStyle("-fx-background-color: white");
           car_wash_btn.setStyle("-fx-background-color: transparent");
        }
        else if(event.getSource()== car_wash_btn){           
            car_types_form.setVisible(false);
            car_news_form.setVisible(false);
            latest_car_form.setVisible(false);
            Explore_pane.setVisible(false);
            insurances_form.setVisible(false);
            
            
            car_types_btn.setStyle(" -fx-background-color: transparent");
           car_news_btn.setStyle(" -fx-background-color: transparent");
           latest_car_btn.setStyle(" -fx-background-color: transparent");
           Explore_btn.setStyle(" -fx-background-color: tarnsparent");
           Insurances_btn.setStyle("-fx-background-color: transparent");
           car_wash_btn.setStyle("-fx-background-color: white");
        }
        
    }
    
    private List<Book> recentlyadded(){
        List<Book> ls = new ArrayList<>();
        Book book = new Book();
        book.setCar_model_name("        Hyundai Exter");
        book.setImg_url("Hyundai_exter.png");
        book.setDetails("19.4 kmpl . 1197 cc . Petrol");
        book.setPrice("                   Rs.6.00 - 10.00 Lakh*");
        ls.add(book);

        book = new Book();
        book.setCar_model_name("        Maruti Invicto");
        book.setImg_url("Maruti_invicto.png");
        book.setDetails("23.24 kmpl . 1987 cc . Petrol");
        book.setPrice("                   Rs.24.79 - 28.42 Lakh*");
        ls.add(book);

        book = new Book();
        book.setCar_model_name("        Skoda Kushaq");
        book.setImg_url("Skoda_kushaq.png");
        book.setDetails("19.76 kmpl . 999 cc . Petrol");
        book.setPrice("                   Rs.11.59 - 19.69 Lakh*");
        ls.add(book);

        book = new Book();
        book.setCar_model_name("        Maruti Jimny");
        book.setImg_url("Maruti_jimny.png");
        book.setDetails("16.94 kmpl . 1462 cc . Petrol");
        book.setPrice("                   Rs.12.74 - 15.05 Lakh*");
        ls.add(book);
        
        return ls;
    }
    public void loadPage(){
        engine.load("https://www.autocarindia.com/car-news");
    }


    public void invisible(){
            car_types_form.setVisible(false);
            car_news_form.setVisible(false);
            latest_car_form.setVisible(false);
            Explore_pane.setVisible(false);
            insurances_form.setVisible(false);
    }

    public void pageLoader(ActionEvent event){
    if(event.getSource()==Carwale_btn){
        loadExplorePage(event,"https://www.carwale.com/new-cars/");
    }
    else if(event.getSource()==Cars_24_btn){
        loadExplorePage(event,"https://www.cars24.com/");
    }
    else if(event.getSource()==Zig_Wheels_btn){
        loadExplorePage(event, "https://www.zigwheels.com/");
    }
    }
    
    public void loadExplorePage(ActionEvent event, String url){
        engine1.load(url);
    }

    public void loadInsuranePage(ActionEvent event,String url1){
        engine2.load(url1);
    }

    public void loadTypesPage(ActionEvent event,String url2){
        engine4.load(url2);
    }
}
