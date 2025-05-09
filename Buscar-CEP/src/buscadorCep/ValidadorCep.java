package buscadorCep;

public class ValidadorCep {
    public static boolean isValido(String cep) {
        return cep != null && cep.matches("\\d{8}"); //
    }
}
