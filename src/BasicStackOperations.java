import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int numOfElements = Integer.parseInt(input[0]);
        int numsToPop = Integer.parseInt(input[1]);
        int numToSearchFor = Integer.parseInt(input[2]);

        ArrayDeque<Integer> array = new ArrayDeque<>(numOfElements);
        input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            array.push(Integer.parseInt(input[i]));
        }
        while (numsToPop != 0) {
            array.pop();
            numsToPop--;
        }

        if (array.contains(numToSearchFor)) {
            System.out.println("true");
        } else if(array.isEmpty()) {
            System.out.println("0");
        }else {
            int smallest = Integer.MAX_VALUE;
            while (!array.isEmpty()) {
                if (array.peek() < smallest) {
                    smallest = array.pop();
                } else {
                    array.pop();
                }
            }
            System.out.println(smallest);

        }
    }
}
//    static int findSmallest(ArrayDeque<Integer> stack) {
//        int smallest = Integer.MAX_VALUE;
//        while (!stack.isEmpty()) {
//            if(stack.peek() < smallest){
//                smallest = stack.pop();
//            }else{
//                stack.pop();
//            }
//        }
//        return smallest;
//    }

