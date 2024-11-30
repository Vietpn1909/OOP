package hust.soict.dsai.garbage;
import java.util.Random;

public class NoGarbage {
    public static void main(String[] args) {
        // Generate a large array of random bytes
        int size = 10_000_000; // Adjust size to simulate a large file
        byte[] inputBytes = new byte[size];
        Random random = new Random();
        random.nextBytes(inputBytes);

        long startTime = System.currentTimeMillis();

        // Using StringBuilder to efficiently build the string
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }

        String outputString = outputStringBuilder.toString();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) + " ms");
    }
}
