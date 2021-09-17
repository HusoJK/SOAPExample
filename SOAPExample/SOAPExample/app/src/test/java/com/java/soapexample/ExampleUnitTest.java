package com.java.soapexample;

import com.google.gson.Gson;
import com.java.soapexample.model.Product;

import org.junit.Test;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.java.soapexample.model.AppConstants.METHOD_NAME;
import static com.java.soapexample.model.AppConstants.NAMESPACE;
import static com.java.soapexample.model.AppConstants.QUERY;
import static com.java.soapexample.model.AppConstants.SOAP_ACTION;
import static com.java.soapexample.model.AppConstants.URL;


public class ExampleUnitTest {
    private SoapSerializationEnvelope envelope;

    @Test
    public void getData() throws IOException, XmlPullParserException {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo param = new PropertyInfo();
        param.setName("JsonData");
        param.setValue(QUERY);

        request.addProperty(param);

        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        List<HeaderProperty> headers = new ArrayList<>();
        headers.add(new HeaderProperty("username", "testws"));
        headers.add(new HeaderProperty("password", "123"));

        androidHttpTransport.call(SOAP_ACTION, envelope, headers);
    }

    @Test
    public void extractDataFromXmlResponse() throws SoapFault {
        Gson gson = new Gson();
        Product product = gson.fromJson(envelope.getResponse().toString(), Product.class);
        System.out.println(product);
    }
}