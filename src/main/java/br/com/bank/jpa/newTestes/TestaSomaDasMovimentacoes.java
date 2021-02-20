package br.com.bank.jpa.newTestes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaDasMovimentacoes {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		System.out.println("A soma das movimenta��es eh: " + dao.getSomaDasMovimentacoes());

		System.out.println("A m�dia das movimenta��es eh: " + dao.getMediaDasMovimentacoes());
		
	}
}
