package rest.service.lib;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class RestAssuredOperationLog {

    private final ByteArrayOutputStream requestLog = new ByteArrayOutputStream();
    private final ByteArrayOutputStream responseLog = new ByteArrayOutputStream();
    private final PrintStream requestPrintStream;
    private final PrintStream responsePrintStream;

    public RestAssuredOperationLog() {
        try {
            requestPrintStream = new PrintStream(requestLog, false, StandardCharsets.UTF_8.name());
            responsePrintStream = new PrintStream(responseLog, false, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean specificationSpecified = false;

    void forSpecification(RequestSpecification requestSpecification) {
        requestSpecification.filters(
                new RequestLoggingFilter(new PrintStream(requestLog)),
                new ResponseLoggingFilter(new PrintStream(responseLog))
        );
        specificationSpecified = true;
    }

    public String requestLog() {
        if (!specificationSpecified) throw new IllegalStateException("RequestSpecification unspecified");
        requestPrintStream.flush();
        return new String(requestLog.toByteArray(), StandardCharsets.UTF_8);
    }

    public String responseLog() {
        if (!specificationSpecified) throw new IllegalStateException("RequestSpecification unspecified");
        responsePrintStream.flush();
        return new String(responseLog.toByteArray(), StandardCharsets.UTF_8);
    }
}
