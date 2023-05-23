import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {

    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9]+$";
    public static void main(String[] args) {
        check("login","password", "confirmPassword");
    }

    private static boolean check(String login, String password, String confirmPassword){
        boolean isValid = true;

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e){
            e.printStackTrace();
            System.out.println("Ошибка при вводе логина: " + e.getMessage());
            isValid = false;
        } catch (WrongPasswordException e){
            e.printStackTrace();
            System.out.println("Ошибка при вводе пароля: " + e.getMessage());
            isValid = false;
        }

        return isValid;
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if(!login.matches(VALIDATE_PATTERN)){
            throw new WrongLoginException("Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        } else if (login.length() > 20){
            throw new WrongLoginException("Логин не должен превышать 20 символов");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if(!password.matches(VALIDATE_PATTERN)){
            throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
        } else if (password.length() > 20){
            throw new WrongPasswordException("Пароль не должен превышать 20 символов");
        }else if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}