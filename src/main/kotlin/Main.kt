import com.fluxninja.aperture.sdk.ApertureSDK
import io.opentelemetry.sdk.trace.SdkTracerProvider


fun main(args: Array<String>) {

    val otelsdk = SdkTracerProvider.builder().build()

    println(otelsdk.toString())
    val sdk = ApertureSDK.builder()
        .setHost("localhost")
        .setPort(8089)
        .build()

    val flow = sdk.startFlow("someFeature", mapOf())
    val text = "Hello World!"
    if (flow.accepted()) {
        println(text.lowercase())
    } else {
        println(text.uppercase())
    }
}