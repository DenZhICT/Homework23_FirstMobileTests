package browserstack.helpers;

import browserstack.config.MobileDriverConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        MobileDriverConfig config = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .filter(CustomApiListener.withCustomTemplates())
                .log().all()
                .auth().basic(config.getBrowserstackUser(), config.getBrowserstackKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

}
