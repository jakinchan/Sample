package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

class DeletePlayer extends SqlUpdate {
    private static String SQL_DELETE_PLAYER = "DELETE FROM player WHERE player_id = ?";

    public DeletePlayer(DataSource ds) {
        super(ds, SQL_DELETE_PLAYER);
        super.declareParameter(new SqlParameter("player_id", Types.INTEGER));
        compile();
    }
}
