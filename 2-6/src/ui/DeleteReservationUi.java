package ui;

import model.Reservation;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import dao.ReservationDao;

public class DeleteReservationUi extends AbstractUi {

	private ReservationDao reservationDao;

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Transactional
	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// �R���\�[������̓��͂��擾
		Integer reservationId = getReservationId();
		if (reservationId == null) {
			return;
		}
		// ID�ŗ\�������
		Reservation reservation = this.reservationDao.getReservation(reservationId);
		if (reservation == null) {
			// �Y������\��͑��݂��Ȃ�
			System.out.println("���͂��ꂽID�����\��͑��݂��܂���ł����B");
			show();
		}
		// �\���������
		this.reservationDao.cancelReservation(reservation);
		System.out.printf("ID�u%s�v�̗\����������܂����B%n", reservationId);
	}

	protected Integer getReservationId() {
		// �R���\�[������̓��͂��擾
		String reservationId = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isBlank(reservationId)) {
			return null;
		}
		// ���l��
		if (StringUtils.isNumeric(reservationId)) {
			return Integer.valueOf(reservationId);
		}
		System.out.println("ID�͐����œ��͂��Ă��������B");

		return getReservationId();
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�\��������v");
		System.out.println("");
		System.out.println("�\��������������`�P�b�g��ID����͂��AEnter�������Ă��������B");
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
	}
}
