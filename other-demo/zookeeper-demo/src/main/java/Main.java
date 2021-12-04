import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String cs = "wonders.ninggc.cn:2181";
        int st = 10;
        Watcher watcher = null;
        ZooKeeper zooKeeper = new ZooKeeper(cs, st, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });

        zooKeeper.getData("/turing", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {

            }
        }, "");

        // zooKeeper.
        System.out.println("end");
    }
}
