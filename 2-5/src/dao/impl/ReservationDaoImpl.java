package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import model.Reservation;
import dao.ReservationDao;

public class ReservationDaoImpl implements ReservationDao {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void cancelReservation(Reservation reservation) {
		EntityManager em = this.emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		reservation = em.merge(reservation);
		// �\����폜
		em.remove(reservation);
		
		tx.commit();
	}

	public Reservation getReservation(Integer reservationId) {
		EntityManager em = this.emf.createEntityManager();
		// ID�ŗ\����擾
		return em.find(Reservation.class, reservationId);
	}

}
