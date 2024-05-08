package ui;

import org.apache.commons.lang.StringUtils;

public class UiUtils {

    public static boolean isSmallLength(String name, String fieldName, int length) {

        if (name == null) {
            return true;
        }

        if (length < name.length()) {
            System.out.printf( "%s��%s�����ȉ��œ��͂��Ă��������B%n", fieldName, length);
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str, String fieldName) {
        // ���l��
        if (!StringUtils.isNumeric(str)) {
            System.out.printf("%s�͐����œ��͂��Ă��������B%n", fieldName);
            return false;
        }
        return true;
    }

}
