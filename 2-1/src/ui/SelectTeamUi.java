package ui;

import java.util.List;

import model.Team;
import dao.TeamDao;

public class SelectTeamUi extends AbstractUi {

    private TeamDao teamDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void show() {
        // チーム一覧の表示
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enterを押してください。");
        getInputedString();
    }

    protected void showTeamList(List<Team> teamList) {
        System.out.println("--------------------");
        System.out.println("『選手名鑑』「チーム一覧」");
        System.out.println("ID    名前");
        for (Team team : teamList) {
        	// チームIDとチーム名の表示
        	System.out.printf("%d  %s%n", team.getId(), team.getName());
		}
    }
}
