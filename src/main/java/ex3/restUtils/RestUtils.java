package ex3.restUtils;

public class RestUtils {

    public static final String baseURI = "https://mobilecloud.epam.com";
    public static final String projectName = "iurii_radomskii";


    //Find available devices
    //GET  {{baseURI}}/billing/unit/{{projectName}}/automation/api/device/android?web=chrome&version=7

    //Get device info
    //GET  {{baseURI}}/billing/unit/{{projectName}}/automation/api/device/{{deviceID}}

    //Take available device
    //POST {{baseURI}}/billing/unit/{{projectName}}/automation/api/device/{{deviceID}}?duration=20

    //Install App
    //{{baseURI}}/automation/api/storage/install/{{deviceID}}/{{appID}}"

}
