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
            // 1.終了
            System.out.println("終了しました。");
            System.exit(0);
        case 2:
            // 2.イベント検索
            this.selectEventUi.show();
            break;
        case 3:
            // 3.予約済みチケット一覧
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
        System.out.println("『チケット予約』「メニュー」");
        System.out.println("");
        System.out.println("1.終了");
        System.out.println("2.イベント検索");
        System.out.println("3.予約済みチケット一覧");
        System.out.println("");
        System.out.println("番号を入力し、Enterを押してください。");
    }

    public static void main(String[] args) {
        // Spring設定ファイルの読み込み
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = context.getBean(MenuUi.class);
        while (true) {
            menuUi.show();
        }
    }
}
