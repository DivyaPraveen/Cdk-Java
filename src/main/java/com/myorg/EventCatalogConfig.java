package com.myorg;

import lombok.Data;

import java.util.List;

@Data
public class EventCatalogConfig {

    private List<Events> events;

    @Data
    public static class Events {

        private String eventName;
        private List<String> subscribers;

    }
}