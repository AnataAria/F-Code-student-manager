package Class;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class menu extends Vector<String> {
    String[] typeOfHeader;
    public menu(String[] typeOfHeader,String[] addMenuItem){
        loadTypeofHeader(typeOfHeader);
        addMenuItem(addMenuItem);
    }
    public menu(){

    }

    public String[] loginTermial(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String[] temp = new String[2];
        temp[0] = scanner.nextLine();
        System.out.print("Enter password: ");
        temp[1] = scanner.nextLine();
        return temp;
    }

    void addMenuItem(String[] menuItem){
        for(int i = 0; i < menuItem.length; i++) {
            this.add(menuItem[i]);
        }
    }
    void loadTypeofHeader(String[] typeOfHeader){
        this.typeOfHeader = typeOfHeader;
    }
    public void headerMenu(int type){
        System.out.println("Welcome to F-Code student manager");
        System.out.println("-----------"+ typeOfHeader[type] + "-------------");
    }
    public int getUserChoice(){
        Scanner temp = new Scanner(System.in);
        int num;
        do{
            for (int i = 0; i < this.size(); i++){
                System.out.println(i+1 +". "+this.get(i));
            }
            System.out.print("Enter your choice: ");
            num = Integer.parseInt(temp.nextLine());
            if(num <= 0 || num >= this.size());
        }while(num <= 0 || num > this.size());
        return num;
    }
    public ArrayList<String> addNewStudent() throws IOException {
        ArrayList<String> addNew = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter studentName: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student year born: ");
        String yearBorn = scanner.nextLine();
        System.out.println("Enter student major: ");
        String major = scanner.nextLine();
        Year year = Year.now();
        fileHandle fh = new fileHandle();
        String yearNow = String.valueOf(year);
        String No = String.valueOf(fh.generateReseachNo(2));
        String ID = major + (Integer.parseInt(yearNow) + 4) + No;


        return addNew;
    }
    public ArrayList<String> addNewSubject(){
        ArrayList<String> newSubject = new ArrayList<String>();
        int i = 0;
        while(true){
            System.out.println("Enter new subject ");
            Scanner sc = new Scanner(System.in);
            String enter = sc.nextLine();
            System.out.println("Enter description: ");
            String enter1 = sc.nextLine();
            newSubject.add(enter + ',' + enter1);
            System.out.println("Do you want to add more subject(Y/N): ");
            char confirm = sc.next().charAt(0);
            if(confirm == 'y' || confirm == 'Y'){
                System.out.println("Lets enter others");
                i++;
            }
            else{
                break;
            }
        }
        return newSubject;
    }
}
