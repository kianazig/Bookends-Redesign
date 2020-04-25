

import java.util.LinkedList;
import java.util.List;

import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;


public class NavigationBar {
    
    private StackPane navBar;
    private List<Text> links;
    
    public NavigationBar(){
    	links = new LinkedList<>();
        createNavBar();
    }
    
    private void createNavBar(){
        navBar = new StackPane(createBackground(), createLinks());
        setHoverEffects();
        navBar.getStylesheets().add("nav-bar.css");
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
    
    private HBox createLinks() {
    	Text home = new Text("Home");
    	home.getStyleClass().add("left");
    	home.getStyleClass().add("nav-bar-label");
    	links.add(home);
    	Text events = new Text("Events");
    	events.getStyleClass().add("nav-bar-label");
    	links.add(events);
    	Text shop = new Text("Buy Books");
    	shop.getStyleClass().add("nav-bar-label");
    	links.add(shop);
    	Text contact = new Text("Contact Us");
    	contact.getStyleClass().add("nav-bar-label");
    	links.add(contact);
    	
    	HBox rightLinksHBox = new HBox(50, events, shop, contact);
    	HBox linksHBox = new HBox(800, home, rightLinksHBox);
    	linksHBox.getStyleClass().add("nav-bar-links");
    	return linksHBox;
    }
    
    private void setHoverEffects() {
    	DropShadow dropShadow = new DropShadow();
    	dropShadow.setRadius(5.0);
    	dropShadow.setOffsetX(3.0);
    	dropShadow.setOffsetY(3.0);
    	dropShadow.setColor(Color.color(0.1, 0.1, 0.1));
    	
    	Scale scaleUp = new Scale();
    	scaleUp.setX(1.1);
    	scaleUp.setY(1.1);
    	   	
    	for(Text link : links) {
    		link.setOnMouseEntered(event->{
    		//	link.getTransforms().add(scaleUp);
    			link.setEffect(dropShadow);
    			navBar.setCursor(Cursor.HAND);
    		});
    		
    		link.setOnMouseExited(event->{
    			//link.getTransforms().remove(scaleUp);
    			link.setEffect(null);
    			//link.autosize();
    			navBar.setCursor(Cursor.DEFAULT);
    		}); 		
    	}
    }
    
    public Text getHomeLink() {
    	return links.get(0);
    }
    
    public Text getEventsLink() {
    	return links.get(1);
    }
    
    public Text getShopLink() {
    	return links.get(2);
    }
    
    public Text getContactLink() {
    	return links.get(3);
    }
    
    public StackPane getNavigationBar(){
        return navBar;
    }

}
