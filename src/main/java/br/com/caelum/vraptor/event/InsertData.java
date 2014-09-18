package br.com.caelum.vraptor.event;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.controller.Fortune;
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
		
		List<String> messages = Arrays.asList(
				"A journey of 1000 miles begins with one step.  ~ Lao Tzu",
				"A lean compromise is better then a fat lawsuit. - George Herbert",
				"A friend will soon bring you a gift.",
				"A new challenge is near.",
				"Wealth awaits you very soon",
				"Jealousy doesn't open doors, it closes them!",
				"It's better to be alone sometimes.",
				"When fear hurts you, conquer it and defeat it!",
				"Fortune favors the brave.",
				"Sometimes you just need to lay on the floor.",
				"Stop wishing. Start doing.",
				"フレームワークのベンチマーク"
			);
		
		for (String message: messages) {
			em.persist(new Fortune(message));
		}
	}
}
