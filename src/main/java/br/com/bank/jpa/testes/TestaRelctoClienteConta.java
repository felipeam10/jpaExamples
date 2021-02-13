package br.com.bank.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Cliente;
import br.com.bank.jpa.modelo.Conta;

public class TestaRelctoClienteConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Joaquina");
		cliente.setEndereco("Rua Consolacao 333");
		cliente.setProfissao("Administradora");
		cliente.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit(); 
		em.close();
		
	}
}
