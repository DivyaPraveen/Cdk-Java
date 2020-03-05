package com.myorg;

import com.google.gson.Gson;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.SqsSubscription;
import software.amazon.awscdk.services.sqs.Queue;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CdkPocStack extends Stack {

    public CdkPocStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkPocStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
        EventCatalogConfig eventCatalogConfig = readFile();
        //Create Topics
        for (EventCatalogConfig.Events event : eventCatalogConfig.getEvents()) {
            System.out.println("created topic:" + event.getEventName());
            final Topic topic = Topic.Builder.create(this, event.getEventName())
                    .displayName(event.getEventName()+"-poc")
                    .build();
            //Create subscriptions
            for (String subscriber : event.getSubscribers()) {
                System.out.println("    created consumer: " + subscriber);
                final Queue queue = Queue.Builder.create(this, subscriber)
                        .visibilityTimeout(Duration.seconds(300))
                        .build();
                topic.addSubscription(new SqsSubscription(queue));
            }
        }

    }

    public EventCatalogConfig readFile() {
        String s = "src/main/java/resources/config.json";
        Gson gson = new Gson();
        EventCatalogConfig object = null;
        try {
            object = gson.fromJson(new FileReader(s), EventCatalogConfig.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return object;

    }
}
