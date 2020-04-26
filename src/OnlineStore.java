/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author anirb
 */
public class OnlineStore extends Application {
    
    @Override
    public void start(Stage stage) {
       
        final int bookHeight = 230; 
        final int bookWidth = 250; 
      
Image image1 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\BookendsLogo.png"){};
ImageView iv1 = new ImageView(image1); 
iv1.setFitHeight(50);
iv1.setFitWidth(250);

Image image2 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\SideStuff.png"){};
ImageView iv2 = new ImageView(image2); 
iv2.setFitHeight(40);
iv2.setFitWidth(70);

Image image3 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\Filter.png"){};
ImageView iv3 = new ImageView(image3); 
iv3.setFitHeight(560);
iv3.setFitWidth(250);


Image image4 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\featured.png"){};
ImageView iv4 = new ImageView(image4); 
iv4.setFitHeight(50);
iv4.setFitWidth(200);

Image image5 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\book1.png"){};
ImageView iv5 = new ImageView(image5); 
iv5.setFitHeight(bookHeight);
iv5.setFitWidth(bookWidth);

Image image6 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\book2.png"){};
ImageView iv6 = new ImageView(image6); 
iv6.setFitHeight(bookHeight);
iv6.setFitWidth(bookWidth);

Image image7 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\book3.png"){};
ImageView iv7 = new ImageView(image7);
iv7.setFitHeight(bookHeight);
iv7.setFitWidth(bookWidth);

Image image8 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\book4.png"){};
ImageView iv8 = new ImageView(image8); 
iv8.setFitHeight(bookHeight);
iv8.setFitWidth(bookWidth);


Image image9 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\book5.png"){};
ImageView iv9 = new ImageView(image9); 
iv9.setFitHeight(bookHeight);
iv9.setFitWidth(bookWidth);

Image image10 = new Image("C:\\Users\\anirb\\Pictures\\Screenshots\\book6.png"){};
ImageView iv10 = new ImageView(image10); 
iv10.setFitHeight(bookHeight);
iv10.setFitWidth(bookWidth);


HBox h1 = new HBox(iv5,iv6,iv7); 
h1.setSpacing(10);
h1.setAlignment(Pos.CENTER); 
HBox h2 = new HBox(iv8,iv9,iv10); 
h2.setSpacing(10);
h2.setAlignment(Pos.CENTER); 
VBox root = new VBox(iv4, h1, h2);
root.setSpacing(20);

root.setAlignment(Pos.TOP_CENTER);
root.setStyle("-fx-background-color: white;");

FlowPane flow = new FlowPane();
HBox h = new HBox(iv1,iv2); 
h.setSpacing(900);
flow.setPadding(new Insets(10, 10, 10, 10));
flow.setStyle("-fx-background-color: #B1282B;");
flow.getChildren().add(h); 

AnchorPane anchorpane = new AnchorPane();
anchorpane.setStyle("-fx-background-color: white;");
anchorpane.setMinSize(225, 100);
anchorpane.getChildren().add(iv3); 



TilePane tile = new TilePane();
tile.setPadding(new Insets(10, 10, 10, 10));
tile.setPrefColumns(2);
tile.setStyle("-fx-background-color: #B1282B;");


BorderPane pane = new BorderPane();
pane.setLeft(anchorpane);
pane.setCenter(root);
pane.setTop(flow);
pane.setBottom(tile);


 
Scene scene = new Scene(pane, 1520, 650);
stage.setTitle("Online Bookstore");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
} 