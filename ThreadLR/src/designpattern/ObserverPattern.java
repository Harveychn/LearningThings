package designpattern;

import java.util.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/10 13:50
 * [description]: 观察者模式
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observerA = new ConcreteObserverA();
        Observer observerB = new ConcreteObserverB();
        subject.add(observerA);
        subject.add(observerB);
        subject.setState(0);
    }

    static abstract class Subject {
        protected List<Observer> observers = new ArrayList<>();

        public void add(Observer observer) {
            this.observers.add(observer);
        }

        public void remove(Observer observer) {
            observers.remove(observer);
        }

        public abstract void setState(Integer state);
    }

    static class ConcreteSubject extends Subject {
        private Integer state;

        public void setState(Integer state) {
            this.state = state;
            notifyMethod();
        }

        public void notifyMethod() {
            System.out.println("通知消息");
            for (Observer observer : observers) {
                observer.process();
            }
        }
    }

    interface Observer {
        void process();
    }

    static class ConcreteObserverA implements Observer {

        @Override
        public void process() {
            System.out.println("观察者A 接收消息!");
        }
    }

    static class ConcreteObserverB implements Observer {

        @Override
        public void process() {
            System.out.println("观察者B 接收消息!");
        }
    }
}
