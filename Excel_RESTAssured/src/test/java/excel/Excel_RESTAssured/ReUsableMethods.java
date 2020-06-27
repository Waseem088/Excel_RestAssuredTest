package excel.Excel_RESTAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReUsableMethods {
	
	public static JsonPath rawToJson(String resp){
		
		JsonPath js= new JsonPath(resp);
		return js;
	}

}
