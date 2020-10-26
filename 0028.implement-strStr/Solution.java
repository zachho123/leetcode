public class Solution {
    /**
     * Return the index of the first occurrence of needle in haystack, or -1
     * if needle is not part of haystack. If needle is an empty string, return
     * 0.
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            // Not enough places for needle to appear after i
            if (i + needle.length() > haystack.length()) {
                break;
            }

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] inputs = {
            {"hello", "ll"},
            {"aaaaa", "bba"},
            {"", ""},
            {"aaa", "aaaa"},
            {"hellolllo", "lll"},
            {"a", "a"}
        };

        for (String[] in : inputs) {
            System.out.println(in[0] + " " + in[1] + " "  + s.strStr(in[0], in[1]));
        }
    }
}