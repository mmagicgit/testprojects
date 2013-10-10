package start;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.tools.Server;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import entities.Actor;
import entities.Movie;

public class Start {

	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");

		entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				entityManager.persist(new Actor("Sylvester Stallone", 1944));
			}
		}.execute();
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				Actor actor = entityManager.find(Actor.class, 1L);
				actor.setYearOfBirth(1946);
			}
		}.execute();
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				Actor actor = entityManager.find(Actor.class, 1L);
				actor.addMovie(new Movie("Rambo 2"));
			}
		}.execute();
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				Actor actor = entityManager.find(Actor.class, 1L);
				actor.addMovie(new Movie("The Expendables"));
			}
		}.execute();

		new EntityAction() {
			protected void action(EntityManager entityManager) {
				entityManager.persist(new Actor("Dolph Lundgren", 1957));
			}
		}.execute();
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				entityManager.persist(new Actor("John Travolta", 1960));
			}
		}.execute();
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				Actor actor = entityManager.find(Actor.class, 3L);
				entityManager.remove(actor);
			}
		}.execute();

		Server.startWebServer(connection);
		
		new EntityAction() {
			protected void action(EntityManager entityManager) {
				AuditReader reader = AuditReaderFactory.get(entityManager);
				System.out.println("Revision 1: " + reader.find(Actor.class, 1L, 1));
				System.out.println("Revision 2: " + reader.find(Actor.class, 1L, 2));
				System.out.println("Revision 3: " + reader.find(Actor.class, 1L, 3));
				System.out.println("Revision 4: " + reader.find(Actor.class, 1L, 4));
			}
		}.execute();
			
		entityManagerFactory.close();
		connection.close();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
