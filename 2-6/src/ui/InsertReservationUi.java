package ui;

import java.util.List;

import model.Reservation;
import model.Ticket;
import model.User;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import dao.ReservationDao;
import dao.TicketDao;
import dao.UserDao;

public class InsertReservationUi extends AbstractUi {

	private TicketDao ticketDao;

	private UserDao userDao;

	private ReservationDao reservationDao;

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Transactional
	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// �R���\�[������̓��͂��擾
		Integer rankId = getNumber();
		if (rankId == null) {
			return;
		}
		// ���j���[��\��
		showMenu("�`�P�b�g�̖���");
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
		// �R���\�[������̓��͂��擾
		Integer quantity = getNumber();
		if (quantity == null) {
			return;
		}
		// �����NID�ŗ\�񂳂�Ă��Ȃ��`�P�b�g�̖���������
		List<Ticket> ticketList = this.ticketDao.getNotBookedTicketList(rankId, quantity);
		if (ticketList == null) {
			// �Y������`�P�b�g�����݂��Ȃ�
			System.out.println("���͂��ꂽID���������N�̃`�P�b�g�͂���܂���ł����B������x���͂��Ă��������B");
			show();
			return;
		}

		if (ticketList.size() < quantity.intValue()) {
			// �`�P�b�g�����͂��ꂽ�������c���Ă��Ȃ�
			System.out.println("�`�P�b�g�����͂��ꂽ����������܂���ł����B������x���͂��Ă��������B");
			show();
			return;
		}
		// ���j���[��\��
		showMenu("���O");
		// �R���\�[������̓��͂��擾
		String name = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isBlank(name)) {
			return;
		}
		// ���[�U�[���Ń��[�U�[������
		User user = this.userDao.getUser(name);
		if (user == null) {
			// �V�K���[�U�[�𐶐�
			user = new User();
			user.setName(name);
			this.userDao.addUser(user);
		}
		// �\�񏈗������s
		reserve(ticketList, user);
	}

	protected void reserve(List<Ticket> ticketList, User user) {
		
		for (Ticket ticket : ticketList) {
			// �V�K�\��𐶐�
			Reservation reservation = new Reservation();
			reservation.setReservationId(ticket.getTicketId());
			reservation.setTicket(ticket);
			reservation.setUser(user);

			// �f�[�^�x�[�X�ɗ\���o�^
			this.reservationDao.addReservation(reservation);
		}
	}

	protected Integer getNumber() {
		// �R���\�[������̓��͂��擾
		String number = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isBlank(number)) {
			return null;
		}
		// ���l��
		if (StringUtils.isNumeric(number)) {
			return Integer.valueOf(number);
		}
		System.out.println("�����œ��͂��Ă��������B");

		return getNumber();
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�`�P�b�g�v");
		System.out.println("");
		showMenu("�\�񂵂����`�P�b�g��ID");
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s����͂��AEnter�������Ă��������B%n", wanted);
	}
}
