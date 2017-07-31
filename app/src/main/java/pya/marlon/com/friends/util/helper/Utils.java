package pya.marlon.com.friends.util.helper;

/**
 * Created by marlonpya on 23/07/17.
 */

public class Utils {

    public static String getContent(String content) {
        return content == null || content.equals("null") ? "" : content;
    }
}
