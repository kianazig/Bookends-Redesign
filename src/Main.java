

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
        
        //NOTE: Email Pop Up should be smaller than a regular page. 
        //It will not actually be displayed using root.setCenter(), but I will
        //leave this here for now for testing purposes.
        //root.setCenter(emailPopUp.getEmailPopUp());
   
        primaryStage.setTitle("Bookends");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        navBar.getHomeLink().setOnMouseClicked(event->{
        	root.getStylesheets().remove("contactus.css");
        	root.setCenter(home.getHomePage());
        });
        
        navBar.getEventsLink().setOnMouseClicked(event->{
        	root.getStylesheets().remove("contactus.css");
        	root.setCenter(events.getEventsPage());
        });
        
        navBar.getShopLink().setOnMouseClicked(event->{
        	root.getStylesheets().remove("contactus.css");
        	root.setCenter(shop.getShopPage());
        });
        
        navBar.getContactLink().setOnMouseClicked(event->{
        	root.setCenter(contactUs.getContactUsPage());
        	scene.getStylesheets().add("contactus.css");
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
