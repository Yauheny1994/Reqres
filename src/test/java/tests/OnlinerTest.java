package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OnlinerTest {

    @Test
    public void getCurrencyUsdRateTest() {
        given()
                .log().all()
                .when()
                .get("https://www.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
                .then()
                .log().all()
                .statusCode(200)
                .body("amount", equalTo("2,5945"));
    }

    @Test
    public void getCurrencyEurRateTest() {
        given()
                .log().all()
                .when()
                .get("https://www.onliner.by/sdapi/kurs/api/bestrate?currency=EUR&type=nbrb")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getCurrencyRubRateTest() {
        given()
                .when()
                .get("https://www.onliner.by/sdapi/kurs/api/bestrate?currency=RUB&type=nbrb")
                .then()
                .statusCode(200);
    }
}
