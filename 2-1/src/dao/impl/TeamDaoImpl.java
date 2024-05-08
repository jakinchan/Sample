package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Team;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TeamDao;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {
    
    public List<Team> getTeamList() throws DataAccessException {
        // コールバックインターフェースの生成
        RowMapper<Team> rowMapper = new TeamRowMapper();
        // SQLの実行
        return getJdbcTemplate().query("SELECT team_id, name FROM team", rowMapper);
    }

    protected class TeamRowMapper implements RowMapper<Team> {

        private List<Team> teamList = new ArrayList<Team>();

        public List<Team> getResults() {
            return teamList;
        }

        public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
            // ResultSetからオブジェクトへ詰め替え
            Team team = new Team();
            team.setId(rs.getInt("team_id"));
            team.setName(rs.getString("name"));
            
            return team;
        }
    }
}
