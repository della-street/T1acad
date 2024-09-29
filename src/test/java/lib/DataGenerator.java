package lib;

import java.util.HashMap;
import java.util.Map;

public class DataGenerator {
    public static Map<String, String> getAuthData() {
        Map<String, String> authData = new HashMap<>();
        authData.put("username", "string");
        authData.put("password", "string");
        return authData;
    }

    public static Map<String, String> getAuthDataOfUnregisteredUser() {
        Map<String, String> authData = new HashMap<>();
        authData.put("username", "newString");
        authData.put("password", "string");
        return authData;
    }

    public static Map<String, String> getAuthDataWithWrongEmail() {
        Map<String, String> authData = new HashMap<>();
        authData.put("username", "string");
        authData.put("password", "string2");
        return authData;
    }
}
