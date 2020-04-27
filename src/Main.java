

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        NavigationBar navBar = new NavigationBar();
        Home home = new Home();
        Events events = new Events();
        Shop shop = new Shop();
        ContactUs contactUs = new ContactUs();
        EmailPopUp emailPopUp = new EmailPopUp();
        
        BorderPane root = new BorderPane();
        root.setTop(navBar.getNavigationBar());
        root.setCenter(home.getHomePage());
        Scene scene = new Scene(root, 1400, 800);
           
        primaryStage.setTitle("Bookends");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        navBar.getHomeLink().setOnMouseClicked(event->{
        	root.setCenter(home.getHomePage());
        	navBar.resetActiveLink(0);
        });
        
        navBar.getEventsLink().setOnMouseClicked(event->{
        	root.setCenter(events.getEventsPage());
        	navBar.resetActiveLink(1);
        });
        
        navBar.getShopLink().setOnMouseClicked(event->{
        	root.setCenter(shop.getShopPage());
        	navBar.resetActiveLink(2);
        });
        
        navBar.getContactLink().setOnMouseClicked(event->{
        	root.setCenter(contactUs.getContactUsPage());
        	navBar.resetActiveLink(3);
        });
        
        emailPopUp.showPopUp(primaryStage);
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
