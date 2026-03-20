package service;

import target.JsonTarget;

public class JsonWebService implements JsonTarget {

    @Override
    public void requestData(String json) {
        System.out.println("Xử lý trực tiếp JSON: " + json);
    }
}