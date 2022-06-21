package Builder;

import com.google.gson.Gson;

public class BodyJsonBuilder {
    public static <T> String getJsonContent(T datObject){

        return new Gson().toJson(datObject);

    }
}
