

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
        
        //To test your code, uncomment the appropriate line:
        //root.setCenter(home.getHomePage());
        //root.setCenter(events.getEventsPage());
        //root.setCenter(shop.getShopPage());
        //root.setCenter(contactUs.getContactUsPage());
        
        //NOTE: Email Pop Up should be smaller than a regular page. 
        //It will not actually be displayed using root.setCenter(), but I will
        //leave this here for now for testing purposes.
        //root.setCenter(emailPopUp.getEmailPopUp());
        
        Scene scene = new Scene(root, 1400, 800);
        
        primaryStage.setTitle("Bookends");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
