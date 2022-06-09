import Class.menu;
import Class.validate;
import Class.fileHandle;
import Class.studentManager;
import Class.student;

import java.io.IOException;
import java.util.ArrayList;

enum typeheader{
    LOGIN,
    MENU,
    STUDENT,
    STUDENTREPORT,
    SUBJECTREPORT,
}
public class Main {
    public static void main(String[] args) throws IOException {
        String[] typeOfHeader = {"Login terminal", "Menu terminal", "Student terminal", "Student report terminal", "Grade report terminal" };
        String[] menuItem = {"Add new student","Add new subject","Update student","Update subject","Enter grade","Student grade report", "Subject grade report"};
        String studentPack = "";
        String adminDataPack = "E:\\JavaOOPTraining\\PEprojectF-CodeLV1V2\\src\\database\\admindata.csv";
        menu menu = new menu(typeOfHeader,menuItem);
        fileHandle fileHandle = new fileHandle(adminDataPack,studentPack);
        validate validate = new validate();
        String[] loginInput;
        menu.headerMenu(0);
        do {
            loginInput = menu.loginTermial();
        }while(!validate.validateLoginInput(loginInput[0],1) || !validate.validateLoginInput(loginInput[1],2 ) );
        try {
            while(true) {
                if (fileHandle.checkAdminUserPass(loginInput[0], loginInput[1])) {
                    System.out.println("Login success. Welcome user: " + loginInput[0]);
                    menu.headerMenu(1);
                    break;
                }
                else {
                    System.out.println("User name or your password is incorrected, please enter again!!!");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        int choice = menu.getUserChoice();
        switch (choice){
            case 1:
                menu.headerMenu(2);
                studentManager studentManager = new studentManager();
                ArrayList<String> dataNewInput = menu.addNewStudent();


                break;
            case 2:

                break;
            case 3:

                break;
        }
    }
}