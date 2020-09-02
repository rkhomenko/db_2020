package homework.enums;

import homework.enums.logic.BusinessLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Borisov
 */
public class HttpCodeService {
    private static final Pattern pattern = Pattern.compile("httpcode:\\s*(\\d+)");

    static int extractCode(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return 0;
    }

    public void processHttp(String text) {
        int code = extractCode(text);
        if (code == 0) {
            throw new RuntimeException("Cannot extract code");
        }

        HttpCodeProcessor processor = new HttpCodeProcessor();
        BusinessLogic logic = processor.getBusinessLogicForCode(code);
        logic.run();
    }
}
