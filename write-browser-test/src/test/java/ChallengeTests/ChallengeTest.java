package ChallengeTests;

import Base.BaseTests;
import org.testng.annotations.Test;
import pages.ChallengePage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ChallengeTest extends BaseTests {

    @Test
    public void challengeTest() {
        assertTrue(homePage.verifyHomePage());
        ChallengePage challengePage = HomePage.clickFormAuthLink();
        assertTrue(challengePage.verifyChallengePage());
        assertTrue(challengePage.verifySolutions());

    }
}





