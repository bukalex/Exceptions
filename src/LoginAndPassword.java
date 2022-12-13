public class LoginAndPassword {
    public static boolean Auth(String login, String password, String confirmPassword){
        return checkLogin(login) && checkPassword(password, confirmPassword);
    }

    public static boolean checkLogin(String login){
        boolean flag = true;
        flag = 1 <= login.length() && login.length() <= 20;
        for (int i = 0; i < login.length(); i++){
            flag = flag && (Character.isLetterOrDigit(login.charAt(i)) || login.charAt(i) == '_');
        }
        if(!flag){
            throw new WrongLoginException("Неверный логин");
        }
        return flag;
    }

    public static boolean checkPassword(String password, String confirmPassword){
        boolean flag = true;
        flag = 1 <= password.length() && password.length() <= 20;
        for (int i = 0; i < password.length(); i++){
            flag = flag && (Character.isLetterOrDigit(password.charAt(i)) || password.charAt(i) == '_');
        }
        flag = password.equals(confirmPassword);
        if(!flag){
            throw new WrongPasswordException("Неверный пароль");
        }
        return flag;
    }
}
