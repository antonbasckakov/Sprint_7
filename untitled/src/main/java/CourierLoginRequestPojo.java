public class CourierLoginRequestPojo {
    //Поля
    private String login;
    private String password;

    //Конструкторы
    public CourierLoginRequestPojo(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierLoginRequestPojo() {
    }

    //Гетеры
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    //Сеттеры
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
