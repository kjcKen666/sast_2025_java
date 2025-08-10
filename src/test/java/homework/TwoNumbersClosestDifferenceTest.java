package homework;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumbersClosestDifferenceTest {
    public static class Input {
        int[] nums;
        int target;

        public Input(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        @Override
        public String toString() {
            return Arrays.toString(nums) + " target=" + target;
        }
    }

    public static class Testcase {
        Input input;
        int[] output;

        public Testcase(Input input, int[] output) {
            this.input = input;
            this.output = output;
        }

        public static Testcase fromJsonFile(String filePath) throws IOException {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line).append(System.lineSeparator());
            }

            JSONObject testcase_json = new JSONObject(sb.toString());
            JSONObject input_json = testcase_json.getJSONObject("input");
            JSONObject output_json = testcase_json.getJSONObject("output");

            JSONArray nums_json = input_json.getJSONArray("nums");
            int length = nums_json.length();
            int[] intArray = new int[length];
            for (int i = 0; i < length; i++) {
                intArray[i] = nums_json.getInt(i);
            }

            JSONArray out_json = output_json.getJSONArray("answer");
            int[] outArray = new int[2];
            for (int i = 0; i < 2; i++) {
                outArray[i] = out_json.getInt(i);
            }

            return new Testcase(new Input(intArray, input_json.getInt("target")), outArray);
        }
    }

    @Test
    void testTwoNumbersClosestDifference() {
        for (int i = 1; i <= 10; i++) {
            String jsonFilePath = "assets/testcases/TwoNumbersClosestDifference/" + i + ".json";
            try {
                Testcase testcase = Testcase.fromJsonFile(jsonFilePath);
                int[] nums = testcase.input.nums;
                int[] result = TwoNumbersClosestDifference.findClosestPair(nums, testcase.input.target);

                boolean firstInArray = Arrays.stream(nums).anyMatch(x -> x == result[0]);
                boolean secondInArray = Arrays.stream(nums).anyMatch(x -> x == result[1]);
                assertTrue(firstInArray && secondInArray,
                        "Output numbers must both be in the input array. Got: " + Arrays.toString(result));

                if (result[0] == result[1]) {
                    long count = Arrays.stream(nums).filter(x -> x == result[0]).count();
                    assertTrue(count >= 2,
                            "If two output numbers are equal, the input array must contain at least two of them.");
                }

                int expectedDiff = Math.abs(testcase.output[0] - testcase.output[1]);
                int actualDiff = Math.abs(result[0] - result[1]);
                assertEquals(expectedDiff, actualDiff,
                        "Test case failed for input #" + i + ": " + testcase.input
                                + " Expected diff=" + expectedDiff
                                + " Actual diff=" + actualDiff);

                System.out.println("Test case #" + i + " passed: " + Arrays.toString(result));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
