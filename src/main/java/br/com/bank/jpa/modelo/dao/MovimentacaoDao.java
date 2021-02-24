package br.com.bank.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.bank.jpa.modelo.MediaComData;
import br.com.bank.jpa.modelo.Movimentacao;

public class MovimentacaoDao {
	private EntityManager em;

	public MovimentacaoDao(EntityManager em) { // delega a criação de uma dependencia para quem estiver usando essa classe MovimentacaoDao
		this.em = em;						   // injecao de dependencia
	}
	
	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (dia != null) {
			// equivale a day(m.data)
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			predicates.add(predicate);
		}
		
		if (mes != null) {
			// equivale a month(m.data)
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			predicates.add(predicate);
		}
		
		if (ano != null) {
			// equivale a year(m.data)
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			predicates.add(predicate);
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));
		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
		
	}

	public List<MediaComData> getMediaDiariaDasMovimenacoes() {
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "select sum(m.valor) from Movimentacao m";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		return somaDasMovimentacoes;

		
	}
	
	public Double getMediaDasMovimentacoes() {
		String jpqlMed = "select avg(m.valor) from Movimentacao m";
		TypedQuery<Double> queryMed = em.createQuery(jpqlMed, Double.class);
		Double mediaDasMovimentacoes = queryMed.getSingleResult();
		return mediaDasMovimentacoes;
	}
}
