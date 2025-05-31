package loteca;

public class Usuario {
    private final String loginCorreto = "admin";
    private final String senhaCorreta = "1234";

    public boolean autenticar(String login, String senha) {
        return login.equals(loginCorreto) && senha.equals(senhaCorreta);
    }
}