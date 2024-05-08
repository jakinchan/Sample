package ui;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import dao.RankDao;

public class SelectRankUi extends AbstractUi {

	private RankDao rankDao;

	private InsertReservationUi insertReservationUi;

	public void setRankDao(RankDao rankDao) {
		this.rankDao = rankDao;
	}

	public void setInsertReservationUi(InsertReservationUi insertReservationUi) {
		this.insertReservationUi = insertReservationUi;
	}

	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// �R���\�[������̓��͂��擾
		Integer eventId = getEventId();
		if (eventId == null) {
			return;
		}
		// �����N�ꗗ��\��
		showRanks(this.rankDao.getRank(eventId));

		this.insertReservationUi.show();
	}

	protected void showRanks(List<Object[]> rankList) {

		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�`�P�b�g�ꗗ�v");
		System.out.println("ID   ���O   ���i   �c��");

		for (Object[] objects : rankList) {
			// �����NID�ƃ����N���A���i�A�c�薇����\��
			System.out.printf("%s  %s  %s  %s%n", objects[0], objects[1], objects[2], objects[3]);
		}
	}

	protected Integer getEventId() {
		// �R���\�[������̓��͂��擾
		String eventId = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isBlank(eventId)) {
			return null;
		}
		// ���l��
		if (UiUtils.isNumeric(eventId, "ID")) {
			return Integer.valueOf(eventId);
		}
		return getEventId();
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�`�P�b�g�����v");
		System.out.println("");
		System.out.println("�\�񂵂����C�x���g��ID����͂��AEnter�������Ă��������B");
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
	}

}
