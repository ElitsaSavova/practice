import java.util.Scanner;

public class Move {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int currentPosition = Integer.parseInt(input);
        input = scanner.nextLine();
        String[] strArray = input.split(",");
        int[] array = new int[strArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        int sumForward = 0;
        int sumBackwards = 0;
        input = scanner.nextLine();
        while (!input.equals("exit")) {
            String[] commandArguments = input.split(" ");
            int stepsCount = Integer.parseInt(commandArguments[0]);
            String direction = commandArguments[1];
            int stepSize = Integer.parseInt(commandArguments[2]);

            for (int i = 0; i < stepsCount; i++) {
                if (direction.equals("forward")) {
                    currentPosition = (currentPosition + stepSize) % array.length;
                    sumForward += array[currentPosition];
                } else {
                    currentPosition = (currentPosition - stepSize) % array.length;
                    if (currentPosition < 0) {
                        currentPosition = array.length - Math.abs(currentPosition);
                    }
                    sumBackwards += array[currentPosition];
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("Forward: %d%n", sumForward);
        System.out.printf("Backwards: %d", sumBackwards);
    }
}
