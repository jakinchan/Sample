package ui;

import model.Player;
import model.Team;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;

public class InsertPlayerUi extends AbstractUi {

    private TeamDao teamDao;

    private PlayerDao playerDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void setPlayerDao(PlayerDao service) {
        this.playerDao = service;
    }

    public void show() {
        final String playerName = "�I�薼";
        // ���j���[�̕\��
        showMenu(playerName);
        // �R���\�[���ւ̓��͂��擾
        String name = getInputedString();
        // �����񂪓��͂���Ă��邩
        if (StringUtils.isEmpty(name)) {
            // ���j���[�֖߂�
            return;
        // 128�����ȉ���
        } else if (UiUtils.isSmallLength(name, playerName, 128)) {
            // �V�����I��𐶐�
            Player player = new Player();
            player.setName(name);
            // �`�[��������
            showTeamField(player);
        } else {
            show();
        }
    }

    protected void showTeamField(Player player) {
        final String teamId = "�`�[��ID";
        // ���j���[��\��
        showMenu(teamId);
        // �R���\�[���ւ̓��͂��擾
        String id = getInputedString();
        // �����񂪓��͂���Ă��邩        
        if (StringUtils.isEmpty(id)) {
            return;
        // ���l��
        } else if (UiUtils.isNumeric(id, teamId)) {
            // ID�Ń`�[��������
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                // �Y������`�[���͑��݂��Ȃ�
                System.out.printf("���͂��ꂽ�`�[�����u%s�v�̃`�[���͑��݂��܂���ł����B%n", id);
                showTeamField(player);
            } else {
                // �`�[����I��ɃZ�b�g
                player.setTeam(team);
                // �f�[�^�x�[�X�ɑI���o�^
                playerDao.insertPlayer(player);
                System.out.printf("�`�[���u%s�v�Ɂu%s�v�I���ǉ����܂����B%n", team.getName(), player.getName());
            }
        }
    }

    protected void showMenu(String wanted) {
        System.out.println("--------------------");
        System.out.println("�w�I�薼�Ӂx�u�I��ǉ��v");
        System.out.println("");
        System.out.printf("%s����͂��AEnter�������Ă��������B%n", wanted);
        System.out.println("�Ȃɂ����͂�����Enter�������ƃ��j���[�ɖ߂�܂��B");
    }
}
