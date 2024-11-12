import java.util.Scanner;
class NumberGame {
    static void game(int randomNumber, int score,Scanner sc) {
        int i = 0;
        for (i = 1; i <= 5; i++) {
           System.out.print("Guess The Number "+i+":");
           int guessedNumber = sc.nextInt();
           if(guessedNumber <= 100){
            if (guessedNumber == randomNumber) {
                if (i != 5) {
                    System.out.println("Congratulations! You Won the Game!");
                }
                score = 50 - (i - 1) * 10;
                System.out.println("Your score is :" + score);
                break;
            } else if (guessedNumber >= randomNumber) {
                if (i != 5) {
                    System.out.println("Guess Lower.");
                }
            } else if (guessedNumber <= randomNumber) {
                if (i != 5) {
                    System.out.println("Guess Higher.");
                }
            } else {
                System.out.println();
            }
           }
           else{
               System.out.println("Kindly Enter Between 1-100 Only.");
               i=0;
           }
          
        }
        if(i > 5){
        System.out.println("Random number is: " + randomNumber);
        System.out.println("Your Score is:"+score);
        System.out.println("Thanks For Playing.");
        }
        
    }

    public static void main(String[] args) {
         System.out.println("Welcome To The Number Game.");
        System.out.println("You have only 5 attempts to guess the number between 1-100: ");
        System.out.println("Highest Score Will Be 50 And Lowest IS 0.");
        System.out.println("Lets Start The Game...");
        Scanner sc = new Scanner(System.in);
           String option;
        do {
             int randomNumber = (int) (Math.random() * 100) + 1;
             int score = 0;
             game(randomNumber, score,sc);
            System.out.print("Do you want to play again? (yes/no): ");
           option = sc.next();
        } while (option.equalsIgnoreCase("yes"));
        System.out.println("Thanks for playing Bye!");
        sc.close();
    }
}