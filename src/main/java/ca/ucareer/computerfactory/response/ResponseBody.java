package ca.ucareer.computerfactory.response;

public class ResponseBody<T> {

    private T result;
    private String msg;
    private Exception err;

    // needn't to add <T> here
    public ResponseBody(T result, String msg, Exception err){
        this.result = result;
        this.msg = msg;
        this.err = err;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Exception getErr() {
        return err;
    }

    public void setErr(Exception err) {
        this.err = err;
    }
}
