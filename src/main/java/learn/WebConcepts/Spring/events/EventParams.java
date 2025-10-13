package learn.WebConcepts.Spring.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class EventParams extends ApplicationEvent {

    private final String eventName;
    private final String key;

    public EventParams(Object source, String eventName, String key) {
        super(source);
        this.eventName = eventName;
        this.key = key;
    }

}
