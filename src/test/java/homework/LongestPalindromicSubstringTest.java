package homework;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubstringTest {
    public static class Input {
        String s;
        public Input(String s) {
            this.s = s;
        }
        @Override
        public String toString() {
            return s;
        }
    }

    public static class Testcase {
        Input input;
        String output;

        public Testcase(Input input, String output) {
            this.input = input;
            this.output = output;
        }

        public static Testcase fromJsonFile(String filePath) throws IOException {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject testcaseJson = new JSONObject(content);

            JSONObject inputJson = testcaseJson.getJSONObject("input");
            JSONObject outputJson = testcaseJson.getJSONObject("output");

            String s = inputJson.getString("s");
            String answer = outputJson.getString("answer");

            return new Testcase(new Input(s), answer);
        }
    }

    @Test
    void testCenterExpand() {
        String baseDir = "assets/testcases/LongestPalindromicSubstring/";
        for (int i = 1; i <= 10; i++) {
            String jsonFilePath = baseDir + i + ".json";
            try {
                Testcase tc = Testcase.fromJsonFile(jsonFilePath);

                String result = LongestPalindromicSubstring.longestPalindrome(tc.input.s);

                assertEquals(tc.output.length(), result.length(),
                        "Test case failed for #" + i + " (length mismatch), input: " + tc.input);

                assertEquals(new StringBuilder(result).reverse().toString(), result,
                        "Result is not a palindrome for input: " + tc.input);

                System.out.println("Test case #" + i + " passed: input=" + tc.input + ", output=" + result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
