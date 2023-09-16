package steps;

import com.foodics.base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
    @Before()
    public void runBeforeAnyScenario(){
        launchBrowser();
    }
    @After()
    public void runAfterAnyScenario(){
        driver.quit();
    }
}
