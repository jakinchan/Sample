package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {
        // ���j���[��\��
        showMenu();
        // �R���\�[���ւ̓��͂��擾
        String inputedString = getInputedString();
        // ���͕�����̌���
        if (isValidNumber(inputedString)) {
            // ���������s
            execute(NumberUtils.toInt(inputedString));
        }     
    }

    abstract protected void showMenu();

    abstract protected int getMaxMenuNumber();

    abstract protected int getMinMenuNumber();

    abstract protected void execute(int number);

    protected boolean isValidNumber(String str) {
        
        // �����񂪓��͂���Ă��邩
        if (StringUtils.isBlank(str)) {
            return false;
        // ���l��
        } else if (!StringUtils.isNumeric(str)) {
            return false;
        }
        // ���l�Ȃ̂�int�ɕϊ�
        int number = NumberUtils.toInt(str);
        // ���l�����j���[�ɕ\������Ă���ԍ��͈̔͂�
        if (getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
            return true;
        }
        return false;
    }
}
