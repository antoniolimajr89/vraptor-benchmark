package br.com.caelum.vraptor.event;

import java.util.Random;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.controller.World;
import br.com.caelum.vraptor.events.VRaptorInitialized;

@Dependent
public class InsertData {

	@PersistenceContext private EntityManager em;

	@Transactional
	public void insert(@Observes VRaptorInitialized event) {
		
		Random random = new Random();

		for (int i = 0; i < 10000; i++) {
			em.persist(new World(random.nextInt(10000) +1));
		}
	}
}
