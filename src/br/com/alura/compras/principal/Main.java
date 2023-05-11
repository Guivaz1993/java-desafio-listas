package br.com.alura.compras.principal;

import br.com.alura.compras.modelo.Compra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double limite;
        int acao = 1;
        Compra comprador = new Compra();
        String descricao;
        double valor;

        System.out.println("Digite o limite do cartão");
        limite = scanner.nextDouble();
        System.out.println("Seu limite do cartão é " + limite);

        System.out.println("""
                Digite 1 para adicionar uma nova compra.
                                    
                Digite 0 para finalizar a sessão.
                """);

        acao = scanner.nextInt();

        while (acao == 1) {
            System.out.println("Digite a descrição da compra: ");
            descricao = scanner.next();

            System.out.println("Digite o valor da compra: ");
            valor = scanner.nextDouble();

            boolean conseguiuComprar;
           conseguiuComprar = comprador.addProduto(descricao, valor, limite);

            if (conseguiuComprar) {
                System.out.println("""
                        Digite 1 para adicionar uma nova compra.
                                            
                        Digite 0 para finalizar a sessão.
                        """);

                acao = scanner.nextInt();
            } else {
                comprador.imprimirCompras(limite);
                acao = 0;
            }
        }
    }
}