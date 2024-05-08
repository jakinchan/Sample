package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import model.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public User getUser(String name) {
		EntityManager em = this.emf.createEntityManager();
		// ユーザー名でユーザーを取得
		List<User> userList = em.createQuery(" FROM User AS user WHERE user.name = :name ", User.class).setParameter(
				"name", name).getResultList();

		if (userList.isEmpty()) {
			return null;
		}

		return userList.get(0);
	}

	public User getUser(Integer id) {
		EntityManager em = this.emf.createEntityManager();
		// IDでユーザーを取得
		return em.find(User.class, id);
	}

	public void updateUser(User user) {
		EntityManager em = this.emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// ユーザーを更新
		em.merge(user);
		tx.commit();
	}
}
