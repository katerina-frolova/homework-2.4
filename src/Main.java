public class Main {
    public static void main(String[] args) {
        String login = "skypro14_QQQ_7";
        String password = "rfdhdfhdf35hfhfg45";
        String confirmPassword = "rfdhdfhdf35hfhfg45";
        if (check(login, password, confirmPassword)){
            System.out.println("Вы успешно зарегистрированы в системе");
        }
    }

    public static boolean check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!checkValidity(login)){
            System.out.println("Используйте допустимые символы для ввода логина");
            return false;
        }
        try {
            if (login.length() > 20){
                throw new WrongLoginException();
            }
        } catch (WrongLoginException e){
            System.out.println("Слишком длинный логин");
            return false;
        }

        if (!checkValidity(password) || password.length()>=20) {
            System.out.println("Некорректный пароль");
            return false;
        }
        try {
            if (!password.equals(confirmPassword)){
                throw new WrongPasswordException();
            }
        } catch (WrongPasswordException e){
            System.out.println("Пароли не совпадают");
            return false;
        }
        return true;

    }

    public static boolean checkValidity(String str){
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch == '_' || ch>='0' && ch<='9' || ch>='a' && ch<='z' || ch>='A' && ch<='Z')){
                return false;
            }
        }
        return true;
    }
}