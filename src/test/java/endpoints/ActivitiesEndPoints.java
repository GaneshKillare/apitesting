package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Activities;
import reporting.BaseReport;

public class ActivitiesEndPoints {

    private static RequestSpecification getRequestSpecification() {

        return RestAssured.given().contentType(ContentType.JSON);

    }

    public static Response getAllActivities() {


        RequestSpecification requestSpecification = getRequestSpecification();

        Response response = requestSpecification.get(Routes.Authors_GetAll);

        BaseReport.printRequestLogInReport(requestSpecification);
        BaseReport.printResponseLogInReport(response);
        return response;
    }


    public static Response postActivities(Activities payload) {


        RequestSpecification requestSpecification = getRequestSpecification();
        Response response = requestSpecification.body(payload).post(Routes.Activities_PostURL);
        BaseReport.printRequestLogInReport(requestSpecification);
        BaseReport.printResponseLogInReport(response);
        return response;
    }

    public static Response getActivities(int id) {


        RequestSpecification requestSpecification = getRequestSpecification();
        Response response = requestSpecification.pathParams("id", id).get(Routes.Activities_GetURL);
        BaseReport.printRequestLogInReport(requestSpecification);
        BaseReport.printResponseLogInReport(response);
        return response;
    }

    public static Response updateActivities(int id, Activities payload) {


        RequestSpecification requestSpecification = getRequestSpecification();
        Response response = requestSpecification.pathParams("id", id).body(payload).when().put(Routes.Activities_PutURL);
        BaseReport.printRequestLogInReport(requestSpecification);
        BaseReport.printResponseLogInReport(response);
        return response;
    }

    public static Response deleteActivities(int id) {


        RequestSpecification requestSpecification = getRequestSpecification();
        Response response = requestSpecification.pathParams("id", id).delete(Routes.Activities_DeleteURL);
        BaseReport.printRequestLogInReport(requestSpecification);
        BaseReport.printResponseLogInReport(response);
        return response;
    }


}
