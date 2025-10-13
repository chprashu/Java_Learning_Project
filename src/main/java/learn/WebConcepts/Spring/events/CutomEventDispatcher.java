package learn.WebConcepts.Spring.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CutomEventDispatcher implements ApplicationListener<EventParams>, InitializingBean {

    @Autowired
    private ListableBeanFactory factory;

    private final Map<String, List<EventHandler>> handlers = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Object> beans = factory.getBeansWithAnnotation(Component.class);

        for (Object bean : beans.values()) {
            for (Method method : bean.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(CustomEventListener.class)) {
                    CustomEventListener listener = method.getAnnotation(CustomEventListener.class);
                    String key = listener.eventName() + "::" + listener.key();

                    handlers.computeIfAbsent(key, k -> new ArrayList<>())
                            .add(new EventHandler(bean, method));
                }
            }
        }
    }

    @SuppressWarnings("null")
    @Override
    public void onApplicationEvent(EventParams event) {
        String key = event.getEventName() + "::" + event.getKey();
        List<EventHandler> list = handlers.get(key);

        if (list != null) {
            for (EventHandler entry : list) {
                try {
                    entry.method.setAccessible(true);
                    if (entry.method.getParameterCount() == 1) {
                        entry.method.invoke(entry.bean, event);
                    } else {
                        entry.method.invoke(entry.bean);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class EventHandler {
        final Object bean;
        final Method method;

        EventHandler(Object bean, Method method) {
            this.bean = bean;
            this.method = method;
        }
    }

}
