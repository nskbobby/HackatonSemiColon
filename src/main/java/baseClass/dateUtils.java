package baseClass;

import java.util.Date;

public class dateUtils {

	public static String getTimeStamp() {
		Date date = new Date();
		return (date.toString().replaceAll(" ", "_").replaceAll(":", "_"));
	}
}
