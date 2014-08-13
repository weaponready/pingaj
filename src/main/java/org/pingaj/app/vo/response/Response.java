package org.pingaj.app.vo.response;

/**
 * Created by Jamy on 14-8-14.
 */
public class Response {

    private boolean success;
    private int code;
    private String message;

    public Response() {
        this.success = false;
    }

    public Response success(){
        setSuccess(true);
        return this;
    }

    public Response code(int code){
        setCode(code);
        return this;
    }

    public Response msg(String message){
        setMessage(message);
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
