import java.util.Scanner;
import java.util.Stack;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> keepElements = new Stack<>();
        Stack<Integer> maxElement = new Stack<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        int biggestNumber = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfCommands; i--) {

            int command = scanner.nextInt();
            if (command == 1) {
                int numToAdd = scanner.nextInt();
                keepElements.push(numToAdd);

                if (biggestNumber <= numToAdd) {
                    biggestNumber = numToAdd;
                    maxElement.push(biggestNumber);
                }
            } else if (command == 2) {
                int poppedItem = keepElements.pop();

                if (poppedItem == biggestNumber) {
                    maxElement.pop();
                    if (maxElement.size() > 0) {
                        biggestNumber = maxElement.peek();
                    } else {
                        biggestNumber = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(maxElement.pop());
            }
        }
    }

}
