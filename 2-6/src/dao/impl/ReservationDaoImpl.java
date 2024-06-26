package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Reservation;
import dao.ReservationDao;

public class ReservationDaoImpl implements ReservationDao {

	@PersistenceContext
	private EntityManager em;

	public void cancelReservation(Reservation reservation) {
		reservation = em.merge(reservation);
		// \ñðí
		em.remove(reservation);

	}

	public Reservation getReservation(Integer reservationId) {
		// IDÅ\ñðæ¾
		return em.find(Reservation.class, reservationId);
	}

	public void addReservation(Reservation reservation) {
		// \ñðo^
		em.persist(reservation);
	}

}
