package sample1;
import org.springframework.beans.factory.*;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, 
InitializingBean, DisposableBean {
    
    private String greeting;
    private String beanName;
    private BeanFactory beanFactory;
    
    public MessageBeanImpl() {
        System.out.println("①Beanのコンストラクタ実行");
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
        System.out.println("②セッターメソッドの実行");
    }
    
    public void setBeanName(String beanName) {
        System.out.println("③Bean名のセット");
        this.beanName = beanName;
        System.out.println(" -> " + beanName);
    }
    
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("④BeanFactoryのセット");
        this.beanFactory = beanFactory;
        System.out.println(" -> " +beanFactory.getClass());
    }
    
    public void init() {
        System.out.println("⑦初期化メソッドを実行");
    }
    
    public void destroy() {
        System.out.println("終了");
    }
    
    public void afterPropertiesSet() {
        System.out.println("⑥プロパティセット完了");
    }
    
    public void sayHello() {
        System.out.println(greeting + beanName + "!");
    }
}