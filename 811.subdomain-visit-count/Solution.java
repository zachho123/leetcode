/* https://leetcode.com/problems/subdomain-visit-count/ */

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> output = new ArrayList<String>();

        for (String s : cpdomains) {
            String[] countAndDomain = s.split(" ");
            int count = Integer.parseInt(countAndDomain[0]);
            String domain = countAndDomain[1];

            while (domain.contains(".")) {
                // Remove leading "." if necessary
                domain = domain.startsWith(".") ? domain.substring(1) : domain;
                Integer oldCount = map.get(domain);
                int newCount = oldCount == null ? count : oldCount + count;

                map.put(domain, newCount);

                // Get substring for next subdomain (including period)
                int subIdx = domain.indexOf(".");
                domain = subIdx == -1 ? domain : domain.substring(subIdx);
            }
        }

        for (String key : map.keySet()) {
            String outputLine = map.get(key) + " " + key;
            output.add(outputLine);
        }

        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] input = {
            "900 google.mail.com",
            "50 yahoo.com",
            "1 intel.mail.com",
            "5 wiki.org"
        };

        for (String s : sol.subdomainVisits(input)) {
            System.out.println(s);
        }
    }
}
