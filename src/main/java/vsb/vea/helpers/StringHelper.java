package vsb.vea.helpers;

import java.util.regex.Pattern;

public final class StringHelper {
	public static Boolean isNullOrEmpty(String value) {
		if(value == null || value == "") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Boolean containsCaseInsensitive(String src, String dest) {
		return Pattern.compile(Pattern.quote(dest), Pattern.CASE_INSENSITIVE)
			    .matcher(src)
			    .find();
	}
}
