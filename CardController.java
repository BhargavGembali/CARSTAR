import Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CardController {
    
    @FXML
    private Label Car_name;

    @FXML
    private HBox box;

    @FXML
    private VBox details_box;

    @FXML
    private ImageView Carimage;

    @FXML
    private Button more_button;

    @FXML
    private Label price_range;

    @FXML
    private Label specs;

    

    public void setData(Book book){
        Image image= new Image(getClass().getResourceAsStream(book.getImg_url()));
        Carimage.setImage(image);
        Car_name.setText(book.getCar_model_name());
        price_range.setText(book.getPrice());
        specs.setText(book.getDetails());
    }
}
