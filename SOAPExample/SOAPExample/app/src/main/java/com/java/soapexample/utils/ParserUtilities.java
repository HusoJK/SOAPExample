package com.java.soapexample.utils;

import android.widget.Button;

import com.google.gson.Gson;
import com.java.soapexample.BuildConfig;
import com.java.soapexample.model.AppConstants;
import com.java.soapexample.model.Product;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserUtilities {
    public Product getData() throws IOException, XmlPullParserException {
        SoapObject request = new SoapObject(AppConstants.NAMESPACE, AppConstants.METHOD_NAME);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(AppConstants.URL);
        PropertyInfo param = new PropertyInfo();

        param.setName("JsonData");
        param.setValue(AppConstants.QUERY);
        request.addProperty(param);
        envelope.setOutputSoapObject(request);
        androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        List<HeaderProperty> headers = new ArrayList<>();
        headers.add(new HeaderProperty("username", BuildConfig.USERNAME));
        headers.add(new HeaderProperty("password", BuildConfig.PASSWORD));

        androidHttpTransport.call(AppConstants.SOAP_ACTION, envelope, headers);
        return extractDataFromXmlResponse(envelope.getResponse().toString());
    }

    private Product extractDataFromXmlResponse(String envelope) {
        Gson gson = new Gson();
        return gson.fromJson(envelope, Product.class);
    }
}
