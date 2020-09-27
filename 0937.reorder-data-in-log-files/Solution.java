import java.util.Comparator;
import java.util.Arrays;

/***
 * You have an array of logs. Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier, after
 * which one of the following will be true (based on the identifier):
 * - Each word after the identifier will be only lowercase letters
 * - Each word after the identifier will be only digits
 * 
 * We call these two types, letter logs and digit logs. It is guaranteed that
 * each log has at least one word after its identifier.
 * 
 * Reorder the logs such that letter logs come before digit logs. Letter logs
 * will be ordered lexographically ignoring identifier, with the indentifier
 * used in case of ties. The digit logs should be put in their original order.
 */
public class Solution {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String a, String b) {
                String id1 = a.substring(0, a.indexOf(" "));
                String id2 = b.substring(0, b.indexOf(" "));
                String content1 = a.substring(a.indexOf(" ") + 1);
                String content2 = b.substring(b.indexOf(" ") + 1);
                char content1Start = content1.charAt(0);
                char content2Start = content2.charAt(0);
                int contentCompare = content1.compareTo(content2);

                if (content1Start >= 'a' && content1Start <= 'z' &&
                content2Start >= 'a' && content2Start <= 'z') {
                    if (contentCompare == 0) {
                        return id1.compareTo(id2);
                    }
                    return contentCompare;
                } else if (content1Start >= 'a' && content1Start <= 'z') {
                    return -1;
                } else if (content2Start >= 'a' && content2Start <= 'z') {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return logs;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] input = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        };
        String[] result = s.reorderLogFiles(input);

        for (String log : result) {
            System.out.println(log);
        }
    }
}