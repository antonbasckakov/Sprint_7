import java.net.http.HttpResponse;

public class CourierCreateRequestPojo {
    //Поля
    private String login;
    private String password;
    private String name;




    //Конструкторы
    public CourierCreateRequestPojo(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.name = firstName;

    }

    public CourierCreateRequestPojo(){

    }
    //Гетеры
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return name;
    }

    //Сеттеры
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.name = firstName;
    }


}
