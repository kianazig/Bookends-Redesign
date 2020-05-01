import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class Shop {
    
    private StackPane shop;
    
    public Shop(){
        shop = new StackPane(createShop());
    }
    
    public StackPane createShop(){

		final int bookHeight = 200;
        final int bookWidth = 220;

        Image image1 = new Image("featured.png"){};
        ImageView iv1 = new ImageView(image1);
        iv1.setFitHeight(50);
        iv1.setFitWidth(200);

        Image image2 = new Image("book1.png"){};
        ImageView iv2 = new ImageView(image2);
        iv2.setFitHeight(bookHeight);
        iv2.setFitWidth(bookWidth);

        Image image3 = new Image("book2.png"){};
        ImageView iv3 = new ImageView(image3);
        iv3.setFitHeight(bookHeight);
        iv3.setFitWidth(bookWidth);

        Image image4 = new Image("book3.png"){};
        ImageView iv4 = new ImageView(image4);
        iv4.setFitHeight(bookHeight);
        iv4.setFitWidth(bookWidth);

        Image image5 = new Image("book4.png"){};
        ImageView iv5 = new ImageView(image5);
        iv5.setFitHeight(bookHeight);
        iv5.setFitWidth(bookWidth);

        Image image6 = new Image("book5.png"){};
        ImageView iv6 = new ImageView(image6);
        iv6.setFitHeight(bookHeight);
        iv6.setFitWidth(bookWidth);

        Image image7 = new Image("book6.png"){};
        ImageView iv7 = new ImageView(image7);
        iv7.setFitHeight(bookHeight);
        iv7.setFitWidth(bookWidth);

        TextField tf = new TextField();
        tf.setPromptText("Search");
        tf.setStyle("-fx-border-width: 2;"+
                    "-fx-font-family: QuickSand;"+
                    "-fx-font-size: 25;"+
                    "-fx-padding: 1,1,1,1;"+
                    "-fx-border-color: grey;"+
                    "-fx-border-radius: 1;"+
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: grey;");
  
        tf.setPrefWidth(500);
        ComboBox cb = new ComboBox();
        cb.setPrefWidth(500);
        cb.setPromptText("Filter By");
        cb.getItems().addAll("Genre", "Format", "Language", "Price", "Condition", "Date Released");
        cb.setStyle("-fx-border-width: 2;"+
                    "-fx-font-family: QuickSand;"+
                    "-fx-font-size: 18;"+
                    "-fx-padding: 1,1,1,1;"+
                    "-fx-border-color: grey;"+
                    "-fx-border-radius: 1;"+
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: grey;");
        HBox search = new HBox(tf,cb);
        search.setSpacing(15);
        search.setAlignment(Pos.CENTER);
        
        HBox h1 = new HBox(iv2,iv3,iv4);
        h1.setSpacing(10);
        h1.setAlignment(Pos.CENTER);
        HBox h2 = new HBox(iv5,iv6,iv7);
        h2.setSpacing(10);
        h2.setAlignment(Pos.CENTER);

        VBox root = new VBox(search,iv1, h1, h2);
        root.setSpacing(20);
        root.setPadding(new Insets(60));

        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: white;");

        BorderPane floor = new BorderPane();
        floor.setPadding(new Insets(10, 10, 10, 10));
        floor.setStyle("-fx-background-color: #B1282B;");

        BorderPane pane = new BorderPane();
        pane.setCenter(root);
		pane.setPadding(new Insets(0,425,0,0));
        //pane.setBottom(floor);
		pane.setStyle("-fx-background-color: white;");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(pane);
        return stackPane;
    }
	public StackPane getShopPage(){
        return shop;
    }
}
