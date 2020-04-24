

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class NavigationBar {
    
    private StackPane navBar;
    
    public NavigationBar(){
        createNavBar();
    }
    
    private void createNavBar(){
        navBar = new StackPane(createBackground());
        
    }
    
    private Rectangle createBackground(){
        Rectangle background = new Rectangle();
        background.setWidth(1800);
        background.setHeight(60);
        background.setX(0);
        background.setY(0);
        background.setFill(Color.web("#b1282a"));
        background.setStroke(Color.web("#b1282a"));
        return background;
    }
    
    public StackPane getNavigationBar(){
        return navBar;
    }

}
