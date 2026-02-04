interface SecurityUtils{

    static boolean isPasswordStrong(String password){
        if(password.length()<8){
            return false;


        }

        boolean hasUpperCase = false;
       // boolean hasLowerCase = false;
        boolean hasDigit = false;

        for(char ch: password.toCharArray()){
            if(Character.isUpperCase(ch)){
                hasUpperCase = true;
            }
            if(Character.isDigit(ch)){
                hasDigit = true;
            }
        }
        return hasUpperCase && hasDigit;
    

    }
}