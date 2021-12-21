package ex3.restUtils;

import ex3.AuthUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.net.URI;

public class RequestSpecs {

    private static final URI BASE_URI = URI.create("https://mobilecloud.epam.com/");
    private static final String TOKEN = AuthUtils.get("token");
    public static final RequestSpecification HEADER_WITH_TOKEN =
        new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .addHeader("Authorization", String.format("Bearer %s", TOKEN))
            .build();
}
