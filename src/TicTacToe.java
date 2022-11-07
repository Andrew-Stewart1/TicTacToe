import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    String player = "X";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        clearBoard();
        display();
        int moves = 0;
        boolean finised = false;
        boolean playing = true;
        String player = "X";
        int playerRowMove = 4;
        int playerColMove = 4;

while(!finised) {
    do {
        playerRowMove = safeInputs.getRangedInt(input, "Enter your row: ", 1, 3);
        playerColMove = safeInputs.getRangedInt(input, "Enter your colum: ", 1, 3);
        playerRowMove--;
        playerColMove--;
        while (!isValidMove(playerRowMove, playerColMove)) {
            playerRowMove = safeInputs.getRangedInt(input, "Not available Enter your new row: ", 1, 3);
            playerColMove = safeInputs.getRangedInt(input, "Not available enter your new colum: ", 1, 3);
            playerRowMove--;
            playerColMove--;
        }
        board[playerRowMove][playerColMove] = player;
        moves++;
        display();
        if (isWin(player)) {
            System.out.println(player + " won the game!");
            playing = false;
        } else if (isTie(player) && moves == 9) {
            System.out.println("The game is a tie");
            playing = false;
        }
        if (player.equals("X")) {
            player = "O";
        } else {
            player = "X";
        }

    } while (playing);
    finised = safeInputs.getYNConfirm(input, "Would you like to finish the game: ");
    if (!finised){
        clearBoard();
        playing = true;
        moves = 0;
    }
}
    }

        private static void display () {
            for (int row = 0; row < ROW; row++) {
                System.out.println("");
                System.out.print("| ");
                for (int col = 0; col < COL; col++) {
                    System.out.print(board[row][col] + " | ");
                }
            }
        }

        private static boolean isValidMove ( int row, int col) {
            if (board[row][col].equals(" ")){
                return true;
            }
            return false;
        }

        private static void clearBoard () {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    board[row][col] = " ";
                }
            }
        }
                private static boolean isWin(String player){
                    if (isColWin(player) || isRowWin(player) || isDiagonaWin(player)) {
                        return true;
                    }
                    return false;
                }
                private static boolean isRowWin (String player){
                    for (int row = 0; row < ROW; row++) {
                        if (board[row][0].equals(player) &&
                                board[row][1].equals(player) &&
                                board[row][2].equals(player)) {
                            return true;
                        }
                    }
                    return false;
                }
                private static boolean isColWin (String player) {
                    for (int col = 0; col < COL; col++) {
                        if (board[0][col].equals(player) &&
                                board[1][col].equals(player) &&
                                board[2][col].equals(player)) {
                            return true;
                        }
                    }
                    return false;
                }
                        private static boolean isDiagonaWin(String player){
                            if (board[0][0].equals(player) &&
                                    board[1][1].equals(player) &&
                                    board[2][2].equals(player) ||
                                    board[1][1].equals(player) &&
                                    board[0][2].equals(player) &&
                                    board[2][0].equals(player)){
                                return true;
                            }

                            return false;
                         }
                        private static boolean isTie(String player){
                            if (!isColWin(player) && !isRowWin(player) && !isDiagonaWin(player)) {
                                return true;
                            }
                            return false;
                        }

                    }
