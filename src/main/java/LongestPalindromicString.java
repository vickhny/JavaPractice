public class LongestPalindromicString {

    public static void main(String[] args) {
        String s = "abb";
        LongestPalindromicString l = new LongestPalindromicString();
        System.out.println(l.longestPalindromeBest(s));
    }

    public String longestPalindrome(String s) {

        String longestPalindrome = "";
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        if (s.equalsIgnoreCase(sb.reverse().toString())){
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (s.substring(i, j).equalsIgnoreCase(new StringBuilder(s.substring(i, j)).reverse().toString()) && longestPalindrome.length() < s.substring(i, j).length()) {
                    longestPalindrome = s.substring(i, j);
                }
            }
        }
        return longestPalindrome;
    }

    public String longestPalindromeBest(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
