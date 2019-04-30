package com.rainbow.latte.delegate.web.event;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Latte-Core
 * Created By Rainbow on 2019/4/30.
 */
public class EventManager {

    private static final HashMap<String, Event> EVENTS = new HashMap<>();

    private EventManager() {
    }

    public static EventManager getInstance() {
        return Holder.INSTANCE;
    }

    public EventManager addEvent(@NotNull String name, @NotNull Event event) {
        EVENTS.put(name, event);
        return this;
    }

    public Event createEvent(@NotNull String action) {
        final Event event = EVENTS.get(action);
        if (event == null) {
            return new UndefinedEvent();
        }
        return event;
    }

    private static class Holder {
        private static final EventManager INSTANCE = new EventManager();
    }
}
