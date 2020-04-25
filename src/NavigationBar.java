

import java.util.LinkedList;
import java.util.List;

import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;


public class NavigationBar {
    
    private StackPane navBar;
    private List<Text> links;
    private ImageView shoppingCartIcon;
    private Image cartDefault;
    private Image cartHover;
    private int activeLinkNumber;
    
    public NavigationBar(){
    	links = new LinkedList<>();
    	activeLinkNumber = 0;
    
    	cartDefault = new Image("shopping-cart-default.png");
    	cartHover = new Image("shopping-cart-hover.png");    	
    	
    	shoppingCartIcon = new ImageView(cartDefault);
    	shoppingCartIcon.setFitHeight(40);	
    	shoppingCartIcon.setFitWidth(40);
    	
        createNavBar();
        resetActiveLink(0);
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
    	    	
    	HBox rightLinksHBox = new HBox(50, events, shop, contact, shoppingCartIcon);
    	HBox linksHBox = new HBox(770, home, rightLinksHBox);
    	linksHBox.getStyleClass().add("nav-bar-links");
    	return linksHBox;
    }
    
    private void setHoverEffects() {
    	
    	Scale scaleUp = new Scale();
    	scaleUp.setX(1.1);
    	scaleUp.setY(1.1);
    	   	
    	for(Text link : links) {
    		link.setOnMouseEntered(event->{
    		//	link.getTransforms().add(scaleUp);
    			setDropShadow(link);
    			navBar.setCursor(Cursor.HAND);
    		});
    		
    		link.setOnMouseExited(event->{
    			//link.getTransforms().remove(scaleUp);
    			
    			if(links.indexOf(link) != activeLinkNumber) {
    				link.setEffect(null);
    			}
		
    			//link.autosize();
    			navBar.setCursor(Cursor.DEFAULT);
    		}); 		
    	}
    	
    	shoppingCartIcon.setOnMouseEntered(event->{
    		shoppingCartIcon.setImage(cartHover);
        	shoppingCartIcon.setFitWidth(44);
    		navBar.setCursor(Cursor.HAND);
    	});
    	
    	shoppingCartIcon.setOnMouseExited(event->{
    		shoppingCartIcon.setImage(cartDefault);
        	shoppingCartIcon.setFitWidth(40);
    		navBar.setCursor(Cursor.DEFAULT);
    	});
    }
    
    public void resetActiveLink(int linkNumber) {
    	links.get(activeLinkNumber).setEffect(null);
    	activeLinkNumber = linkNumber;
    	setDropShadow(links.get(activeLinkNumber));
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
    
    private void setDropShadow(Text link) {
    	
    	DropShadow dropShadow = new DropShadow();
    	dropShadow.setRadius(5.0);
    	dropShadow.setOffsetX(3.0);
    	dropShadow.setOffsetY(3.0);
    	dropShadow.setColor(Color.color(0.1, 0.1, 0.1));
    	
    	link.setEffect(dropShadow);
    	
    }

}
