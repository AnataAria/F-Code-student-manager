package Class;

import java.util.ArrayList;

public class studentManager {
    private ArrayList<student> arrayList;
    public studentManager(){
        this.arrayList = new ArrayList<student>();
    }

    public studentManager(ArrayList<student> arrayList){
        this.arrayList = arrayList;
    }

    public void addNewStudent(student student){
        this.arrayList.add(student);
    }
}
