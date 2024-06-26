package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {

    private SelectTeamUi selectTeamUi;

    private InsertPlayerUi insertPlayerUi;

    private SelectPlayerUi selectPlayerUi;

    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
        this.selectTeamUi = selectTeamUi;
    }

    public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
        this.insertPlayerUi = insertPlayerUi;
    }

    public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
        this.selectPlayerUi = selectPlayerUi;
    }

    protected void showMenu() {
        System.out.println("--------------------");
        System.out.println("『選手名鑑』「メニュー」");
        System.out.println("");
        System.out.println("1.終了");
        System.out.println("2.チーム一覧");
        System.out.println("3.選手追加");
        System.out.println("4.選手一覧");
        System.out.println("");
        System.out.println("番号を入力し、Enterを押してください。");
    }

    protected int getMaxMenuNumber() {
        return 4;
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void execute(int number) {
        switch (number) {
        case 1:
            // 1.終了
            System.out.println("終了しました。");
            System.exit(0);
        case 2:
            // 2.チーム一覧
            this.selectTeamUi.show();
            break;
        case 3:
            // 3.選手追加
            this.insertPlayerUi.show();
            break;
        case 4:
            // 4.選手一覧
            this.selectPlayerUi.show();
            break;
        }
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
