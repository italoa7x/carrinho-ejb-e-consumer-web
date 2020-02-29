package br.com.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote
public class CarrinhoEJB {
	private List<String> produtos = new ArrayList<String>();
	
	public void adicionarProduto(String p) {
		produtos.add(p);
	}
	
	public List<String> getProdutos() {
		return produtos;
	}
}
