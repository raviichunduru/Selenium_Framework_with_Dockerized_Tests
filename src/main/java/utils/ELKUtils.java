package utils;

import enums.ConfigProperties;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public final class ELKUtils
{
    private ELKUtils()  {}

        public static void SendResultsToELK(String testName, String status)
        {
            if(PropertyUtils.getValue(ConfigProperties.SENDRESULTSTOELK).equalsIgnoreCase("yes"))
            {
                Map<String, String> map = new HashMap<>();

                map.put("testname", testName);
                map.put("status", status);
                map.put("executionTime", String.valueOf(LocalTime.now()));

                Response response = given().header("Content-Type", "application/json")
                        .log()
                        .all()
                        .body(map)
                        .post("http://localhost:9200/regression/result/");

                Assert.assertEquals(response.statusCode(), 201);
                response.prettyPrint();
            }
        }
}
