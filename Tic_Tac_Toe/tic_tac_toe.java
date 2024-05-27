package Tic_Tac_Toe;

import java.util.Scanner;

class Tic_Tac_Toe {
    // Method to print the elements of array
    public void print(String arr[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to update the array
    public void update(String arr[][], String x) {
        int chosenPosition = Integer.parseInt(x); // which position has chosen currently
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count++;
                if (count == chosenPosition) {
                    if (arr[i][j].equals("X") || arr[i][j].equals("O")) {
                        System.out.println("!!Invalid Choice!!\nPlace is already chosen\nKindly choose another position");
                    } else {
                        arr[i][j] = "X";
                    }
                    return; // once the position is found and updated exit this to reduce unnecessary iterations
                }
            }
        }
    }

    // Method to check Winner in Row
    public static String RowCheck(String arr[][]) {
        String r1 = arr[0][0] + arr[0][1] + arr[0][2];
        String r2 = arr[1][0] + arr[1][1] + arr[1][2];
        String r3 = arr[2][0] + arr[2][1] + arr[2][2];
        if (r1.equals("XXX") || r1.equals("OOO")) {
            return "r1";
        } else if (r2.equals("XXX") || r2.equals("OOO")) {
            return "r2";
        } else if (r3.equals("XXX") || r3.equals("OOO")) {
            return "r3";
        } else
            return "0";
    }

    // Method to check Winner in Column
    public static String ColumnCheck(String arr[][]) {
        String c1 = arr[0][0] + arr[1][0] + arr[2][0];
        String c2 = arr[0][1] + arr[1][1] + arr[2][1];
        String c3 = arr[0][2] + arr[1][2] + arr[2][2];
        if (c1.equals("XXX") || c1.equals("OOO")) {
            return "c1";
        } else if (c2.equals("XXX") || c2.equals("OOO")) {
            return "c2";
        } else if (c3.equals("XXX") || c3.equals("OOO")) {
            return "c3";
        } else
            return "0";
    }

    // Method to check Winner in Diagonal
    public static String DiagonalCheck(String arr[][]) {
        String d = arr[0][0] + arr[1][1] + arr[2][2];
        if (d.equals("XXX") || d.equals("OOO")) {
            return "d";
        } else
            return "0";
    }

    // Method to check Winner in reverse Diagonal
    public static String Reverse_DiagonalCheck(String arr[][]) {
        String rd = arr[0][2] + arr[1][1] + arr[2][0];
        if (rd.equals("XXX") || rd.equals("OOO")) {
            return "rd";
        } else
            return "0";
    }

    // Method to declare Winner
    public static void Winner(String arr[][], String w) {
        System.out.println("!! Congratulations !!");
        if (w.equals("r1")) {
            if (arr[0][0].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("r2")) {
            if (arr[1][0].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("r3")) {
            if (arr[2][0].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("c1")) {
            if (arr[0][0].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("c2")) {
            if (arr[0][1].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("c3")) {
            if (arr[0][2].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("d")) {
            if (arr[0][0].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        } else if (w.equals("rd")) {
            if (arr[0][2].equals("X")) {
                System.out.println("Player 'X' is winner");
            } else {
                System.out.println("Player 'O' is winner");
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.exit(0);
    }

    // Method to check any person have won or not
    public void check(String arr[][], int count) {
        if (count >= 5) {
            String r = RowCheck(arr);
            String c = ColumnCheck(arr);
            String d = DiagonalCheck(arr);
            String rd = Reverse_DiagonalCheck(arr);
            if (r.equals("r1") || r.equals("r2") || r.equals("r3")) {
                Winner(arr, r);
            } else if (c.equals("c1") || c.equals("c2") || c.equals("c3")) {
                Winner(arr, c);
            } else if (d.equals("d")) {
                Winner(arr, d);
            } else if (rd.equals("rd")) {
                Winner(arr, rd);
            } else if (count == 9) {
                System.out.println("Match tied between player 'X' and player 'O'");
            }
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tic_Tac_Toe t = new Tic_Tac_Toe();
        String arr[][] = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        int count = 0;
        t.print(arr);
        while (true) {
            // Player 'X' turn
            boolean validMove = false;
            while (!validMove) {
                System.out.print("Player 'X' choose your position: ");
                String x = sc.next();
                if (isPositionValid(arr, x)) {
                    t.update(arr, x);
                    validMove = true;
                } else {
                    System.out.println("!!Invalid Choice!!\nPlace is already taken\nKindly choose another position");
                }
            }
            t.print(arr);
            count++;
            t.check(arr, count);

            // to end the game when all positions are filled and winner not decided
            if (count == 9) break;

            // Player 'O' turn
            validMove = false;
            while (!validMove) {
                System.out.print("Player 'O' choose your position: ");
                String o = sc.next();
                if (isPositionValid(arr, o)) {
                    updateForO(arr, o);
                    validMove = true;
                } else {
                    System.out.println("!!Invalid Choice!!\nPlace is already chosen\nKindly choose another position");
                }
            }
            t.print(arr);
            count++;
            t.check(arr, count);

            // to end the game when all positions are filled and winner not decided
            if (count == 9) break;
        }
    }

    // Method to check the position chosen is valid or not means position must between (1-9)
    public static boolean isPositionValid(String[][] arr, String pos) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].equals(pos)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to update array for Player 'O'
    public static void updateForO(String[][] arr, String pos) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].equals(pos)) {
                    arr[i][j] = "O";
                    return;
                }
            }
        }
    }
}
