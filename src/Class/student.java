package Class;

import java.util.ArrayList;

public class student {
    private String No;
    private String studentName;
    private String ID;
    private String yearBorn;
    private String major;
    private String phoneNumber;
    private String updateTime;

    private ArrayList<String> averageScore;

    public student (String No, String studentName, String ID, String yearBorn, String major, String phoneNumber, ArrayList<String>averageScore, String updateTime){
        this.No= No;
        this.studentName = studentName;
        this.ID = ID;
        this.yearBorn = yearBorn;
        this.major = major;
        this.averageScore = averageScore;
        this.updateTime = updateTime;
    }
    public void setNo(String No){
        this.No = No;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public void setYearBorn(String yearBorn){
        this.yearBorn = yearBorn;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setAverageScore(ArrayList<String> averageScore){
        this.averageScore.addAll(averageScore);
    }
    public void setUpdateTime(String updateTime){

    }

}
