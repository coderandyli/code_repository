import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lizhen on 2019-05-20
 */
public class Test {

    public static void main(String args[]) {
        String url = "https://www.e-ports.com/en-US/";
        String regEx = ".*en-US/.*";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(url);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
}
