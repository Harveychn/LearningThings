package designpattern;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/9/10 13:39
 * [description]: 代理模式
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }

    interface Subject {
        void request();
    }

    static class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("real subject!");
        }
    }

    static class Proxy implements Subject {

        private RealSubject realSubject;

        @Override
        public void request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }
            preRequest();
            realSubject.request();
            postRequest();
        }

        private void preRequest() {
            System.out.println("preRequest");
        }

        private void postRequest() {
            System.out.println("postRequest");
        }
    }
}
