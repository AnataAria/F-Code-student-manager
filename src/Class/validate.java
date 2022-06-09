package Class;
public class validate {
    public validate(){

    }
    public boolean validateLoginInput(String userPass,int type){
        boolean flag = true;
        int fault = 0;
        if(type == 1) {
            for (int i = 0; i < userPass.length(); i++) {
                if (userPass.charAt(i) == ' ' || userPass.charAt(i) == '_') {
                    fault = 1;
                    break;
                }
            }
        }
        else if(type == 2){
            if (userPass.length() < 8){
                return false;
            }
            else{
                int temp = 0;
                int uppercase = 0;
                for(int i = 0; i < userPass.length();i++){
                    if(Character.isUpperCase(userPass.charAt(i))){
                        uppercase ++;
                        break;
                    }
                }
                for(int i = 0; i <userPass.length();i++){
                    if(userPass.charAt(i) == ' ' || userPass.charAt(i) == '_'){
                        temp ++;
                        break;
                    }
                }
                if (uppercase == 0 || temp != 0){
                    return false;
                }
            }
        }
        if (fault == 1) flag = false;
        return flag;
    }
    public String validateInput(){
        String input ="";

        return input;
    }
}
