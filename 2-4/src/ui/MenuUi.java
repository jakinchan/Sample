package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
    
    private SelectEventUi selectEventUi;
    
    private SelectUserUi selectUserUi;
    
    public void setSelectEventUi(SelectEventUi selectEventUi) {
        this.selectEventUi = selectEventUi;
    }
    
    public void setSelectUserUi(SelectUserUi selectUserUi) {
        this.selectUserUi = selectUserUi;
    }

    protected void execute(int number) {
        switch (number) {
        case 1:
            // 1.�I��
            System.out.println("�I�����܂����B");
            System.exit(0);
        case 2:
            // 2.�C�x���g����
            this.selectEventUi.show();
            break;
        case 3:
            // 3.�\��ς݃`�P�b�g�ꗗ
            this.selectUserUi.show();
            break;
        }
    }

    protected int getMaxMenuNumber() {
        return 3;
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void showMenu() {
        System.out.println("--------------------");
        System.out.println("�w�`�P�b�g�\��x�u���j���[�v");
        System.out.println("");
        System.out.println("1.�I��");
        System.out.println("2.�C�x���g����");
        System.out.println("3.�\��ς݃`�P�b�g�ꗗ");
        System.out.println("");
        System.out.println("�ԍ�����͂��AEnter�������Ă��������B");
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
