package rest.service.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import rest.service.AutomationBase;
import rest.service.dto.request.PlayerRegisterRequest;
import rest.service.dto.response.PlayerResponse;

public class ApiTests extends AutomationBase {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test(testName = "Register new player")
    public void registerNewPlayer() {
        log.debug("Test: 'Register new player'");

        String password = encodeToBase64("password123");
        String userName = "test_user" + System.currentTimeMillis();


        String guestToken = getGuestAccessToken();


        long newPlayerId = restPost("/players", request -> request
                .header("Authorization", "Bearer " + guestToken)
                .body(new PlayerRegisterRequest()
                                .setUsername(userName)
                                .setPasswordChange(password)
                                .setPasswordRepeat(password)
                                .setEmail(userName + "@tst.com")
                                .setName("Tester")
                                .setSurname("Testovich")
                             // .setCurrencyCode("USD") todo:: Is it Bug??
                )
        )
                .statusCode(201)
                .extract()
                .body()
                .as(PlayerResponse.class)
                .getId();


        String playerToken = getPlayerAccessToken(userName, password);


        restGet("/players/" + newPlayerId, request -> request
                .header("Authorization", "Bearer " + playerToken)
        )
                .statusCode(200)
                .extract()
                .body()
                .as(PlayerResponse.class);


        restGet("/players/" + (newPlayerId - 1), request -> request
                .header("Authorization", "Bearer " + playerToken)
        ).statusCode(404);

    }
}
