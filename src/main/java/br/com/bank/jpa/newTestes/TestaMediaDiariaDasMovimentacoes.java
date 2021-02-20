package br.com.bank.jpa.newTestes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.MediaComData;
import br.com.bank.jpa.modelo.dao.MovimentacaoDao;

public class TestaMediaDiariaDasMovimentacoes {
	public static <X> void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao(em).getMediaDiariaDasMovimenacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println("A media das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + " eh: " + resultado.getValor());
		}
	}
}
