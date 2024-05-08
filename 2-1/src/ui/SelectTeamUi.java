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
        // �`�[���ꗗ�̕\��
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter�������Ă��������B");
        getInputedString();
    }

    protected void showTeamList(List<Team> teamList) {
        System.out.println("--------------------");
        System.out.println("�w�I�薼�Ӂx�u�`�[���ꗗ�v");
        System.out.println("ID    ���O");
        for (Team team : teamList) {
        	// �`�[��ID�ƃ`�[�����̕\��
        	System.out.printf("%d  %s%n", team.getId(), team.getName());
		}
    }
}
