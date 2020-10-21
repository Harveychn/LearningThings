package designpattern;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/10 9:03
 * [description]: 装饰器模式
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println();
        Component decorator = new ConcreteDecorator(component);
        decorator.operation();
    }

    interface Component {
        void operation();
    }

    static class ConcreteComponent implements Component {

        public ConcreteComponent() {
            System.out.println("创建具体构建角色!");
        }

        @Override
        public void operation() {
            System.out.println("调用具体构建角色的方法 operation!");
        }
    }

    static class Decorator implements Component {
        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }

    static class ConcreteDecorator extends Decorator {

        public ConcreteDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            addBehavior();
        }

        public void addBehavior() {
            System.out.println("为具体构建角色添加额外的功能 addBehavior!");
        }
    }
}
