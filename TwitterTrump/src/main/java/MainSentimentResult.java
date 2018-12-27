import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainSentimentResult {
    public static void main(String[] args) throws IOException {
        FileInputStream inFile = new FileInputStream("C:\\Users\\khusn\\Desktop\\TRUMP\\first_half.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str, StandardCharsets.UTF_8);
        System.out.println("Very negative: " + StringUtils.countMatches(text,"Very negative"));
        System.out.println("Negative: " +StringUtils.countMatches(text,"Negative"));
        System.out.println("Neutral: " +StringUtils.countMatches(text,"Neutral"));
        System.out.println("Positive: " +StringUtils.countMatches(text,"Positive"));
        System.out.println("Very positive: " +StringUtils.countMatches(text,"Very positive"));

    }
    static int KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for
        pattern match */
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res; }

    static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];

                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
