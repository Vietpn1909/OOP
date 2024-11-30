package hust.soict.dsai.garbage;
import java.util.Random;

public class GarbageCreator {
    public static void main(String[] args) {
        // tạo mảng có kích thước lớn
        int size = 10_000_000; 
        byte[] inputBytes = new byte[size];
        Random random = new Random();
        random.nextBytes(inputBytes);

        long startTime = System.currentTimeMillis();

        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // Inefficient concatenation
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken using + operator: " + (endTime - startTime) + " ms");
    }
}