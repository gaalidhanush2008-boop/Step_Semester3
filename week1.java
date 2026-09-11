import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to determine the winner
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int rounds = 5;

        // Arrays to store round details
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Play the game
        for (int i = 0; i < rounds; i++) {

            System.out.println("\nRound " + (i + 1));

            // Get player move
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String playerMove = scanner.nextLine();

            // Convert input into proper format
            playerMove = playerMove.substring(0, 1).toUpperCase()
                       + playerMove.substring(1).toLowerCase();

            // Generate random computer move
            String computerMove = moves[random.nextInt(3)];

            // Determine result
            String result = playRound(playerMove, computerMove);

            // Store details
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            // Update score
            if (result.equals("Player Wins")) {
                wins++;
            } 
            else if (result.equals("Computer Wins")) {
                losses++;
            } 
            else {
                draws++;
            }

            // Display round result
            System.out.println("Player Move: " + playerMove);
            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);
        }

        // Calculate win percentage
        double winPercentage = (wins * 100.0) / rounds;

        // Print final summary table
        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf("%-10s %-15s %-18s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-10d %-15s %-18s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("------------------------------------------------------------");

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}