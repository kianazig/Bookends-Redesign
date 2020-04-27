import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ContactUs {
    
    private StackPane contactUs;
    
    public ContactUs(){
		contactUs = new StackPane(createContactPage());
    }
    
    public StackPane createContactPage() {
    	Label contactLabel = new Label("Contact us!");
		Label addressLabel = new Label("211 East Ridgewood Ave.  Ridgewood, NJ  07450");
		Label questionLabel = new Label("Please write to us your questions.");
		Label socialLabel = new Label("Follow us on our socials!");
		Label phoneLabel = new Label("Call us: (201)445-0726");
		
		TextField text = new TextField("Enter your e-mail address.");
		text.setOnMouseClicked(e -> {
			if (text.getText().equals("Enter your e-mail address."))
				text.setText("");
		});	
		
		TextArea textarea = new TextArea();
		textarea.setWrapText(true);
		
		ImageView image = new ImageView("map.png");
		ImageView twitterImage = new ImageView("twitter.png");
		ImageView facebookImage = new ImageView("facebook.png");
		twitterImage.setFitHeight(50);
		twitterImage.setFitWidth(50);
		facebookImage.setFitHeight(50);
		facebookImage.setFitWidth(50);
		
		Button submit = new Button("Submit");
		Button twitter = new Button("", twitterImage);
		Button facebook = new Button("", facebookImage);	 	
		submit.setId("submit");
		twitter.setId("twitter");
		facebook.setId("facebook");
		twitter.setPadding(new Insets(0, 0, 0, 50));
		facebook.setPadding(new Insets(0, 0, -1, -10));
		
		GridPane gridpane = new GridPane();
		gridpane.add(contactLabel, 0, 0);
		gridpane.add(text, 0, 2);
		gridpane.add(questionLabel, 0, 3);
		gridpane.add(textarea, 0, 4);
		gridpane.add(submit, 0, 5);
		gridpane.add(socialLabel, 0, 6);
		gridpane.add(twitter, 0, 7);
		gridpane.add(facebook, 0, 7);
		gridpane.add(phoneLabel, 1, 2);
		gridpane.add(addressLabel, 1, 3);
		gridpane.add(image, 1, 4);
		gridpane.setHgap(100);
		gridpane.setVgap(10);
		gridpane.setPadding(new Insets(20, 0, 0, 100));
		
		StackPane stackpane = new StackPane();
		stackpane.getChildren().add(gridpane);
		
		submit.setOnMouseEntered(e -> {
			stackpane.setCursor(Cursor.HAND);
		});
		
		submit.setOnMouseExited(e -> {
			stackpane.setCursor(Cursor.DEFAULT);
		});
		
		twitter.setOnMouseEntered(e -> {
			stackpane.setCursor(Cursor.HAND);
		});
		
		twitter.setOnMouseExited(e -> {
			stackpane.setCursor(Cursor.DEFAULT);
		});
		
		facebook.setOnMouseEntered(e -> {
			stackpane.setCursor(Cursor.HAND);
		});
		
		facebook.setOnMouseExited(e -> {
			stackpane.setCursor(Cursor.DEFAULT);
		});
		
		return stackpane;
    }
    
    public StackPane getContactUsPage(){
        return contactUs;
    }
}
