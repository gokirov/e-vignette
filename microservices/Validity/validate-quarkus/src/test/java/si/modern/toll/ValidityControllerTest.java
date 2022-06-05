package si.modern.toll;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ValidityControllerTest {

    @Test
    public void testValidateEndpointCheckVignette() {
        given()
                .contentType("tex" +
                        "t/plain").body("AB123CA")
                .when().post("/validate")
                .then()
                .statusCode(200)
                .body(is("true"));
        ;
    }
}
