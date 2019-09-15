package com.ninggc.demo.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Service;

@Service
public class TestEvent extends ApplicationContextEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public TestEvent(ApplicationContext source) {
        super(source);
    }
}
