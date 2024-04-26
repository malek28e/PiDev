package controllers;
import Entite.Event;
import Services.EventService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class EventController {

        @FXML
        private TextField titleField;
        @FXML
        private TextField descriptionField;
        @FXML
        private TextField dateField;
        @FXML
        private TextField locationField;
        @FXML
        private TextField discountField;
        @FXML
        private TableView<Event> eventTable;

        private EventService eventService;

        public void initialize() {
            eventService = new EventService();
            eventTable.setItems(eventService.getEvents());
        }

        @FXML
        private void addEvent() {
            String title = titleField.getText();
            String description = descriptionField.getText();
            String date = dateField.getText();
            String location = locationField.getText();
            double discount = Double.parseDouble(discountField.getText());

            Event event = new Event(title, description, date, location, discount);
            eventService.addEvent(event);

            clearFields();
        }

        @FXML
        private void deleteEvent() {
            Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
            if (selectedEvent != null) {
                eventService.deleteEvent(selectedEvent);
            }
        }

        @FXML
        private void updateEvent() {
            Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
            if (selectedEvent != null) {
                String title = titleField.getText();
                String description = descriptionField.getText();
                String date = dateField.getText();
                String location = locationField.getText();
                double discount = Double.parseDouble(discountField.getText());

                Event updatedEvent = new Event(title, description, date, location, discount);
                eventService.updateEvent(selectedEvent, updatedEvent);
            }
        }

        private void clearFields() {
            titleField.clear();
            descriptionField.clear();
            dateField.clear();
            locationField.clear();
            discountField.clear();
        }
    }


