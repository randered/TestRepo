import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BasicQue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> que = new ArrayDeque<>();
        Stack<Integer> smallestNums = new Stack<>();

        int smallestNum = Integer.MAX_VALUE;
        int numOfElementsToAdd = scanner.nextInt();
        int elementsToPop = scanner.nextInt();
        int elementToSearch = scanner.nextInt();

        for (int i = 0; i < numOfElementsToAdd; i++) {
            int element = scanner.nextInt();

            if (element < smallestNum) {
                smallestNums.add(element);
                smallestNum = smallestNums.peek();
            }
            que.add(element);
        }
        for (int i = 0; i < elementsToPop; i++) {
            que.poll();
        }
        if (que.contains(elementToSearch)) { System.out.println("true"); }

        else if (que.isEmpty()) { System.out.println("0"); }

        else { System.out.println(smallestNums.pop()); }
    }


}
