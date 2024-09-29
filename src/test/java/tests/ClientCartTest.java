package tests;

import io.restassured.response.Response;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientCartTest extends BaseTestCase {
    @Test
    @DisplayName("Получение карты клиента")
    public void getClientCard() {
        //Логин
        Response login = this.login("/login",
                DataGenerator.getAuthData());

        String token = getAuthToken(login);

        //Запрос с авторизационным токеном
        Response getClientCard = this.makeGetRequestWithAuthToken("/cart", token);

        //responseProductList.then().extract().as(GetProductList.class);
        Assertions.assertResponseCodeEquals(getClientCard, 200);
    }
}
