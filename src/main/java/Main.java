import com.fluxninja.aperture.sdk.ApertureSDK;
import io.opentelemetry.sdk.trace.SdkTracerProvider;

public class Main {
    public static void main(String[] args) {
        var otelsdk = SdkTracerProvider.builder().build();

        System.out.println(otelsdk);
        ApertureSDK sdk;
        try {
            sdk = ApertureSDK.builder()
                    .setHost("localhost")
                    .setPort(8089)
                    .build();
        } catch(Exception e) {
            System.out.println("Some error happened");
            return;
        }

        var flow = sdk.startFlow("someFeature", null);
        var text = "Hello World!";
        if (flow.accepted()) {
            System.out.println(text.toLowerCase());
        } else {
            System.out.println(text.toUpperCase());
        }
    }
}
