import java.util.Scanner;

class GradeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int subjects = sc.nextInt();
        
        int total = 0;
        double average;
        char grade;
        int[] marks = new int[subjects];
        
        System.out.println("Enter marks for each subject (0-100):");
        
        for (int i = 0; i < subjects; i++) {
            while (true) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
                
                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Marks should be between 0 and 100.");
                } else {
                    break;
                }
            }
        }
        
        // Calculate total marks
        for (int mark : marks) {
            total += mark;
        }
        
        // Calculate average
        average = total / (double) subjects;
        
        // Determine grade based on average
        switch ((int) average / 10) {
            case 10:
            case 9:
            case 8:
                grade = 'A';
                break;
            case 7:
                grade = 'B';
                break;
            case 6:
            case 5:
                grade = 'C';
                break;
            case 4:
            case 3:
                grade = 'D';
                break;
            default:
                grade = 'F';
                break;
        }
        
        // Check if the student failed any subject
        boolean hasFailed = false;
        for (int mark : marks) {
            if (mark < 36) {
                hasFailed = true;
                break;
            }
        }
        
        // Print results
        if (hasFailed) {
            System.out.println("You have failed in one or more subjects.");
            System.out.println("Work harder for the next semester.");
        } else {
            System.out.println("Total Marks: " + total);
            System.out.printf("Percentage: %.2f%%%n", average);
            System.out.println("You passed with grade: " + grade);
        }
        
        sc.close();
    }
}