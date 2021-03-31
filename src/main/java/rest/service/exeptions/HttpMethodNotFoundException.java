package rest.service.exeptions;

public class HttpMethodNotFoundException extends RuntimeException {
    public HttpMethodNotFoundException(String message) {
        super(message);
    }
}
