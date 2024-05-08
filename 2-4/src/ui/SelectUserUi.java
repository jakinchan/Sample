package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Ticket;
import model.User;

import org.apache.commons.lang.StringUtils;

import dao.TicketDao;
import dao.UserDao;

public class SelectUserUi extends AbstractUi {

	private UserDao userDao;

	private TicketDao ticketDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// ���j���[��\��
		showMenu("���[�U�[��");
		// �R���\�[���ւ̓��͂��擾
		String userName = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isEmpty(userName)) {
			return;
		}
		// ���O�Ń��[�U�[������
		User user = this.userDao.getUser(userName);
		if (user == null) {
			// �Y�����郆�[�U�[�����݂��Ȃ�
			System.out.printf("���͂��ꂽ���[�U�[���u%s�v�͑��݂��܂���ł����B%n", userName);
			show();
			return;
		}
		// ���[�U�[����\��
		showUser(user);
		// �\�񂵂Ă���`�P�b�g���擾
		List<Ticket> ticketList = this.ticketDao.getBookedTicketList(user.getUserId());
		// �\�񂵂Ă���`�P�b�g�ꗗ��\��
		showBookedTikectList(ticketList);

	}

	protected void showBookedTikectList(List<Ticket> ticketList) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		System.out.println(" ID  �C�x���g��  ���t  ���i  �\����� ");
		for (Ticket ticket : ticketList) {
			// �`�P�b�g�Ɨ\��̏���\��
			System.out.printf("%s  %s  %s  %s  %s%n", ticket.getTicketId(), ticket.getEvent().getName(), dateFormat
					.format(ticket.getEvent().getDate()), ticket.getRank().getPrice(), dateFormat.format(ticket
					.getReservation().getTimestamp()));
		}
	}

	protected void showUser(User user) {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�\��ς݃`�P�b�g�ꗗ�v");
		System.out.println("ID    ���O");
		System.out.printf("%s  %s%n", user.getUserId(), user.getName());
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u�\��ς݃`�P�b�g�ꗗ�v");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s����͂��AEnter�������Ă��������B%n", wanted);
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
	}
}
