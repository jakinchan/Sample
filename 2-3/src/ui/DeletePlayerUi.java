package ui;

import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;

public class DeletePlayerUi extends AbstractUi {

	private PlayerDao playerDao;

	public void setPlayerDao(PlayerDao dao) {
		this.playerDao = dao;
	}

	public void show() {
		// ���j���[�̕\��
		showMenu();
		// �R���\�[���ւ̓��͂��擾
		String id = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isEmpty(id)) {
			return;
			// ���l��
		} else if (UiUtils.isNumeric(id, "�I��ID")) {
			// ID�őI����擾
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));
			if (player == null) {
				// �Y������I�肪���݂��Ȃ�
				System.out.printf("���͂��ꂽ�I��ID�u%s�v�̑I��͑��݂��܂���ł����B%n", id);
				show();
			} else {
				// �I����폜
				this.playerDao.deletePlayer(player);
				System.out.printf("�I��ID�u%s�v�̑I����폜���܂����B%n", id);
			}
		} else {
			show();
		}
	}

	protected void showMenu() {
		System.out.println("--------------------");
		System.out.println("�w�I�薼�Ӂx�u�I��폜�v");
		System.out.println("");
		System.out.println("�I��ID����͂��AEnter�������Ă��������B");
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
	}

}
