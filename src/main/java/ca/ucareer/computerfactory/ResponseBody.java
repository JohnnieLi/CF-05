package ca.ucareer.computerfactory;

public class ResponseBody<T> {
    private String message;
    private T result;
    private Error error;

    public ResponseBody(){
    }

    public ResponseBody(String message, T result, Error error) {
        this.message = message;
        this.result = result;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
