package sample1;

import org.springframework.beans.factory.config.*;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("�D�������O��Bean�ɑ΂��鏈�������s");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("�G���������Bean�ɑ΂��鏈�������s");
        return bean;
    }        
}