package com.casino.api;

import com.casino.AutotestBase;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.casino.api.dto.request.AuthGuestRequest;
import com.casino.api.dto.request.AuthPlayerRequest;
import com.casino.api.dto.response.AuthResponse;
import com.casino.api.lib.RestAssuredOperationLog;

import java.util.Base64;
import java.util.function.Function;

import static com.casino.api.lib.HttpMethods.*;
import static com.casino.api.lib.Rest.restAssured;

public abstract class ApiBase extends AutotestBase {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected String protocol;
    protected String server;
    protected String version;
    protected String basicPass;
    protected String basicName;
    protected int port;

    public ApiBase() {
        protocol = config.getString("autotests.protocol");
        server = config.getString("autotests.server");
        version = config.getString("autotests.version");
        port = config.getInt("autotests.port");
        basicName = config.getString("autotests.basic_auth_name");
        basicPass = config.getString("autotests.basic_auth_pass");
    }


    protected ValidatableResponse restGet(String path, Function<RequestSpecification, RequestSpecification> customizeRequestFunc) {

        Function<RequestSpecification, RequestSpecification> function = request ->
                customizeRequestFunc.apply(request.header("Content-Type", "application/json"));

        Pair<ValidatableResponse, RestAssuredOperationLog> result = restAssured(GET, protocol + server + version, port, path, function);

        log.debug(String.format("\nGET Request:\n%s\nGET Response:\n%s", result.getRight().requestLog(), result.getRight().responseLog()));

        return result.getLeft();
    }

    protected ValidatableResponse restPost(String path, Function<RequestSpecification, RequestSpecification> customizeRequestFunc) {

        Function<RequestSpecification, RequestSpecification> function = request ->
                customizeRequestFunc.apply(request.header("Content-Type", "application/json"));

        Pair<ValidatableResponse, RestAssuredOperationLog> result = restAssured(POST, protocol + server + version, port, path, function);

        log.debug(String.format(
                "\nPOST Request:\n%s\nPOST Response:\n%s",
                result.getRight().requestLog(),
                result.getRight().responseLog()
        ));

        return result.getLeft();
    }


    protected String getGuestAccessToken() {
        return restPost(
                "/oauth2/token",
                request ->
                        request
                                .auth()
                                .preemptive()
                                .basic(basicName, basicPass)
                                .body(
                                        new AuthGuestRequest()
                                                .setGrantType("client_credentials")
                                                .setScope("guest:default"))
        )
                .statusCode(200)
                .extract()
                .body()
                .as(AuthResponse.class)
                .getAccessToken();
    }


    protected String getPlayerAccessToken(String userName, String base64Pass) {
        return restPost("/oauth2/token", request -> request
                .auth()
                .preemptive()
                .basic(basicName, basicPass)
                .body(new AuthPlayerRequest()
                        .setGrantType("password")
                        .setPassword(base64Pass)
                        .setUsername(userName)
                )
        )
                .statusCode(200)
                .extract()
                .body()
                .as(AuthResponse.class)
                .getAccessToken();
    }


    protected String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
