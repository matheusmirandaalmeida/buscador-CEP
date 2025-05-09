package buscadorCep;

import java.io.IOException;
import java.util.Scanner;

public class CepClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CEP: ");
        String cep = sc.nextLine();

        if(!ValidadorCep.isValido(cep)){
            System.out.println("CEP invalido.");
            return;
        }

        CepService service = new CepService(); //instanciar
        Cep resposta = service.buscarCep(cep);

        if(resposta != null){
            System.out.println("Logradouro" + resposta.logradouro());
            System.out.println("Logradouro: " + resposta.logradouro());
            System.out.println("Complemento: " + resposta.complemento());
            System.out.println("Bairro: " + resposta.bairro());
            System.out.println("Cidade: " + resposta.localidade());
            System.out.println("UF: " + resposta.uf());
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.gerarJson(resposta);
        } else {
            System.out.println("Não é possivel encontrar o CEP.");
        }

    }
}
