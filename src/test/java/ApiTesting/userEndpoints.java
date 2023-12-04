package ApiTesting;
import static io.restassured.RestAssured.given;

//import api.endpoints.Routers;
//import api.payload.user;
//import api.endpoints.Routers;
//import api.endpoints.Routers;
//import api.endpoints.Routers;
//import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints {
	public static Response createUser(payload.user payload) {
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)

				.when().post(Routers.posturlcreate);

		return response;
	}
	public static Response createRegister(payload.user payload) {
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(payload)

				.when().post(Routers.posturlregister);

		return response;
	}

	public static Response GetUser(String userName) {
		Response response = given().accept(ContentType.JSON).pathParam("username", userName)

				.when().get(Routers.geturlSingleusernotfound);

		return response;
	}

	public static Response GetSingleUser(String userName) {

		Response response = given().accept(ContentType.JSON).pathParam("username", userName)

				.when().get(Routers.geturlSingleuser);

		return response;
	}

	public static Response GetSingleResourceUser(String userName) {

		Response response = given().accept(ContentType.JSON).pathParam("username", userName)

				.when().get(Routers.geturlSingleResource);

		return response;
	}

	public static Response UpdateUser(String userName, payload.user payload) {
		Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
				.pathParam("username", userName).body(payload)

				.when().put(Routers.posturlput);

		return response;
	}

	public static Response Delete(String userName) {
		Response response = given().accept(ContentType.JSON).pathParam("username", userName)

				.when().delete(Routers.Deleteuser);

		return response;
	}

}