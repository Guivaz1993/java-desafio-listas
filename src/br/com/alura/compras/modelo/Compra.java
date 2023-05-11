package br.com.alura.compras.modelo;

import java.util.ArrayList;
import java.util.Comparator;

public class Compra {
    private ArrayList<Produto> compras = new ArrayList<>();
    private double total=0;

    public boolean addProduto(String descricao, double valor, double limite) {
        if (limite < (valor + total)) {
            System.out.println("Saldo insuficiente!");
            return false;
        }

        Produto novoProduto = new Produto(descricao, valor);
        compras.add(novoProduto);
        total += valor;

        this.imprimirCompras(limite);

        return true;
    }

    public void imprimirCompras(double limite) {
        compras.sort(Comparator.comparing(Produto::getDescricao));
        System.out.println("COMPRAS REALIZADAS");
        for (Produto iten : compras) {
            System.out.println(iten.getDescricao() + " - " + iten.getValor() + "\r\n");
        }
        System.out.println("Saldo do cartão: R$ " + (limite - total));
    }
}
