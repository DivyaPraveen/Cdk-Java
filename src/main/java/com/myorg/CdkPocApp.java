package com.myorg;

import software.amazon.awscdk.core.App;

public final class CdkPocApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkPocStack(app, "CdkPocStack");

        app.synth();
    }

//    public static void main(String[] args) {
//        String s = "src/main/java/resources/config.json";
//        Gson gson = new Gson();
//        EventCatalogConfig object = null;
//        String jsonString = "{\n" +
//                "  \"events\": [\n" +
//                "    {\n" +
//                "      \"event-name\": \"quote-event\",\n" +
//                "      \"subscribers\": [\n" +
//                "        \"docs-quote-subscriber\"\n" +
//                "      ]\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"event-name\": \"policy-event\",\n" +
//                "      \"subscribers\": [\n" +
//                "        \"docs-policy-subscriber\"\n" +
//                "      ]\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//        object = gson.fromJson(jsonString, EventCatalogConfig.class);
//    }
}
