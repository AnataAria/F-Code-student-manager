package Class;

import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class fileHandle {
    private String userName;
    private String userPassWord;
    private String adminUserPassPack;
    private String studentPack;
    private String idHistoryPack;

    public fileHandle(String adminUserPassPack,String studentPack){
        this.adminUserPassPack = adminUserPassPack;
        this.studentPack = studentPack;
    }

    public fileHandle(){

    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setUserPassWord(String passWord){
        this.userPassWord = passWord;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getUserPassWord(){
        return this.userPassWord;
    }
    public boolean checkAdminUserPass(String userName, String userPassWord) throws IOException {
        FileReader filereader = new FileReader(adminUserPassPack);
        BufferedReader filepointer = new BufferedReader(filereader);
        String line = "";
        String[] temp;
        String quotation = ",";
        boolean flag = false;
        try{
            while((line = filepointer.readLine()) != null){
                temp = line.split(quotation);
                if(userName.equals(temp[0]) && userPassWord.equals(temp[1])){
                    flag = true;
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }
    public ArrayList<String> getHeader() throws FileNotFoundException {
        ArrayList<String> header = new ArrayList<String>();
        FileReader reader = new FileReader(studentPack);
        BufferedReader filepointer = new BufferedReader(reader);
        String quotation = ",";
        String[] temp;
        String line = "";
        try {
            line = filepointer.readLine();
            temp = line.split(quotation);
            Collections.addAll(header, temp);
            filepointer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return header;
    }
    public ArrayList<student> uploadStudentData() throws FileNotFoundException {
        ArrayList<student> uploadData = new ArrayList<student>();
        FileReader fr = new FileReader(studentPack);
        String line = "";
        String[] temp;
        String quotation = ",";
        BufferedReader filepointer = new BufferedReader(fr);
        try{
            line = filepointer.readLine();
            while((line = filepointer.readLine()) != null){
                temp = line.split(quotation);
                String[] temp1 = new String[7];
                for(int i = 0; i < 7; i++){
                    temp1[i] = temp[i];
                }
                ArrayList<String> score = new ArrayList<String>();
                int j = 0;
                for(int i = 7; i < temp.length;i++){
                    score.add(j,temp[i]);
                    j++;
                }
                for(int i = 0; i < 7; i++){
                    uploadData.addAll(Arrays.asList(temp1));
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return uploadData;
    }
    public int generateReseachNo(int mode) throws IOException {
        int ID = 0;
        switch (mode) {//mode 1 is for asking ID and mode 2 is for creating ID
            case 1:
                File fp = new File(idHistoryPack);
                if (fp.length() == 0) {
                    try {
                        FileReader reader = new FileReader(idHistoryPack);
                        ID = reader.read();
                        reader.close();
                        FileWriter writer = new FileWriter(idHistoryPack);
                        writer.write(ID);
                        writer.close();
                        return ID;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    FileReader reader = new FileReader(idHistoryPack);
                    ID = reader.read();
                    reader.close();
                    return ID;
                }
                break;
            case 2:
                File fp1 = new File(idHistoryPack);
                if (fp1.length() == 0) {
                    try {
                        ID = 0;
                        FileWriter writer = new FileWriter(idHistoryPack);
                        writer.write(ID);
                        writer.close();
                        return ID;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return ID;
                } else {
                    FileReader reader = new FileReader(idHistoryPack);
                    ID = reader.read();
                    reader.close();
                    ID++;
                    FileWriter writer = new FileWriter(idHistoryPack);
                    writer.write(ID);
                    writer.close();
                    return ID;
                }
        }
        return ID;
    }
}
