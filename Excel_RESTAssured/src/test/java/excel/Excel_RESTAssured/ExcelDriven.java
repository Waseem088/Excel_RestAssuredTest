package excel.Excel_RESTAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ExcelDriven{

	@Test
	public void addBook() throws IOException
	{
		dataDriven d=new dataDriven();
		ArrayList data=d.getData("RestAddbook", "RestAssured");
		
		HashMap<String, Object>  map = new HashMap<String, Object>();
		
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author",data.get(4));

		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type", "application/json")
		.body(map)
		.when()
		.post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js= ReUsableMethods.rawToJson(resp);
		String id=js.get("ID");
		System.out.println(id);
		
	}
		
	
}	
