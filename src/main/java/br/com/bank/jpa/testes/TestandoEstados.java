package br.com.bank.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Dom Almir");
		conta.setAgencia(987987);
		conta.setNumero(4444);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}

//	Os estados de uma entidade são: Managed, Detached, Transient e Removed
//	Os métodos do EntityManager, como persist, merge ou remove alteram o estado da entidade