package ex3.restUtils;

import io.restassured.http.Method;
import java.util.HashMap;
import java.util.Map;

public class CloudServiceObject {

    protected Method requestMethod;
    protected Map<String, String> queryParams;
    protected Map<String, String> pathParams;

    CloudServiceObject(Map<String, String> queryParams, Map<String, String> pathParams, Method requestMethod) {
        this.queryParams = queryParams;
        this.pathParams = pathParams;
        this.requestMethod = requestMethod;
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public static class RequestBuilder {

        protected Map<String, String> queryParams = new HashMap<>();
        protected Map<String, String> pathParams = new HashMap<>();
        protected Method requestMethod;

        public RequestBuilder() {
        }

        public RequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public RequestBuilder addQueryParam(String paramName, String paramValue) {
            queryParams.put(paramName, paramValue);
            return this;
        }

        public RequestBuilder addPathParam(String paramName, String paramValue) {
            pathParams.put(paramName, paramValue);
            return this;
        }

        public CloudServiceObject buildRequest() {
            return new CloudServiceObject(queryParams, pathParams, requestMethod);
        }
    }

}
