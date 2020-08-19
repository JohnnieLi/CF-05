package ucareer;

public class ResponseBody<T>{
    private T result;
    private String message;
    private Exception error;

    public ResponseBody(T result, String message, Exception error) {
        this.result = result;
        this.message = message;
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }
}


