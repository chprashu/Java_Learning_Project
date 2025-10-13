package learn.WebConcepts.Spring.events;

import lombok.Getter;

import java.lang.reflect.Method;

public record EventHandler(Object bean, Method method) {
}
