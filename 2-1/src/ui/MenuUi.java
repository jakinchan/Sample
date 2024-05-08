package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {

    private SelectTeamUi selectTeamUi;

    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
        this.selectTeamUi = selectTeamUi;
    }

    protected void showMenu() {
        System.out.println("--------------------");
        System.out.println("�w�I�薼�Ӂx�u���j���[�v");
        System.out.println("");
        System.out.println("1.�I��");
        System.out.println("2.�`�[���ꗗ");
        System.out.println("");
        System.out.println("�ԍ�����͂��AEnter�������Ă��������B");
    }

    protected int getMaxMenuNumber() {
        return 2;
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void execute(int number) {
        switch (number) {
        case 1:
            // 1.�I��
            System.out.println("�I�����܂����B");
            System.exit(0);
        case 2:
            // 2.�`�[���ꗗ
            this.selectTeamUi.show();
            break;
        }
    }

    public static void main(String[] args) {
        // Spring�ݒ�t�@�C���̓ǂݍ���
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = context.getBean(MenuUi.class);
        while (true) {
            menuUi.show();
        }
    }
}