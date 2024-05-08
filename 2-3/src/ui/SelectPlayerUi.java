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
		// ヘッダーを表示
		showHeader();
		// コンソールへの入力を取得
		Integer teamId = getTeamId();
		// 選手一覧を表示
		showPlayerList(this.playerDao.getPlayerList(teamId));
		System.out.println("Enterを押してください。");
		getInputedString();
		super.show();
	}

	protected Integer getTeamId() {
		System.out.println("一覧表示するチームのIDを入力し、Enterを押してください。");
		// コンソールへの入力を取得
		String teamId = getInputedString();
		// 数値か
		if (StringUtils.isNotEmpty(teamId) && StringUtils.isNumeric(teamId)) {
			return Integer.valueOf(teamId);
		}
		return getTeamId();
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("『選手名鑑』「選手一覧」");
		System.out.println("");
	}

	protected void showMenu() {
		showHeader();
		System.out.println("1.選手修正");
		System.out.println("2.選手削除");
		System.out.println("3.メニューに戻る");
		System.out.println("");
		System.out.println("番号を入力し、Enterを押してください。");
	}

	protected void showPlayerList(List<Player> playerList) {
		System.out.println("--------------------");
		System.out.println("『選手名鑑』「選手一覧」");
		// 選手が1人でもいるか
		if (!playerList.isEmpty()) {
			Player player = playerList.get(0);
			System.out.printf("チーム名：%s%n", player.getTeam().getName());
		}
		System.out.println("ID    名前");
		for (Player player : playerList) {
			// 選手IDと選手名の表示
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
			// 1.選手修正
			updatePlayerUi.show();
			break;
		case 2:
			// 2.選手削除
			deletePlayerUi.show();
			break;
		default:
			return;
		}
	}

}
