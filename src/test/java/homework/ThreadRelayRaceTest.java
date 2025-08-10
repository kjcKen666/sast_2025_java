package homework;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ThreadRelayRaceCheckTest {
    public static class Input {
        int numRunners;
        public Input(int numRunners) {
            this.numRunners = numRunners;
        }
        @Override
        public String toString() {
            return String.valueOf(numRunners);
        }
    }

    public static class Testcase {
        Input input;
        public Testcase(Input input) {
            this.input = input;
        }

        public static Testcase fromJsonFile(String filePath) throws IOException {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject testcaseJson = new JSONObject(content);

            JSONObject inputJson = testcaseJson.getJSONObject("input");
            int numRunners = inputJson.getInt("numRunners");

            return new Testcase(new Input(numRunners));
        }
    }

    @Test
    void testRaceFlowFromJson() {
        String baseDir = "assets/testcases/ThreadRelayRace/";
        for (int i = 1; i <= 10; i++) {
            String jsonFilePath = baseDir + i + ".json";
            try {
                Testcase tc = Testcase.fromJsonFile(jsonFilePath);
                int numRunners = tc.input.numRunners;

                String simulatedInput = numRunners + "\n";
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream originalOut = System.out;
                System.setOut(new PrintStream(outputStream));

                long start = System.currentTimeMillis();
                ThreadRelayRace.main(new String[]{});
                long elapsed = System.currentTimeMillis() - start;

                System.setOut(originalOut);

                String output = outputStream.toString();

                for (int r = 1; r <= numRunners; r++) {
                    assertTrue(output.contains("Runner " + r + " started running"),
                            "Runner " + r + " start message missing in test case #" + i);
                    assertTrue(output.contains("Runner " + r + " finished! Time:"),
                            "Runner " + r + " finish message missing in test case #" + i);
                }

                for (int r = 1; r < numRunners; r++) {
                    assertTrue(output.contains("Runner " + r + " passing baton to Runner " + (r + 1)),
                            "Baton pass message missing for Runner " + r + " in test case #" + i);
                }

                assertTrue(output.contains("Race finished!"), "Race finished message missing in test case #" + i);

                assertTrue(elapsed >= 500 * numRunners,
                        "Race finished too fast in test case #" + i);
                assertTrue(elapsed <= 1500 * numRunners,
                        "Race took too long in test case #" + i);

                System.out.println("Test case #" + i + " passed: numRunners=" + numRunners + ", elapsed=" + elapsed + "ms");

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                fail("Error running test case #" + i);
            }
        }
    }
}
