

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;


public class Events {
    
    private StackPane events;
    private List<Event> eventsList;
    
    public Events(){
    	initializeEventsList();
    	createEventsPage();
    }
    
    private void initializeEventsList() {
		eventsList = new LinkedList<>();
		
		Event event1 = new Event();
		event1.title = "Exclusive Live Chat with Colton Underwood!";
		event1.author = "Colton Underwood";
		event1.book = "The First Time";
		event1.image = new Image("event1.jpg");
		event1.date = "Thursday, April 30th";
		event1.time = "6:00 PM";
		event1.location = "Online Zoom Chat";
		event1.description = "Star of Bachelor in Paradise, Bachelorette, Voted Fan Favorite at the Reality TV Awards and a "
				+ "Former Pro-Football Player, Colton Underwwod will take questions and speak " + 
				"about his new memoir, The First Time.\n\n"
				+ "Books will also include book plates signed by Colton!"; 
		eventsList.add(event1);	
		
	}

	private void createEventsPage() {
    	events = new StackPane(createEventList());
    	events.getStylesheets().add("events.css");
    }
    
    public StackPane getEventsPage(){
        return events;
    }
    
    private VBox createEventList() { 	
    	VBox eventListVBox = new VBox(10);
    	eventListVBox.setPadding(new Insets(20));
    	
    	for(Event event : eventsList) {
    		StackPane preview = createEventPreview(event);
    		eventListVBox.getChildren().add(preview);
    	}
    	
    	return eventListVBox;
    }
    
    private StackPane createEventPreview(Event event) {
    	
    	
   		ImageView imagePreview = new ImageView(event.image);
		imagePreview.setPreserveRatio(true);
		imagePreview.setFitHeight(100);
		
		Text eventName = new Text(event.title);
		eventName.getStyleClass().add("event-preview-title");
		Text dateAndTime = new Text(event.date + " at "+event.time);
		dateAndTime.getStyleClass().add("event-preview-time");
		VBox eventInformation = new VBox(10, eventName, dateAndTime);
		eventInformation.setAlignment(Pos.CENTER_LEFT);
		
		HBox eventPreview = new HBox(20, imagePreview, eventInformation);
	//	eventPreview.getStyleClass().add("event-preview-box");
		eventPreview.setPadding(new Insets(20));
		eventPreview.setMaxWidth(350);
		
		StackPane eventPreviewPane = new StackPane(eventPreview);
		eventPreviewPane.getStyleClass().add("event-preview-box");
		eventPreviewPane.setMaxWidth(350);
		
		return eventPreviewPane;
	}

	private class Event{
    	String title;
    	String author;
    	String book;
    	String date;
    	String time;
    	String location;
    	String description;
    	Image image;
    	
    	public Event() {}
    }
}
