package br.com.bank.jpa.newTestes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bank.jpa.modelo.Categoria;
import br.com.bank.jpa.modelo.Conta;
import br.com.bank.jpa.modelo.Movimentacao;
import br.com.bank.jpa.modelo.TipoMovimentacao;

public class PopulaMovimentacoesComCategoria {

    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

        Categoria categoria1 = new Categoria("Viagem de Moto");
        Categoria categoria2 = new Categoria("Viagem de bike");

        Conta conta = new Conta();
        conta.setTitular("Joaquina");
        conta.setAgencia(6541);
        conta.setNumero(777888);
        conta.setSaldo(250.0);
        
        Conta conta2 = new Conta();
        conta2.setTitular("Figueroa");
        conta2.setAgencia(3265);
        conta2.setNumero(444666);
        conta2.setSaldo(150.0);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(LocalDateTime.now()); // hoje
        movimentacao1.setDescricao("Viagem a passeio");
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal(99.0));
        movimentacao1.setCategorias(Arrays.asList(categoria1));

        movimentacao1.setConta(conta2);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(LocalDateTime.now().plusDays(1)); // amanhã
        movimentacao2.setDescricao("Viagem de ferias");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal(250.0));
        movimentacao2.setCategorias(Arrays.asList(categoria2));

        movimentacao2.setConta(conta2);
        
        em.getTransaction().begin();
        
        em.persist(categoria1); 
        em.persist(categoria2); 

        em.persist(conta);
        em.persist(conta2);
        
        em.persist(movimentacao1);
        em.persist(movimentacao2);
       
        em.getTransaction().commit();
        em.close();

    }
}
