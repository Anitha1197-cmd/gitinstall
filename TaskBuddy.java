import java.util.Scanner;

public class TaskBuddy {
    public static void displayTask(String[] taskNames,int[] estimatedMinutes,int count){
        for(int i=0;i<count;i++) {
            System.out.println("Task: " + taskNames[i]);
            int hours = estimatedMinutes[i] / 60;
            int minutes = estimatedMinutes[i] % 60;
            System.out.println("Time Required: " + hours + " hours and " + minutes + " minutes");
        }
    }
    public static String[] categorizeTask(int estimatedMinutes[],int count) {
        String[] taskType=new String[estimatedMinutes.length];
        for (int i=0;i<count;i++) {
            if (estimatedMinutes[i] <= 30) {
                taskType[i] = "Quick Task";
            } else if (estimatedMinutes[i] <= 120) {
                taskType[i] = "Single Session Task";
            } else if (estimatedMinutes[i] <= 300) {
                taskType[i] = "Half Day Task";
            } else {
                taskType[i] = "Full Day Task";
            }
        }
        return taskType;}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TaskBuddy Application ===");
        System.out.println("Enter the total number of task");
        int size=scanner.nextInt();
        scanner.nextLine();
        String[] taskNames = new String[size];
        int[] estimatedMinutes = new int[size];
        String[] taskCategory=new String[size];
        int count=0;
        int choice;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1.Add Task");
            System.out.println("2.Display Task Details");
            System.out.println("3.Categorize Task Type");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice= scanner.nextInt();
            switch (choice) {
                case 1:
                    if (count < size) {
                        System.out.print("Enter task name: ");
                        taskNames[count] = scanner.next();
                        System.out.print("Enter estimated minutes for the task: ");
                        estimatedMinutes[count] = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        count++;
                    } else {
                        System.out.println("Task limit reached! Cannot add more.");
                    }
                    break;

                case 2:
                    if(count>0) {
                        displayTask(taskNames, estimatedMinutes, count);
                    }else{
                        System.out.println("No tasks recorded yet.");
                    }
                    break;
                case 3:
                    if (count > 0) {
                        taskCategory = categorizeTask(estimatedMinutes, count);
                        for (int i = 0; i < count; i++) {
                            System.out.println("Task Name: " + taskNames[i]);
                            System.out.println("Task Category: " + taskCategory[i]);
                        }    } else { System.out.println("No tasks recorded yet to categorize.");}
                    break;

                case 4:
                    System.out.println("Exiting App!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }while (choice!=4);
    }
}
