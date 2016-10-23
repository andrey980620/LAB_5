import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Гончаревич Андрей 8 группа, лабораторная №5
 */
public class Tester {
    public static void test(int option, String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new FileReader(fileName));
        String line;

        System.out.println("\nTesting " + option + " task:\n");
        while (file.hasNextLine()) {
            line = file.nextLine();
            System.out.print(line);
            switch (option) {
                case 1:
                    System.out.println(" => " + RegEx.asterisksToItalic(line));
                    break;
                case 2:
                    System.out.println(" => " + RegEx.isTime(line));
                    break;
                case 3:
                    System.out.println(" => " + RegEx.isGUID(line));
                    break;
                case 4:
                    System.out.println(" => " + RegEx.isIPv4(line));
                    break;
                case 5:
                    System.out.println(" => " + RegEx.isURL(line));
                    break;
                case 6:
                    System.out.println(" => " + RegEx.isDate(line));
                    break;
                case 7:
                    System.out.println(" => " + RegEx.isHtmlColor(line));
                    break;
                case 8:
                    System.out.println(" => " + RegEx.splitToTokens(line));
                    break;
                case 9:
                    System.out.println(" => " + RegEx.isIRC(line));
                    break;
            }
        }
    }
}
