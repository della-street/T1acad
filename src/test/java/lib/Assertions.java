package lib;

import io.restassured.response.Response;
import schema.GetProductList;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Assertions {
    //Проверка статус-кода
    public static void assertResponseCodeEquals(Response Response, int expectedStatusCode) {
        assertEquals(
                expectedStatusCode,
                Response.statusCode(),
                "Status Code text isn't as expected"
        );
    }

    //Проверка, что в теле ответа есть нужный ключ json
    public static void assertJsonHasField(Response Response, String expectedFieldName) {
        Response.then().assertThat().body("$", hasKey(expectedFieldName));
    }

    //Проверка, что в ответе переданы данные в формате JSON
    public static void jsonEqualsTo(Response Response) {
        Response.then().extract().as(GetProductList.class);
    }

    public static void assertResponseTextContains(Response Response, String expectedAnswer) {
        assertTrue(
                Response.asString().contains(expectedAnswer),
                "Response text doesn't contain expected answer"
        );
    }
}
