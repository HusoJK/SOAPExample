package com.java.soapexample.listener;

import com.java.soapexample.model.Response;

public interface ItemSelectedListener {
    void onItemSelected(Response response);
    void onItemDeleted(Response response);
}
