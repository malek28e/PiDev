package Services;
import Entite.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class EventService {

        private ObservableList<Event> events = FXCollections.observableArrayList();

        public ObservableList<Event> getEvents() {
            return events;
        }

        public void addEvent(Event event) {
            events.add(event);
        }

        public void deleteEvent(Event event) {
            events.remove(event);
        }

        public void updateEvent(Event oldEvent, Event newEvent) {
            int index = events.indexOf(oldEvent);
            events.set(index, newEvent);
        }
    }


