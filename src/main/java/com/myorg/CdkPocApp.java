package com.myorg;

import software.amazon.awscdk.core.App;

public final class CdkPocApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkPocStack(app, "CdkPocStack");

        app.synth();
    }
}
