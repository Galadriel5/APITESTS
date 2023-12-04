package ApiTesting;

public class Routers {

	public static String baseurl = "https://reqres.in/api";

//user module urls
	public static String posturlcreate = baseurl + "/user";
	public static String geturlList = " https://reqres.in/api/users/2";
	public static String geturlSingleuser = baseurl + "users/";

	public static String geturlSingleusernotfound = baseurl + "/users/{username}";
	public static String geturlListResource = baseurl + "/unknown";
	public static String geturlSingleResource = baseurl + "/unknown/{username}";

	public static String geturlSingleResourcenotfound = baseurl + "/unknown/{username}";

	public static String posturlupdateuser = "https://reqres.in/api/users/2";
	public static String posturlput = baseurl + "/users/{username}";

	public static String posturlpatch = baseurl + "/users/{username}";
	public static String posturlregister = baseurl + "/register";

	public static String posturlregisterunsuccesfully = baseurl + "/register";
	public static String Deleteuser = baseurl + "/users/{username}";

	public static String posturlloginsuccesfully = baseurl + "/login";

	public static String posturlloginunsuccesfully = baseurl + "/login";

	public static String getdelayresponse = baseurl + "/users?delay=3";

}
