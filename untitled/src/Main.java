import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String txt = "118.236.131.200 - - [31/Mar/2015:23:56:57 +04:00] \"GET /addbasket.phtml?id_book=92 HTTP 1.1\" 200 2210 ID55563";

        String re1 = "((?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))(?![\\d])";    // IPv4 IP Address 1
        String re2 = ".*?";    // Non-greedy match on filler
        String re3 = "(\\[31\\/Mar\\/2015:23:56:57 \\+04:00\\])";    // Square Braces 1
        String re4 = ".*?";    // Non-greedy match on filler
        String re5 = "(GET)";    // Word 1
        String re6 = ".*?";    // Non-greedy match on filler
        String re7 = "(\\w*\\.phtml)";    // Fully Qualified Domain Name 1
        String re8 = ".*?";    // Non-greedy match on filler
        String re9 = "(id_book)";    // Variable Name 1
        String re10 = ".*?";    // Non-greedy match on filler
        String re11 = "(HTTP)";    // Word 2
        String re12 = ".*?";    // Non-greedy match on filler
        String re13 = "(\\d*)";    // Integer Number 1
        String re14 = ".*?";    // Non-greedy match on filler
        String re15 = "(ID\\d*)";    // Alphanum 1

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String ipaddress1 = m.group(1);
            String sbraces1 = m.group(2);
            String word1 = m.group(3);
            String fqdn1 = m.group(4);
            String var1 = m.group(5);
            String word2 = m.group(6);
            String int1 = m.group(7);
            String alphanum1 = m.group(8);
            System.out.print("(" + ipaddress1.toString() + ")" + "(" + sbraces1.toString() + ")" + "(" + word1.toString() + ")" + "(" + fqdn1.toString() + ")" + "(" + var1.toString() + ")" + "(" + word2.toString() + ")" + "(" + int1.toString() + ")" + "(" + alphanum1.toString() + ")" + "\n");
        }
        System.out.println("LOL");
    }
}
