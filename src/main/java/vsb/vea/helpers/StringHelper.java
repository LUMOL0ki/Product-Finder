package vsb.vea.helpers;

public final class StringHelper {
	public static Boolean isNullOrEmpty(String value) {
		if(value == null || value == "") {
			return true;
		}
		else {
			return false;
		}
	}
}
