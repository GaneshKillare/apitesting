package endpoints;

public class Routes {

    public static String base_url = "https://fakerestapi.azurewebsites.net/";


    // Activities

    public static String Activities_PostURL = base_url + "/api/v1/Activities";
    public static String Activities_GetURL = base_url + "/api/v1/Activities/{id}";
    public static String Activities_PutURL = base_url + "/api/v1/Activities/{id}";
    public static String Activities_DeleteURL = base_url + "/api/v1/Activities/{id}";


    // Authors
    public static String Authors_PostURL = base_url + "/api/v1/Authors";
    public static String Authors_GetURLByName = base_url + "/api/v1/Authors/authors/books/{idBook}";
    public static String Authors_GetURLById = base_url + "/api/v1/Authors/{id}";
    public static String Authors_PutURL = base_url + "/api/v1/Authors/{id}";
    public static String Authors_DeleteURL = base_url + "/api/v1/Activities/{id}";


    // Books
    public static String Books_PostURL = base_url + "/api/v1/Books";
    public static String Books_GetURLForAllBooks = base_url + "/api/v1/Books";
    public static String Books_GetURLById = base_url + "/api/v1/Books/{id}";
    public static String Books_PutURL = base_url + "/api/v1/Books/{id}";
    public static String Books_DeleteURL = base_url + "/api/v1/Books/{id}";

    // Users
    public static String Users_PostURL = base_url + "/api/v1/Users";
    public static String Users_GetURLForAllUsers = base_url + "/api/v1/Users";
    public static String Users_GetURLById = base_url + "/api/v1/Users/{id}";
    public static String Users_PutURL = base_url + "/api/v1/Users/{id}";
    public static String Users_DeleteURL = base_url + "/api/v1/Users/{id}";


}
