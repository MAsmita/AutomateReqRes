package reqresapis;

public class Payload {

    public static String register() {
        String payload = "{\r\n" + " \"email\": \"eve.holt@reqres.in\",\r\n"
                + "    \"password\": \"pistol\"\r\n" + "}";
        return payload;
    }

    public static String registerUnsuccess() {
        String payload = "{\r\n" + " \"email\": \"sydney@fife\"\r\n" + "}";
        return payload;
    }

    public static String loginSuccess() {
        String payload = "{\r\n" + " \"email\": \"eve.holt@reqres.in\",\r\n"
                + "    \"password\": \"cityslicka\"\r\n"
                + "}";
        return payload;
    }

    public static String unsuccessfulLogin() {
        String payload = "{\r\n" + "\"email\": \"peter@klaven\"\r\n" + "}";
        return payload;
    }
}
