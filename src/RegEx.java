import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Гончаревич Андрей 8 группа, лабораторная №5
 */
public class RegEx {

    //Task1
    public static String asterisksToItalic(String inputString) {

        String result = inputString;
        Pattern model = Pattern.compile("([^*]*([*][^*].+[*][^*]?)?)+");
        Matcher m = model.matcher(result);
        if (m.matches()) {
            {
                int firstindex;
                int secondindex;

                while (true) {
                    firstindex = result.indexOf("*");
                    secondindex = result.indexOf("*", firstindex + 1);
                    if (firstindex == -1 || secondindex == -1)
                        break;
                    result = result.substring(0, firstindex) + "<em>" + result.substring(firstindex + 1, secondindex) +
                            "</em>" + result.substring(secondindex + 1);
                }
            }
        }
        return result;

    }


    //Task2
    public static boolean isTime(String string) {
        Pattern timeModel = Pattern.compile("(([01]\\d)|(2[0-3])):([0-5]\\d)");
        return string.matches(timeModel.pattern());
    }

    //Task3
    public static boolean isGUID(String string) {
        Pattern GUIDModel = Pattern.compile("(\\{\\p{XDigit}{8}(-\\p{XDigit}{4}){3}-\\p{XDigit}{12}\\})|" +
                "(\\p{XDigit}{8}(-\\p{XDigit}{4}){3}-\\p{XDigit}{12})");
        return string.matches(GUIDModel.pattern());
    }

    //Task4
    public static boolean isIPv4(String string) {
        Pattern IPModel = Pattern.compile("(((1?\\d?\\d|(2[0-4]\\d)|(25[0-5]))\\.){3}((1?\\d?\\d)|(2[0-4]\\d)|(25[0-5])))|" +
                "((0x\\p{XDigit}{2}\\.){3}(0x\\p{XDigit}{2}))|" +
                "(([0-7]{4}\\.){3}([0-7]{4}))|" +
                "([0-7]{12})|" +
                "(\\d{1,10})|" +
                "(0x(\\p{XDigit}{8}))");
        return string.matches(IPModel.pattern());
    }

    //Task5
    public static boolean isURL(String string) {
        Pattern URLModel = Pattern.compile("((https?)://)?(w{3}\\.)?([^-][\\p{Alnum}\\-^_]*[^-]\\.)+([a-z]{2,3})((:\\d{4,5})?|((/\\p{Alnum}+[\\p{Alnum}#?=%&_\\.]*)*))");
        return string.matches(URLModel.pattern());
    }

    //Task6
    public static boolean isDate(String string) {
        Pattern DateModel = Pattern.compile("(((((0[1-9])|([12]\\d)|3[01])/(0[13578]|(1[02])))|(((0[1-9])|([12]\\d)|30)/(0[469]|11))|((0[1-9])|(1\\d)|((2[0-8])/02)))/((1[6-9]\\d{2})|[2-9]\\d{3}))|" +
                "(29/02/((1[6-9]|[2-9]\\d)(([2468][048])|(0[48])|(1[26]))|([2468][048]([02468][048])|([13579][26]))))");
        return string.matches(DateModel.pattern());
    }

    //Task7
    public static boolean isHtmlColor(String string) {
        Pattern ColorModel = Pattern.compile("#\\p{XDigit}{6}");
        return string.matches(ColorModel.pattern());
    }

    //Task8
    public static List<String> splitToTokens(String string) {
        Pattern model = Pattern.compile("(\"([^\"]+)\")|(\\w+[-']?\\w+)+");
        Matcher matcher = model.matcher(string);
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            if (matcher.group(2) != null)
                tokens.add(matcher.group(2));
            if (matcher.group(3) != null)
                tokens.add(matcher.group(3));
        }
        return tokens;
    }

    //Task9
    public static boolean isIRC(String string) {
        //[':' <<servername> | <nick> [ '!' <user> ] [ '@' <host> ]> <SPACE> ] <<letter> { <letter> } | <number> <number> <number>> <<SPACE> [ ':' <trailing> | <middle> <params> ]> <crlf>
        Pattern GUIDModel = Pattern.compile("\\[[\\p{Alnum}_\\.]*\\]!\\S+@[\\p{Alnum}\\.]+\\s(\\w+|\\d{3})(\\s#[a-z]+)* :.*");
        return string.matches(GUIDModel.pattern());
    }

}

