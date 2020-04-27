

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Home {
    
    private StackPane home;
    
    public Home(){
        home = new StackPane(createHome());
    }

    public StackPane createHome() {
        ImageView logo = new ImageView("bigLogo.JPG");
        logo.setFitWidth(600);
        logo.setFitHeight(600);
        logo.setPreserveRatio(true);

        ImageView book1 = new ImageView("bookPreview1.jpg");
        book1.setFitWidth(200);
        book1.setFitHeight(200);
        book1.setPreserveRatio(true);

        ImageView book2 = new ImageView("bookPreview2.jpg");
        book2.setFitWidth(200);
        book2.setFitHeight(200);
        book2.setPreserveRatio(true);

        ImageView book3 = new ImageView("bookPreview3.jpg");
        book3.setFitWidth(200);
        book3.setFitHeight(200);
        book3.setPreserveRatio(true);

        ImageView book4 = new ImageView("bookPreview4.jpg");
        book4.setFitWidth(200);
        book4.setFitHeight(200);
        book4.setPreserveRatio(true);

        ImageView book5 = new ImageView("bookPreview5.jpg");
        book5.setFitWidth(200);
        book5.setFitHeight(200);
        book5.setPreserveRatio(true);

        ImageView book6 = new ImageView("bookPreview6.jpg");
        book6.setFitWidth(200);
        book6.setFitHeight(200);
        book6.setPreserveRatio(true);

        Label sentence = new Label(" Bookends is a legendary New Jersey Landmark!\n" +
                " We are known for our incredible author events and have hosted well over\n" +
                " 1,000 authors in the past 15 years!");
        sentence.setStyle("-fx-font-size: 20pt; -fx-font-family: Helvetica; -fx-font-style: italic");

        Label notice1 = new Label("Dear Customers,\n" +
                "Due to the COVID-19 our store is closed indefinitely but open \"Virtually\"\n" +
                "Please order all books through our online system");
        notice1.setStyle("-fx-font-size: 20pt; -fx-font-family: Helvetica;");

        HBox hBox = new HBox(20, book1, book2, book3, book4, book5, book6);
        hBox.setAlignment(Pos.CENTER);

        VBox sentanceVbox = new VBox(sentence);
        sentanceVbox.setAlignment(Pos.CENTER);

        VBox noticeVbox = new VBox(notice1);
        noticeVbox.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox(35, logo, hBox, sentanceVbox, noticeVbox);
        vBox1.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox1);
        borderPane.setPadding(new Insets(0, 400, 0, 0));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(borderPane);
        return stackPane;
    }

    public StackPane getHomePage(){
        return home;
    }
}
