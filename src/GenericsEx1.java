import java.util.Scanner;

public class GenericsEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String input = scanner.nextLine();
            Box<String> box =new Box<>(input); // This will work with all data types and collections.
            System.out.println(box);
        }

    }
}

class Box<T> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", value.getClass().getName(), value.toString());
    }
}
