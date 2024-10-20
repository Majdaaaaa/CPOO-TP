import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            Scanner2Iterable.afficheIterable(new Scanner2Iterable(new AdapterScanner(scanner), 3));
        }
    }
}