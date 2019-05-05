package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {

	public String newComputerName;
	public String newIntrdoucedDate;
	public String newDiscontinuedDate;
	public String newCompany;

	public String editableComputerName;
	public String editableIntrdoucedDate;
	public String editableDiscontinuedDate;
	public String editableCompany;

	public String wrongComputerName;
	public String wrongIntrdoucedDate;
	public String wrongDiscontinuedDate;

	public String uniqueComputerName;

	private String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\ComputerData.json";

	public void JSONDataReader() throws FileNotFoundException, IOException, ParseException {
		File srcFile = new File(filepath);

		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

		for (Object jsonObj : jarray) {
			JSONObject computer = (JSONObject) jsonObj;
			newComputerName = (String) computer.get("new computer name");
			newIntrdoucedDate = (String) computer.get("new introduced date");
			newDiscontinuedDate = (String) computer.get("new discontinued date");
			newCompany = (String) computer.get("new company");

			editableComputerName = (String) computer.get("editable computer name");
			editableIntrdoucedDate = (String) computer.get("editable introduced date");
			editableDiscontinuedDate = (String) computer.get("editable discontinued date");
			editableCompany = (String) computer.get("editable company");

			wrongComputerName = (String) computer.get("wrong computer name");
			wrongIntrdoucedDate = (String) computer.get("wrong introduced date");
			wrongDiscontinuedDate = (String) computer.get("wrong discontinued date");

			uniqueComputerName = (String) computer.get("unique computer name");

		}

	}
}
