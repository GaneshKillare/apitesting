package reporting;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class BaseReport {


    public static void printRequestLogInReport(RequestSpecification requestSpecification) {


        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " );
        ExtentReportManager.logIMPInfoDetails( queryableRequestSpecification.getURI());
        ExtentReportManager.logInfoDetails("Method is " );
        ExtentReportManager.logIMPInfoDetails(queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        Object requestBody = queryableRequestSpecification.getBody();
        if (requestBody != null) {
            ExtentReportManager.logInfoDetails("Request body is ");
            ExtentReportManager.logJson(requestBody.toString());

        } else {
            ExtentReportManager.logInfoDetails("Request body is null");
        }

    }

    public static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is        " + response.getStatusCode());
        ExtentReportManager.logIMPInfoDetails(response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
         ExtentReportManager.logJson(response.getBody().prettyPrint());
    }
    // Write request in excel
		  /*  objMapper = new ObjectMapper();
			String requestPayload1 = objMapper.writeValueAsString(this.userpayload.getUsername());
			JsonNode jsonNode = objMapper.readTree(requestPayload1);
			String requestPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
			String responsePayload = response.asPrettyString();  */




			/*xLUtility = new XLUtility("test1.xlsx");
			xLUtility.writeDataCell("API Request", dataList); */

}
