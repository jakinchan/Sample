package ui;

import model.Player;
import model.Team;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;

public class UpdatePlayerUi extends AbstractUi {

	private PlayerDao playerDao;

	private TeamDao teamDao;

	public void setPlayerDao(PlayerDao dao) {
		this.playerDao = dao;
	}

	public void setTeamDao(TeamDao service) {
		this.teamDao = service;
	}

	public void show() {

		Player player = getPlayer();
		if (player == null) {
			return;
		}

		String name = getName(player);
		if (StringUtils.isNotEmpty(name)) {
			player.setName(name);
		}

		Team team = getTeam(player);
		if (team != null) {
			player.setTeam(team);
		}

		this.playerDao.updatePlayer(player);
		System.out.printf("�I��ID�u%s�v�̑I����A�I�薼�u%s�v�A�`�[���u%s�v�ɏC�����܂����B%n", player.getId(), player.getName(), player.getTeam().getName());
	}

	protected Player getPlayer() {
		final String playerId = "�I��ID";
		// ���j���[�̕\��
		showMenu(playerId);
		System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
		// �R���\�[���ւ̓��͂��擾
		String id = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isEmpty(id)) {
			return null;
			// ���l��
		} else if (UiUtils.isNumeric(id, playerId)) {
			// ID�őI�������
			Player player = this.playerDao.getPlayer(Integer.valueOf(id));

			if (player == null) {
				// �Y������I�肪���݂��Ȃ�
				System.out.printf("���͂��ꂽ�I��ID�u%s�v�̑I��͑��݂��܂���ł����B%n", id);
				return getPlayer();
			}
			return player;
		}
		return getPlayer();
	}

	protected String getName(Player player) {
		final String playerName = "�I�薼";
		// ���j���[��\��
		showMenu(playerName);
		System.out.println("�Ȃɂ����͂�����Enter�������ƕύX���܂���B");
		System.out.printf("���̒l�F%s%n", player.getName());
		// �R���\�[���ւ̓��͂��擾
		String name = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		// 128�����ȉ���
		if (UiUtils.isSmallLength(name, playerName, 128)) {
			return name;
		}
		return getName(player);
	}

	protected Team getTeam(Player player) {
		final String teamId = "�`�[��ID";
		// ���j���[��\��
		showMenu(teamId);
		System.out.println("�Ȃɂ����͂�����Enter�������ƕύX���܂���B");
		System.out.printf("���̒l�F%s %s%n", player.getTeam().getId(), player.getTeam().getName());
		// �R���\�[���ւ̓��͂��擾
		String id = getInputedString();
		// �����񂪓��͂���Ă��邩
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		// ���l��
		if (UiUtils.isNumeric(id, teamId)) {
			// ID�Ń`�[��������
			Team team = this.teamDao.getTeam(Integer.valueOf(id));
			if (team == null) {
				// �Y������I�肪���݂��Ȃ�
				System.out.printf("���͂��ꂽ�`�[�����u%s�v�̃`�[���͑��݂��܂���ł����B%n", id);
				return getTeam(player);
			}
			return team;
		}
		return getTeam(player);
	}

	protected void showMenu(String wanted) {
		System.out.println("--------------------");
		System.out.println("�w�I�薼�Ӂx�u�I��C���v");
		System.out.println("");
		System.out.printf("%s����͂��AEnter�������Ă��������B", wanted);
	}

}
