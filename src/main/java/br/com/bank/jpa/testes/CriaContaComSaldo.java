package br.com.bank.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Marcinha");
		conta.setNumero(88888);
		conta.setAgencia(7777);
		conta.setSaldo(100.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close(); // fechamos de proposito o estado entity manager
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("Id da Conta da Marcia: " + conta.getId()); //antes de instanciar o em2 estava no estado Detached.
		conta.setSaldo(500.0);
		
		em2.getTransaction().begin(); 
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}
