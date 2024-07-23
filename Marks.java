import java.util.Scanner;
public class Marks{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        int n = in.nextInt();
        Double[][] marks = new Double[n][3];
        for (int i = 0;i<n;++i){
            for (int j = 0;j<3;++j){
                marks[i][j] = 0.0;
            }
        }
        System.out.println("Welcome to marks system");
        while(true){
            System.out.println("1. Add student marks: add [studentID]- student ID will be an integer ranging from 1 to n");
	    System.out.println("2. Update student mark : update [studentID] [subjectID] [mark] - subject ID will be an integer from 1 to 3");
            System.out.println("3. Get the average for a subject: average_s [studentID]");
            System.out.println("4. Get the average for a student: average [studentID]");
            System.out.println("5. Get the total mark of a student : total [studentID]");
	    System.out.println("6. Get the Grade: Grade");
	    System.out.println("7. to Exit: exit");
            String s = in.nextLine();
	    String[] vv = s.split(" ");
            if (vv[0] == "add"){
                int id = Integer.parseInt(vv[1]);
                if (id < 1 || id > n){
                    System.out.println("Incorrect Id");
                    continue;
                }
                id--;
                for (int i = 0;i<3;++i){
                    Double mark = Double.parseDouble(vv[i + 2]);
                    marks[id][i] = mark;
		    System.out.println("Student" + " " + id + " marks for subject" + " " + (i + 1) + " " + "is added as" + " " + mark);
                }
            }
            else if (vv[0] == "update"){
                int id = Integer.parseInt(vv[1]);
                if (id < 1 || id > n){
                    System.out.println("Incorrect Id");
                    continue;
                }   
                int sid = Integer.parseInt(vv[2]);
                if (sid < 1 || sid > 3){
                    System.out.println("Incorrect subject Id");
                    continue;
                }  
                double mark = Double.parseDouble(vv[3]);
                marks[id][sid] = mark;

	        System.out.println("Student" + " " + id + " marks for subject" + " " + sid  + " " + "is updated to" + " " + mark);
            }
            else if (vv[0] == "average"){
                int id = Integer.parseInt(vv[1]);
                if (id < 1 || id > n){
                    System.out.println("Incorrect Id");
                    continue;
                }
                Double sum = 0.0;
                for (int i = 0;i<3;++i){
                    sum+=marks[id][i];
                }       
                System.out.println("Average Marks of Student" + " " + id + " " + "is" + " " + sum / 3);
            }
            else if (vv[0] == "average_s"){
                int sid = Integer.parseInt(vv[1]);
                if (sid < 1 || sid > 3){
                    System.out.println("Incorrect subject Id");
                    continue;
                } 
                Double sum = 0.0;
                for (int i = 0;i<n;++i){
                    sum+=marks[i][sid];
                }    
                System.out.println("Average Subject Mark is" + " " + sum / n);
            }
            else if (vv[0] == "total"){
                int id = Integer.parseInt(vv[1]);
                if (id < 1 || id > n){
                    System.out.println("Incorrect Id");
                    continue;
                }
                Double sum = 0.0;
                for (int i = 0;i<3;++i){
                    sum+=marks[id][i];
                }       
                System.out.println("Total Marks of student" + id + " is" + " " + sum);
            }
	    else if (vv[0] == "Grade"){
		System.out.println("ID" + "          " + "Mathematics" + "   " + "Chemistry" + "    " + "Physics");
		for (int i = 0;i<n;++i){
			System.out.println((i + 1));	
		}
 	    }
            else if (vv[0] == "exit")break;
	    else {
		System.out.println("Incorrect command, please try again");
	    }
        }
        System.out.println("Thank you for using this system");
    }
}
