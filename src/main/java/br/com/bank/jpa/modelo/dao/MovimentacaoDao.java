package br.com.bank.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.bank.jpa.modelo.MediaComData;

public class MovimentacaoDao {
	private EntityManager em;

	public MovimentacaoDao(EntityManager em) { // delega a criação de uma dependencia para quem estiver usando essa classe MovimentacaoDao
		this.em = em;						   // injecao de dependencia
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
