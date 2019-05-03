package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class helper {

	public static String formatDates(String Date) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		java.util.Date date = formatter.parse(Date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date = formatter.format(date);
		return Date;
	}

	public static String colorFormatter(String color) {
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		hexValue[0] = hexValue[0].trim();

		int hexValue1 = Integer.parseInt(hexValue[0]);

		hexValue[1] = hexValue[1].trim();

		int hexValue2 = Integer.parseInt(hexValue[1]);

		hexValue[2] = hexValue[2].trim();

		int hexValue3 = Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

}
