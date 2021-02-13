package br.com.bank.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Conta;

public class AlteraContaSaldoFelipe {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoFelipe = em.find(Conta.class, 1L);
		em.getTransaction().begin();
		contaDoFelipe.setSaldo(20000.0);
		em.getTransaction().commit();
	}
}
