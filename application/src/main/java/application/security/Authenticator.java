package application.security;

public class Authenticator {
    private String login;
    private char[] password;

    public Authenticator(String login, char[] password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }
}
