package sample1;
import org.springframework.beans.factory.*;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, 
InitializingBean, DisposableBean {
    
    private String greeting;
    private String beanName;
    private BeanFactory beanFactory;
    
    public MessageBeanImpl() {
        System.out.println("�@Bean�̃R���X�g���N�^���s");
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
        System.out.println("�A�Z�b�^�[���\�b�h�̎��s");
    }
    
    public void setBeanName(String beanName) {
        System.out.println("�BBean���̃Z�b�g");
        this.beanName = beanName;
        System.out.println(" -> " + beanName);
    }
    
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("�CBeanFactory�̃Z�b�g");
        this.beanFactory = beanFactory;
        System.out.println(" -> " +beanFactory.getClass());
    }
    
    public void init() {
        System.out.println("�F���������\�b�h�����s");
    }
    
    public void destroy() {
        System.out.println("�I��");
    }
    
    public void afterPropertiesSet() {
        System.out.println("�E�v���p�e�B�Z�b�g����");
    }
    
    public void sayHello() {
        System.out.println(greeting + beanName + "!");
    }
}