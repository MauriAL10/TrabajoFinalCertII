import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepDefinitions"}
        //1
        //tags = "@loginWithValidCredentials"
        //2
        //tags = "@loginWithInvalidCredentials"
        //3
        //tags = "@logoutTest"
        //4
        //tags = "@searchEmployeeByID"
        //5
        //tags = "@addEmployeeTest"
        //6
        //tags = "@searchByUsername"
        //7
        //tags = "@verifyInputsAreRequired"
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunner {
}
