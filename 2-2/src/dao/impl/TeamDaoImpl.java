package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Team;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import dao.TeamDao;

public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao {

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
    
    public Team getTeam(Integer teamId) throws DataAccessException {
    	final String sql = "SELECT team_id, name FROM team WHERE team_id = :teamId";
    	SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);
        return getNamedParameterJdbcTemplate().query(sql, parameterSource, new TeamResultSetExtractor());
    }

    protected class TeamResultSetExtractor implements ResultSetExtractor<Team> {

        public Team extractData(ResultSet rs) throws SQLException, DataAccessException {
            // SQLの結果が少なくとも1件あるか
            if (rs.next()) {
                // ResultSetからオブジェクトへ詰め替え
                Team team = new Team();
                team.setId(rs.getInt("team_id"));
                team.setName(rs.getString("name"));
                return team;
            } else {
                return null;
            }
        }
    }
}