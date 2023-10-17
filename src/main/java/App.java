import io.appflags.sdk.AppFlagsClient;
import io.appflags.sdk.models.AppFlagsUser;

public class App {

    // Change this to your SDK key
    static final String SDK_KEY = "YOUR_KEY_HERE";

    static {
        // Configure logging
        String path = App.class
            .getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);
    }

    public static void main( String[] args ) throws InterruptedException {
        System.out.println("AppFlags Java example project");
        System.out.println();

        // Create the client
        AppFlagsClient appFlagsClient = new AppFlagsClient(SDK_KEY);

        // Get the current value for the `test` feature flag
        boolean testValue = appFlagsClient.getBooleanVariation("test", AppFlagsUser.SYSTEM, false);
        System.out.println("Feature 'test' is set to: " + testValue);
        System.out.println();

        // Listen for feature flag changes and get the updated value for the `test` feature flag
        appFlagsClient.addConfigurationChangedHandler(() -> {
            boolean updatedTestValue = appFlagsClient.getBooleanVariation("test", AppFlagsUser.SYSTEM, false);
            System.out.println("Feature 'test' is now set to: " + updatedTestValue);
            System.out.println();
        });

        // Sleep forever, wait for updates
        System.out.println("Listening for updates...");
        System.out.println();
        Thread.sleep(Long.MAX_VALUE);
    }
}
