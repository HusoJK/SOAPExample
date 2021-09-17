package com.java.soapexample.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int Result;

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

    public List<com.java.soapexample.model.Response> getResponse() {
        return Response;
    }

    public void setResponse(List<com.java.soapexample.model.Response> response) {
        Response = response;
    }

    private List<Response> Response;
}
