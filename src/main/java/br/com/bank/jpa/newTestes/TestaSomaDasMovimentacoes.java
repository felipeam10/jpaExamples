package br.com.bank.jpa.newTestes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.bank.jpa.modelo.Movimentacao;
import br.com.bank.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
//		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		// equivale ao select sum(m.valor)
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		System.out.println("A soma das movimentações eh: " + typedQuery.getSingleResult());
		
		// eaquivale ao avg(m.valor)
		Expression<Double> avg = builder.avg(root.<Double>get("valor"));
		query.multiselect(avg);
		TypedQuery<BigDecimal> typedQueryAvg = em.createQuery(query);
		System.out.println("A média das movimentações eh: " + typedQueryAvg.getSingleResult());
		
		
//		System.out.println("A soma das movimentações eh: " + dao.getSomaDasMovimentacoes());

//		System.out.println("A média das movimentações eh: " + dao.getMediaDasMovimentacoes());
		
	}
}
