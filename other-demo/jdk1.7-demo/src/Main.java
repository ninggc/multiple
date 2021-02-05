import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Object, Object> map = new HashMap<>(10);
        // Collections.singleton()

        final ReferenceQueue<Object> queue = new ReferenceQueue<>();

        test(queue);

        System.gc();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Reference<?> poll = queue.poll();
                    if (poll != null) {
                        System.out.println(poll.get());
                    }
                }
            }
        }.start();

        Object o = new Object();
        PhantomReference<Object> objectPhantomReference =
                new PhantomReference<Object>(o, queue);

        objectPhantomReference.get();
        o = null;
        System.gc();


        // System.out.println("");
    }

    private static void test(ReferenceQueue<Object> queue) {

    }
}
