package rest.service.lib;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.tuple.Pair;
import rest.service.exeptions.HttpMethodNotFoundException;

import java.util.function.Function;

public class Rest {

    public static Pair<ValidatableResponse, RestAssuredOperationLog> restAssured(
            HttpMethods method,
            String url,
            int port,
            String path,
            Function<RequestSpecification, RequestSpecification> customizeRequestFunc
    ) {

        RestAssuredOperationLog operationLog = new RestAssuredOperationLog();

        RestAssured.registerParser("text/plain", Parser.TEXT);

        RequestSpecification requestSpec = RestAssured
                .given()
                .baseUri(url)
                .port(port)
                .when();

        requestSpec = customizeRequestFunc.apply(requestSpec);

        operationLog.forSpecification(requestSpec);

        switch (method) {
            case GET:
                return Pair.of(requestSpec.get(path).then(), operationLog);

            case POST:
                return Pair.of(requestSpec.post(path).then(), operationLog);

            default:
                throw new HttpMethodNotFoundException(String.format("Has no implementation for http method: '%s'", method));
        }
    }
}
