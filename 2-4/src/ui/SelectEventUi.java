package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Event;

import org.apache.commons.lang.StringUtils;

import dao.EventDao;

public class SelectEventUi extends AbstractUi {

	private static final String DATE_FORMAT_MESSAGE = "���t��YYYYMMDD�`���œ��͂��Ă��������B(��:20100101)";

	private EventDao eventDao;

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// ���j���[��\��
		showMenu("�����J�n��");
		// �R���\�[���ւ̓��͂��擾
		Date start = getDate();
		if (start == null) {
			return;
		}
		// �R���\�[���ւ̓��͂��擾
		showMenu("�����I����");
		Date end = getDate();
		if (end == null) {
			return;
		}
		// �J�n���ƏI�����̑召������
		if (start.compareTo(end) > 0) {
			System.out.println("�����I�����ɂ͌����J�n������̓��t����͂��Ă��������B");
			show();
			return;
		}
		// �C�x���g���擾
		List<Event> eventList = this.eventDao.getEventList(start, end);
		// �C�x���g�ꗗ��\��
		showEventList(eventList);

	}

	protected void showEventList(List<Event> eventList) {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�C�x���g�ꗗ�v");
		System.out.println("ID    ���O    ���t");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		for (Event event : eventList) {
			// �C�x���gID�ƃC�x���g���A���t��\��
			System.out.printf("%s  %s  %s%n", event.getEventId(), event.getName(), dateFormat.format(event.getDate()));
		}

	}

	protected Date getDate() {

		// �R���\�[���ւ̓��͂��擾
		String dateString = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}

		// 8����(yyyyMMdd)��
		if (dateString.length() != 8) {
			System.out.println(DATE_FORMAT_MESSAGE);
			return getDate();
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date;
		try {
			// Date�ɕϊ�
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// ���t�ɕϊ��ł��Ȃ��`���̕�����
			System.out.println(DATE_FORMAT_MESSAGE);
			return getDate();
		}

		// ���ݓ���薢���̓��t��
		if (new Date().after(date)) {
			System.out.println("�ߋ��̓��t�͓��͂ł��܂���B������x���t����͂��Ă��������B");
			return getDate();
		}

		return date;

	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�C�x���g�����v");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s����͂��AEnter�������Ă��������B%n", wanted);
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
		System.out.println(DATE_FORMAT_MESSAGE);
	}

}
