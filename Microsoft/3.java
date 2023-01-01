//Bulls and cows
package Microsoft;

class Solution {
    private int cow = 0;
    private int bull = 0;
    private int[]num = new int[10];
    public String getHint(String secret, String guess) {
        if(secret.length() != guess.length()) return"";

        for(int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i)-'0';
            int g = guess.charAt(i)-'0';

            if(s == g) bull++;
            else {
                if(num[s]++ < 0) cow++;
                if(num[g]-- > 0) cow++;

            }
        }
        return bull+"A"+cow+"B";
    }
}