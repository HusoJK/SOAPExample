package com.java.soapexample.model;

public class AppConstants {
    public static final String NAMESPACE = "http://ws/";
    public static final String URL= "http://stawiz.mepsan.com.tr:8888/Marwiz/WsIncome";
    public static final String SOAP_ACTION = "http://ws/ProcessDataList";
    public static final String METHOD_NAME= "ProcessDataList";

    public static final String QUERY = "{ \"process_type\":0,\n" +
            " \"branch_code\":\"9000003871\",\n" +
            " \"begindate\":\"2021-05-05 23:59:59\",\n" +
            " \"enddate\":\"2021-06-07 23:59:59\",\n" +
            " \"account_code\":\"\"}";
}
