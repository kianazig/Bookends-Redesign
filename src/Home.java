

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Home {
    
    private StackPane home;
    
    public Home(){
        home = new StackPane(createHome());
    }

    public StackPane createHome() {        
        StackPane stackPane = new StackPane();
        
        Image homePageImage = new Image("home-page.jpg");
        ImageView homePageImageView = new ImageView(homePageImage);
        homePageImageView.setPreserveRatio(true);
        homePageImageView.setFitWidth(1400);
      
        Text intro = new Text("Bookends is a legendary New Jersey Landmark!\n\n"
		+ "We are known for our incredible author events and have hosted well over 1,000 "
		+ "authors in the past 15 years!");
        intro.setWrappingWidth(400);
        intro.setStyle("-fx-font-size: 25pt; -fx-fill: black; -fx-font-weight: bold;");
        
        HBox introBox = new HBox(intro);

        stackPane.getChildren().add(homePageImageView);

        stackPane.getChildren().add(introBox);
        introBox.setStyle("-fx-padding: 200px 0px 200px 100px");
        introBox.setPadding(new Insets(200));
        stackPane.setStyle("-fx-padding: 0px 400px 0px 0px");
        stackPane.setAlignment(Pos.TOP_CENTER);    
        return stackPane;
    }

    public StackPane getHomePage(){
        return home;
    }
}
