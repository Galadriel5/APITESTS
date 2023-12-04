package ApiTesting;

//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import api.endpoints.userEndPoints;
//import api.endpoints.userEndPoints;
//import api.payload.user;
import io.restassured.response.Response;
import payload.user;

public class StepDefinitionuserTest {

	Faker faker;
	user userPayload;
	public static Logger logger;

	@Before
	public void generateTestData() {
		faker = new Faker();
		userPayload = new user();

		userPayload.setUsername(faker.name().username());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setJob(faker.job().position());

		// obtain logger

		logger = LogManager.getLogger("ApiAgastya");
	}

	@Given("To verify the Create User executed")
	public void testCreateUser() {
		Response response = userEndpoints.createUser(userPayload);

		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 201);

		// log
		logger.info("Create User executed.");
	}

	@When("Get User Data executed")
	public void testGetSingleUserNotFoundData() {
		Response response = userEndpoints.GetUser(this.userPayload.getUsername());

		System.out.println("Read User Data.");
		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 404);

		// log
		logger.info("Get User Data executed.");
	}

	@Given("Get User ends Data executed")
	public void TestGetSingleResourceUser() {
		Response response = userEndpoints.GetSingleResourceUser(this.userPayload.getUsername());

		System.out.println("Read User Data.");
		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 404);

		// log
		logger.info("Get User Data executed.");
	}

	@When("After Update User Data")
	public void testUpdateUser() {
		userPayload.setUsername(faker.name().username());
		Response response = userEndpoints.UpdateUser(this.userPayload.getUsername(), userPayload);

		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 200);

		// Read User data to check if first name is updated

		Response responsePostUpdate = userEndpoints.GetUser(this.userPayload.getUsername());

		System.out.println("After Update User Data.");

		responsePostUpdate.then().log().all();

		// log
		logger.info("Update User executed.");

	}

	@Then("Delete User executed")
			
	public void testDeleteUser() {

		Response response = userEndpoints.Delete(this.userPayload.getUsername());

		System.out.println("Delete User Data.");

		// log response
		response.then().log().all();

		// validation
		Assert.assertEquals(response.getStatusCode(), 204);

		// log
		 logger.info("Delete User executed.");

	}

}
