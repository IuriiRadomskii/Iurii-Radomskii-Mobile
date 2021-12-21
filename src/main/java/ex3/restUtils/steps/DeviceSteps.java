package ex3.restUtils.steps;

import ex3.restUtils.CloudServiceObject;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class DeviceSteps {


    public Response getAvailableDevices() {
        return CloudServiceObject
            .builder().setMethod(Method.GET).
    }


}
