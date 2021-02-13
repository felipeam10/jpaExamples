package br.com.bank.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Felipe");
		conta.setNumero(12345);
		conta.setAgencia(4563);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}
}
