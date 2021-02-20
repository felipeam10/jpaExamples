package br.com.bank.jpa.newTestes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.bank.jpa.modelo.MediaComData;

public class TestaMediaDiariaDasMovimentacoes {
	public static <X> void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select new br.com.bank.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		List<MediaComData> mediaDasMovimentacoes = query.getResultList();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println("A media das movimenta��es do dia " + resultado.getDia() + "/" + resultado.getMes() + " eh: " + resultado.getValor());
		}
	}
}
