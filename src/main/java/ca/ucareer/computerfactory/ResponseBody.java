package ca.ucareer.computerfactory;

public class ResponseBody {
    private String message;
    private String result;
    private Error error;

    public ResponseBody(){
    }

    public ResponseBody(String message, String result, Error error) {
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
