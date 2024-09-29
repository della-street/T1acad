package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lib.Assertions;
import lib.BaseTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import schema.GetProductList;
import schema.Product;

import java.util.List;

public class ProductsPageTest extends BaseTestCase {
    @Test
    @DisplayName("Получение списка продуктов")
    public void getProductList() {
        Response responseProductList = this.makeGetRequest(
                "/products"
        );
        //responseProductList.then().extract().as(GetProductList.class);
        Assertions.assertResponseCodeEquals(responseProductList, 200);
    }

    @Test
    @DisplayName("Поиск продукта по id")
    public void getProductByID() {
        String id = "1";
        Response responseProductList = this.makeGetRequest(
                "/products" + "/" + id
        );
        //responseProductList.then().extract().as(GetProductList.class);
        Assertions.assertResponseCodeEquals(responseProductList, 200);
    }

    @Test
    @DisplayName("Поиск несуществующего продукта по id")
    public void getNonExistingProductByID() {
        String id = "101010";
        Response responseProduct = this.makeGetRequest(
                "/products" + "/" + id
        );
        //responseProductList.then().extract().as(GetProductList.class);
        Assertions.assertResponseCodeEquals(responseProduct, 404);
        Assertions.assertResponseTextContains(responseProduct, "Product not found");
    }
}
