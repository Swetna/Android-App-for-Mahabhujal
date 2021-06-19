package in.mahabhujal.mahabhujal.loginApi;

public class ApiUtils {
    public static final String BASE_URL = "http://dbitbeproject.herokuapp.com/";

    public static LoginApi getUserService() {
        return LoginApiClient.getClient(BASE_URL).create(LoginApi.class);

    }
}
