package lib;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class BaseTestCase {
    @BeforeAll
    public static void setBaseURI() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
    }

    @Step("Make a POST-request to login")
    public Response login(String url, Map<String, String> authData) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(authData)
                .when()
                .post(url)
                .andReturn();
    }

    @Step("Make a GET-request")
    public Response makeGetRequest(String url) {
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(url)
                .andReturn();
    }

    @Step("Make a POST-request to get authorization token")
    public String getAuthToken (Response Response) {
        return Response.jsonPath().getString("access_token");
    }

    @Step("Make a GET-request with authorization token")
    public Response makeGetRequestWithAuthToken(String url, String token) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(url)
                .andReturn();
    }
}

