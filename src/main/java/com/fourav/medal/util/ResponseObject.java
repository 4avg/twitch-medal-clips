package com.fourav.medal.util;

import static com.fourav.medal.util.Constants.FAILURE;
import static com.fourav.medal.util.Constants.SUCCESS;

public class ResponseObject {


    private String status;

    private Object content;

    private String error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ResponseObject(String status, Object content, String error) {
        this.status = status;
        this.content = content;
        this.error = error;
    }

    public static ResponseObject success(Object object ){
        return new ResponseObject(SUCCESS, object  , null);
    }

    public static ResponseObject failure(String message ){
        return new ResponseObject(FAILURE,  null  , message);
    }
}
