

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;


public class Events {
    
    private StackPane events;
    private List<Event> eventsList;
    private int selectedEvent;
    private List<StackPane> eventPreviews;
    BorderPane eventFeature;
    
    public Events(){
    	selectedEvent = 0;
    	eventFeature = new BorderPane();
    	initializeEventsList();
    	updateEventFeature(eventsList.get(0));
    	createEventsPage();
    }
    
    private void updateEventFeature(Event event) {
    	eventFeature.getChildren().clear();
    	
    	Text eventFeatureTitle = new Text(event.title);
    	eventFeatureTitle.setId("event-feature-title");
    	eventFeature.setTop(eventFeatureTitle);
    	
    	
		ImageView image = new ImageView(event.image);
		image.setPreserveRatio(true);
		image.setFitWidth(300);
		
		Text author = new Text("Author: "+event.author);
		author.getStyleClass().add("event-feature-detail");
		Text book = new Text("Book: "+event.book);
		book.getStyleClass().add("event-feature-detail");
		Text date = new Text("Date: "+event.date);
		date.getStyleClass().add("event-feature-detail");
		Text time = new Text("Time: "+event.time);
		time.getStyleClass().add("event-feature-detail");
		Text location = new Text("Location: "+event.location);
		location.getStyleClass().add("event-feature-detail");
		VBox eventDetails = new VBox(10, author, book, date, time, location);
		
		Text description = new Text(event.description);
		description.getStyleClass().add("event-feature-description");
		description.setWrappingWidth(290);
		
		VBox eventInformation = new VBox(30, eventDetails, description);
		eventInformation.setAlignment(Pos.CENTER_LEFT);
		
		eventInformation.setMinWidth(300);
		eventInformation.setMaxWidth(300);
		
		
		Text buyTicketText = new Text("Buy Tickets!");
		buyTicketText.setId("buy-tickets-text");
		Image ticketImage = new Image("ticket-icon.png");
		ImageView ticketIcon = new ImageView(ticketImage);
		ticketIcon.setPreserveRatio(true);
		ticketIcon.setFitHeight(40);
		HBox buyTickets = new HBox(10, ticketIcon, buyTicketText);
		buyTickets.setId("buy-tickets-box");
		buyTickets.setAlignment(Pos.CENTER);
		buyTickets.setMinWidth(200);
		buyTickets.setMaxWidth(200);
		eventFeature.setBottom(buyTickets);
		
		HBox center = new HBox(30, image, eventInformation);
		center.setAlignment(Pos.CENTER);
		
		eventFeature.setCenter(center);;
		eventFeature.setAlignment(eventFeature.getTop(), Pos.CENTER);
		eventFeature.setAlignment(eventFeature.getCenter(), Pos.CENTER);
		eventFeature.setAlignment(eventFeature.getBottom(), Pos.CENTER);

		eventFeature.setMinHeight(600);
		eventFeature.setMaxHeight(600);
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
		
		Event event2 = new Event();
		event2.title = "Remaining in Love with Chris Frantz";
		event2.author = "Chris Frantz";
		event2.book = "Remain in Love";
		event2.image = new Image("event2.jpg");
		event2.date = "Friday, May 15th";
		event2.time = "7:00 PM";
		event2.location = "Bookends Store";
		event2.description = "Join us as founding member and drummer of Talking Heads band "
				+ "and member of The Rock and Roll Hall of Fame, Chris Frants, will talk about "
				+ "his new book: Remain in Love."
				+ "\n\nChris will be signing all books and taking pictures with those who attend!";
		eventsList.add(event2);
		
		Event event3 = new Event();
		event3.title = "Kristen Doute Tells All";
		event3.author = "Kristen Doute";
		event3.book = "He's Making You Crazy";
		event3.image = new Image("event3.jpg");
		event3.date = "Sunday, May 31st";
		event3.time = "1:00 PM";
		event3.location = "Bookends Store";
		event3.description = "Join us as star of Vanderpump Rules, Kristen Doute, shares all about "
				+ "her new book, He's Making You Crazy: How to Get the Guy, Get Even, and Get Over It."
				+ "\n\nAs always, all books will be signed and you'll have a chance to meet the author.";
		eventsList.add(event3);
	}

	private void createEventsPage() {
		HBox eventsPageHBox = new HBox(80, createEventList(), eventFeature);
		eventsPageHBox.getStyleClass().add("main");
    	events = new StackPane(eventsPageHBox);
    	events.getStyleClass().add("main");
    	events.getStylesheets().add("events.css");
    	selectEvent(eventPreviews.get(0));
    	events.setAlignment(Pos.CENTER);
    }
    

	public StackPane getEventsPage(){
        return events;
    }
    
    private VBox createEventList() { 	
    	eventPreviews = new LinkedList<>();
    	Text upcomingEventsText = new Text("Upcoming Events");
    	upcomingEventsText.getStyleClass().add("header");
    	VBox eventListVBox = new VBox(10, upcomingEventsText);
    	//eventListVBox.setPadding(new Insets(20));
    	
    	for(Event event : eventsList) {
    		StackPane preview = createEventPreview(event);
    		eventListVBox.getChildren().add(preview);
    		addListener(preview);
    		eventPreviews.add(preview);
    	}
    	
    	return eventListVBox;
    }
    
    private void addListener(StackPane preview) {
    	preview.setOnMouseClicked(event->{
        	deselectEvent(selectedEvent);
			selectEvent(preview);
			selectedEvent = eventPreviews.indexOf(preview);
			updateEventFeature(eventsList.get(selectedEvent));
		});
	}

	private void selectEvent(StackPane preview) {
		preview.setId("selected");
	}

	private void deselectEvent(int event) {
		eventPreviews.get(event).setId("");
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
		eventPreview.setPadding(new Insets(20));
		eventPreview.setMaxWidth(520);
		eventPreview.setMinWidth(520);
		
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
