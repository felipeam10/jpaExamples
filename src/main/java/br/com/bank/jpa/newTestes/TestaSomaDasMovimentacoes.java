package br.com.bank.jpa.newTestes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaDasMovimentacoes {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		System.out.println("A soma das movimentações eh: " + somaDasMovimentacoes);

		String jpqlMed = "select avg(m.valor) from Movimentacao m";
		
		TypedQuery<Double> queryMed = em.createQuery(jpqlMed, Double.class);
		Double mediaDasMovimentacoes = queryMed.getSingleResult();
		System.out.println("A média das movimentações eh: " + mediaDasMovimentacoes);
		
	}
}
