package br.com.alura.compras.principal;

import br.com.alura.compras.modelo.Compra;
import br.com.alura.enderecos.modelos.EnderecoViaCep;
import br.com.alura.enderecos.modelos.Enderecos;
import br.com.alura.enderecos.utils.ConsultarCep;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double limite;
        int acao;
        Compra comprador = new Compra();
        String descricao;
        double valor;
        ConsultarCep consulta = new ConsultarCep();


        System.out.println("Digite o limite do cartão");
        limite = scanner.nextDouble();
        System.out.println("Seu limite do cartão é " + limite);

        System.out.println("""
                Digite 2 para adicionar um CEP

                Digite 1 para adicionar uma nova compra.
                                    
                Digite 0 para finalizar a sessão.
                """);

        acao = scanner.nextInt();

        while (acao != 0) {
            if (acao == 1) {
                System.out.println("Digite a descrição da compra: ");
                descricao = scanner.next();

                System.out.println("Digite o valor da compra: ");
                valor = scanner.nextDouble();

                boolean conseguiuComprar = comprador.addProduto(descricao, valor, limite);

                if (conseguiuComprar) {
                    System.out.println("""
                            Digite 2 para adicionar um CEP
                                                    
                            Digite 1 para adicionar uma nova compra.
                                                
                            Digite 0 para finalizar a sessão.
                            """);

                    acao = scanner.nextInt();
                } else {
                    comprador.imprimirCompras(limite);
                    acao = 0;
                }
            } else {
                System.out.println("Digite o CEP: ");
                String cep = scanner.next();
                try {
                    EnderecoViaCep apiEnd = consulta.buscaEndereco(cep);
                    Enderecos end = new Enderecos(apiEnd);

                    System.out.println(end.getLogradouro());

                    System.out.println("""
                            \n
                            Digite 2 para adicionar um CEP
                                                    
                            Digite 1 para adicionar uma nova compra.
                                                
                            Digite 0 para finalizar a sessão.
                            """);

                    acao = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println(cep + " - Entrou no catch");
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}