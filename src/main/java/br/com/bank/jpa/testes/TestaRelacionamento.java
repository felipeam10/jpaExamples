package br.com.bank.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Conta;
import br.com.bank.jpa.modelo.Movimentacao;
import br.com.bank.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia(55555);
		conta.setNumero(7777);
		conta.setSaldo(200.9);
		conta.setTitular("Zezim");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Almoço");
		movimentacao.setValor(new BigDecimal(19.90));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		em.close();
	}
}
