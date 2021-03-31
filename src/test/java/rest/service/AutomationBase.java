package rest.service;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.service.lib.RestAssuredOperationLog;

import java.io.File;
import java.util.function.Function;

import static rest.service.lib.HttpMethods.*;
import static rest.service.lib.Rest.restAssured;

public abstract class AutomationBase {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected Config config;
    protected String protocol;
    protected String server;
    protected String version;
    protected String basicPass;
    protected String basicName;
    protected int port;

    public AutomationBase() {
        config = ConfigFactory.parseFile(new File("autotests.conf"));
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
}
