import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;


public class EmailPopUp {
	
	private Popup emailPopUp;    
    private StackPane emailStackPane;
    private Button noButton;
    
    public EmailPopUp(){
        emailStackPane = new StackPane(createEmailStackPane());
        emailPopUp = createEmailPopup();
    }

    private Popup createEmailPopup() {
		Popup popup = new Popup();
		popup.getContent().add(emailStackPane);
		return popup;
	}

	public StackPane createEmailStackPane() {
        ImageView logo = new ImageView("smallLogo.png");

    	Font font1 = new Font("SansSerif", 20);
        TextField textField = new TextField("Enter Email");
        textField.setMinWidth(250);
        textField.setMaxWidth(250);
        textField.setFont(font1);
        

        noButton = new Button("Not Interested");
        noButton.getStyleClass().add("button-effect");
        noButton.setStyle("-fx-background-radius: 0; -fx-padding: 0; -fx-background-color: transparent; -fx-font-size: 12pt; -fx-text-fill: #FFFFFF");
        
        Label signUpLabel = new Label("Sign up for Bookends Emails!");
        Label submitLabel = new Label("SUBMIT");
        signUpLabel.setStyle("-fx-font-size: 28pt; -fx-font-weight: bold; -fx-font-family: Helvetica; -fx-text-fill: #FFFFFF");
        submitLabel.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold; -fx-font-family: Helvetica; -fx-text-fill: #FFFFFF");
        submitLabel.getStyleClass().add("button-effect");
        
        Rectangle submitRec = new Rectangle(200, 40);
        submitRec.setFill(Color.web("#000000"));
        submitRec.getStyleClass().add("button-effect");

        StackPane pane = new StackPane(submitRec, submitLabel);
        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, logo, signUpLabel, textField, pane, noButton);
        vBox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vBox);
        
        stackPane.getStylesheets().add("popup.css");
        stackPane.setId("popup");
        return stackPane;
    }
    
    public StackPane getEmailPopUp(){
        return emailStackPane;
    }
    
    public void showPopUp(Stage stage) {
    	
    	PauseTransition delay = new PauseTransition(Duration.seconds(10));
        
    	delay.setOnFinished(event->{
        	emailPopUp.show(stage);
        });
    	delay.play();
        
    	noButton.setOnMouseClicked(event->{
    		emailPopUp.hide();
    	});
    }
}
