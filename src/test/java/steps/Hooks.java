package steps;

import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

	@Before("@db")
	public void dbHook() {
		System.out.println("Creating the database connection");
		utilities.DBUtils.createConnection();
	}
	
	@After("@db")
	public void afterDbHook() {
		System.out.println("Closing the database connection");
		utilities.DBUtils.destroyConnection();
	}
	
	@Before("@ui")
	public void setUp() {
		System.out.println("Setting up webDriver");
		Driver.getDriver();

	}
	
	@After("@ui")
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}
}
