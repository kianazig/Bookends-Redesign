import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class EmailPopUp {
    
    private StackPane emailPopUp;
    
    public EmailPopUp(){
        emailPopUp = new StackPane(createEmailPopUp());
    }

    public StackPane createEmailPopUp() {
        ImageView logo = new ImageView("smallLogo.png");

        TextField textField = new TextField("Enter Email");
        textField.setPrefWidth(150);
        textField.setMaxWidth(150);

        Button noButton = new Button("Not Intrested");
        noButton.setStyle("-fx-background-radius: 0; -fx-padding: 0; -fx-background-color: transparent; -fx-font-size: 12pt");

        Label signUpLabel = new Label("Sign up for Bookends Emails!");
        Label submitLabel = new Label("SUBMIT");
        signUpLabel.setStyle("-fx-font-size: 28pt; -fx-font-weight: bold; -fx-font-family: Helvetica");
        submitLabel.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold; -fx-font-family: Helvetica; -fx-text-fill: #FFFFFF");

        Rectangle submitRec = new Rectangle(200, 40);
        submitRec.setFill(Color.web("#000000"));

        StackPane pane = new StackPane(submitRec, submitLabel);
        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, logo, signUpLabel, textField, pane, noButton);
        vBox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vBox);

        return stackPane;
    }
    
    public StackPane getEmailPopUp(){
        return emailPopUp;
    }
}
