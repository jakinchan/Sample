package ui;

import java.util.List;

import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;

public class SelectPlayerUi extends AbstractUiTemplate {

	private PlayerDao playerDao;

	private UpdatePlayerUi updatePlayerUi;

	private DeletePlayerUi deletePlayerUi;

	public void setPlayerDao(PlayerDao dao) {
		this.playerDao = dao;
	}

	public void setDeletePlayerUi(DeletePlayerUi ui) {
		this.deletePlayerUi = ui;
	}

	public void setUpdatePlayerUi(UpdatePlayerUi ui) {
		this.updatePlayerUi = ui;
	}

	public void show() {
		// �w�b�_�[��\��
		showHeader();
		// �R���\�[���ւ̓��͂��擾
		Integer teamId = getTeamId();
		// �I��ꗗ��\��
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("Enter�������Ă��������B");
		getInputedString();
		super.show();
	}

	protected Integer getTeamId() {
		System.out.println("�ꗗ�\������`�[����ID����͂��AEnter�������Ă��������B");
		// �R���\�[���ւ̓��͂��擾
		String teamId = getInputedString();
		// ���l��
		if (StringUtils.isNotEmpty(teamId) && StringUtils.isNumeric(teamId)) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("�w�I�薼�Ӂx�u�I��ꗗ�v");
		System.out.println("");
	}

	protected void showMenu() {
		showHeader();
		System.out.println("1.�I��C��");
		System.out.println("2.�I��폜");
		System.out.println("3.���j���[�ɖ߂�");
		System.out.println("");
		System.out.println("�ԍ�����͂��AEnter�������Ă��������B");
	}

	protected void showPlayerList(List<Player> playerList) {
		System.out.println("--------------------");
		System.out.println("�w�I�薼�Ӂx�u�I��ꗗ�v");
		// �I�肪1�l�ł����邩
		if (!playerList.isEmpty()) {
			Player player = playerList.get(0);
			System.out.printf("�`�[�����F%s%n", player.getTeam().getName());
		}
		System.out.println("ID    ���O");
		for (Player player : playerList) {
			// �I��ID�ƑI�薼�̕\��
			System.out.printf("%d  %s%n", player.getId(), player.getName());
		}
	}

	protected int getMaxMenuNumber() {
		return 3;
	}

	protected int getMinMenuNumber() {
		return 1;
	}

	protected void execute(int number) {
		switch (number) {
		case 1:
			// 1.�I��C��
			updatePlayerUi.show();
			break;
		case 2:
			// 2.�I��폜
			deletePlayerUi.show();
			break;
		default:
			return;
		}
	}

}
