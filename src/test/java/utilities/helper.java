package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class helper {
	/*
	 * Formatting Dates from 'dd MMM yyyy' format to 'yyyy-MM-dd'
	 */
	public static String formatDates(String Date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
			java.util.Date date;
			System.out.println("Date before formating is " + Date);
			date = formatter.parse(Date);

			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date = formatter.format(date);
			System.out.println("Date after formating is " + Date);
			return Date;
		} catch (ParseException e) {
			System.out.println("Excpetion while formatting the dates to 'yyyy-MM-dd' format " + e.getMessage());
			return null;
		}
	}

	/*
	 * Formatting color from rgb format to hexadecimal format
	 */
	public static String colorFormatter(String color) {
		try {
			String[] hexValue = null;
			System.out.println("color in rgb is " + color);

			// for Chrome values , will use "rgba"
			if (color.contains("rgba")) {
				hexValue = color.replace("rgba(", "").replace(")", "").split(",");
			}
			// for Firefox values m will use "rgb"
			else if (color.contains("rgb")) {
				hexValue = color.replace("rgb(", "").replace(")", "").split(",");
			}
			hexValue[0] = hexValue[0].trim();

			int hexValue1 = Integer.parseInt(hexValue[0]);

			hexValue[1] = hexValue[1].trim();

			int hexValue2 = Integer.parseInt(hexValue[1]);
			hexValue[2] = hexValue[2].trim();

			int hexValue3 = Integer.parseInt(hexValue[2]);

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
			System.out.println("color in hexadecimal is  " + actualColor);
			return actualColor;
		} catch (Exception e) {
			System.out.println("Excpetion while formatting the color to hexdecimal " + e.getMessage());
			return null;
		}

	}
	/*
	 * Taking screenshots helper
	 */

	public static void captureScreenshot(WebDriver driver, String screenshotname) {
		Path dest = Paths.get("./Screenshots", screenshotname + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			System.out.println("ScreenShot Taked with name " + screenshotname + ".png");
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot" + e.getMessage());
		}
	}

}
