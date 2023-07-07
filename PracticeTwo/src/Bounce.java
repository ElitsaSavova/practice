import java.util.Scanner;

public class Bounce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int rows = Integer.parseInt(inputArray[0]);
        int cols = Integer.parseInt(inputArray[1]);

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (long) Math.pow(2, i + j);
            }
        }

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.printf("%d ", matrix[i][j]);
//            }
//            System.out.println();
//        }

        if (cols == 1 || rows == 1) {
            System.out.println(1);
            return;
        }

        int currentRow = 0;
        int currentCol = 0;
        int horizontalDirection = 1;
        int verticalDirection = 1;
        int sum = 1;

        while (true) {
            currentRow += verticalDirection;
            currentCol += horizontalDirection;

            if (currentRow == rows - 1 || currentRow == 0) {
                verticalDirection *= -1;
            }

            if (currentCol == cols - 1 || currentCol == 0) {
                horizontalDirection *= -1;
            }

            sum += matrix[currentRow][currentCol];

            if (
                    (currentRow == 0 && currentCol == 0) ||
                            (currentRow == 0 && currentCol == cols - 1) ||
                            (currentRow == rows - 1 && currentCol == 0) ||
                            (currentRow == rows - 1 && currentCol == cols - 1)
            ) {
                System.out.println(sum);
                break;
            }
        }
    }
}
