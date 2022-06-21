package model;

import io.restassured.http.Header;

public interface Requestcapability {
    Header defaultHeader = new Header("Content-type", "application/json; charset=UTF-8");
    Header acceptJSONHeader = new Header("Accept", "application/json");

   static Header getAuthenticatedHeader(String encodeCreditStr){
        if (encodeCreditStr == null){
            throw new IllegalArgumentException("[ERR]encodeCreditStr can't be null");
        }
        return new Header("Authorization", "Basic " + encodeCreditStr);
    }
}
