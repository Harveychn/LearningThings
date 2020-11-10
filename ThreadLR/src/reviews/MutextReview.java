package reviews;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * author: zhengxiaohui
 * create time: 2020/11/4 16:26
 * description: TODO
 */
public class MutextReview {

    public static void main(String[] args) {

    }

    class Mutex {

        class Sync extends AbstractQueuedSynchronizer {

            private static final long serialVersionUID = -2962341590773418089L;

            @Override
            protected boolean tryAcquire(int arg) {
                return compareAndSetState(0, 1);
            }

            @Override
            protected boolean tryRelease(int arg) {
                setState(0);
                return true;
            }

            @Override
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }
        }
    }
}
