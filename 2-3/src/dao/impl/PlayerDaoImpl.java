package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Player;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.PlayerDao;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

	private SimpleJdbcInsert insertPlayer;

	private PlayerListQuery playerListQuery;

	private PlayerQuery playerQuery;

	private DeletePlayer deletePlayer;

	private UpdatePlayer updatePlayer;

	protected void initDao() throws Exception {
		this.insertPlayer = new SimpleJdbcInsert(getDataSource()).withTableName("player")
				.usingGeneratedKeyColumns("id");
		this.playerListQuery = new PlayerListQuery(getDataSource());
		this.playerQuery = new PlayerQuery(getDataSource());
		this.deletePlayer = new DeletePlayer(getDataSource());
		this.updatePlayer = new UpdatePlayer(getDataSource());
	}

	public void insertPlayer(Player player) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", player.getName());
		parameters.put("team_id", player.getTeam().getId());
		// 選手の登録
		Number newId = this.insertPlayer.executeAndReturnKey(parameters);
		player.setId(newId.intValue());
	}

	public Player getPlayer(Integer id) throws DataAccessException {
		// 選手の検索
		return this.playerQuery.findObject(id);
	}

	public List<Player> getPlayerList(Integer teamId) throws DataAccessException {
		// 選手一覧の検索
		return this.playerListQuery.execute(teamId);
	}

	public void deletePlayer(Player player) throws DataAccessException {
		// 選手の削除
		this.deletePlayer.update(player.getId());
	}

	public void updatePlayer(Player player) throws DataAccessException {
		// 選手の更新
		this.updatePlayer.update(player.getName(), player.getTeam().getId(), player.getId());
	}
}
