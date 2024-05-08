package ui;

import model.User;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;

public class UpdateUserUi extends AbstractUi {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// �R���\�[������̓��͂��擾
		Integer id = getUserId();
		if (id == null) {
			return;
		}
		// ID�Ń��[�U�[������
		User user = this.userDao.getUser(id);
		if (user == null) {
			// �Y�����郆�[�U�[�����݂��Ȃ�
			System.out.printf("���͂��ꂽ���[�U�[ID�u%s�v�͑��݂��܂���ł����B%n", id);
			show();
			return;
		}
		// ���[�U�[����\��
		showUser(user);
		// �R���\�[������̓��͂�\��
		String name = getName();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isBlank(name)) {
			return;
		}
		// ���[�U�[�����Z�b�g
		user.setName(name);
		// �f�[�^�x�[�X���X�V
		// this.userDao.updateUser(user);
	}

	protected Integer getUserId() {

		final String userId = "���[�U�[ID";
		// ���j���[��\��
		showMenu(userId);
		// �R���\�[������̓��͂��擾
		String id = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isBlank(id)) {
			return null;
		}
		// ���l��
		if (UiUtils.isNumeric(id, userId)) {
			return new Integer(id);
		}

		return getUserId();
	}

	protected String getName() {

		showMenu("�V�������[�U�[��");
		// �R���\�[������̓��͂��擾
		String newName = getInputedString();
		// 128�����ȉ���
		if (!UiUtils.isSmallLength(newName, "���[�U�[��", 128)) {
			return getName();
		}

		return newName;
	}

	protected void showUser(User user) {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u���[�U�[���ύX�v");
		System.out.println("ID    ���O");
		System.out.printf("%s  %s%n", user.getUserId(), user.getName());
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�`�P�b�g�\��x�u���[�U�[���ύX�v");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s����͂��AEnter�������Ă��������B%n", wanted);
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
	}
}