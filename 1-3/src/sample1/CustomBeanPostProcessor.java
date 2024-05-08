package sample1;

import org.springframework.beans.factory.config.*;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("‡D‰Šú‰»‘O‚ÌBean‚É‘Î‚·‚éˆ—‚ğÀs");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("‡G‰Šú‰»Œã‚ÌBean‚É‘Î‚·‚éˆ—‚ğÀs");
        return bean;
    }        
}