import com.fluxninja.aperture.sdk.ApertureSDK

fun main(args: Array<String>) {

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