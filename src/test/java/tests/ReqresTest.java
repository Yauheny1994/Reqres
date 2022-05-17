package tests;

import odjects.reqres.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresTest {


    @Test
    public void postCreateUserTest() {
        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();
        given()
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void getListUsersTest() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSingleUsersTest() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSingleUserNotFoundTest() {
        given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void getListResourceTest() {
        given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSingleResourceTest() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getSingleResourceNotFoundTest() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void putUpdateUserTest() {
        User user = User.builder()
                .name("marpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void patchUpdateUserTest() {
        User user = User.builder()
                .name("marpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void deleteUserTest() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }


    @Test
    public void postRegisterSuccessfulUserTest() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void postRegisterUnsuccessfulUserTest() {
        User user = User.builder()
                .email("sydney@fife")
                .build();
        given()
                .body(user)
                .log().all()
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void postLoginSuccessfulUserTest() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();
        given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void postLoginUnsuccessfulUserTest() {
        User user = User.builder()
                .email("peter@klaven")
                .build();
        given()
                .body(user)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void getDelayedResponseUserTest() {
        given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .log().all()
                .statusCode(200);
    }
}



