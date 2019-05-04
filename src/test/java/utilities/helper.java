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

	public static String formatDates(String Date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
			java.util.Date date;

			date = formatter.parse(Date);

			formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date = formatter.format(date);
			return Date;
		} catch (ParseException e) {
			System.out.println("Excpetion while formatting the dates to 'yyyy-MM-dd' format " + e.getMessage());
			return null;
		}
	}

	public static String colorFormatter(String color) {
		try {
			System.out.println("color is "+ color);
			String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

			hexValue[0] = hexValue[0].trim();

			int hexValue1 = Integer.parseInt(hexValue[0]);

			hexValue[1] = hexValue[1].trim();

			int hexValue2 = Integer.parseInt(hexValue[1]);

			hexValue[2] = hexValue[2].trim();

			int hexValue3 = Integer.parseInt(hexValue[2]);

			String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
			System.out.println("color is "+ actualColor);
			return actualColor;
		} catch (Exception e) {
			System.out.println("Excpetion while formatting the color to hexdecimal " + e.getMessage());
			return null;
		}

	}

	public static void captureScreenshot(WebDriver driver, String screenshotname) {
		Path dest = Paths.get("./Screenshots", screenshotname + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot" + e.getMessage());
		}
	}

}
