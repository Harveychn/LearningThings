package designpattern;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/10 12:58
 * [description]:
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new ConcreteStrategyA());
        context.algorithm();

        context.setStrategy(new ConcreteStrategyB());
        context.algorithm();
    }

    // 抽象策略类
    interface Strategy {
        void algorithm();
    }

    // 具体策略类A
    static class ConcreteStrategyA implements Strategy {

        @Override
        public void algorithm() {
            System.out.println("strategy A");
        }
    }

    // 具体策略类B
    static class ConcreteStrategyB implements Strategy {

        @Override
        public void algorithm() {
            System.out.println("strategy B");
        }
    }

    static class Context {
        private Strategy strategy;

        public Strategy getStrategy() {
            return strategy;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public void algorithm() {
            strategy.algorithm();
        }

    }
}
