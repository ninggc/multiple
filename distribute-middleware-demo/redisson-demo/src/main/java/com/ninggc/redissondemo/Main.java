package com.ninggc.redissondemo;

public class Main {
    public static void main(String[] args) {
        // // 1. Create config object
        // Config config = new Config();
        // config.useSingleServer().setAddress("redis://wonders.ninggc.cn:6379");
        //
        // // Sync and Async API
        // RedissonClient redisson = Redisson.create(config);
        // RScript script = redisson.getScript();
        //
        // String luaScript = null;
        // Object eval = script.eval(RScript.Mode.READ_WRITE, luaScript, RScript.ReturnType.MULTI);

        String luaScript = "if (redis.call('exists', KEYS[1]) == 0) then " +
                "redis.call('hincrby', KEYS[1], ARGV[2], 1); " +
                "redis.call('pexpire', KEYS[1], ARGV[1]); " +
                "return nil; " +
                "end; " +
                "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then " +
                "redis.call('hincrby', KEYS[1], ARGV[2], 1); " +
                "redis.call('pexpire', KEYS[1], ARGV[1]); " +
                "return nil; " +
                "end; " +
                "return redis.call('pttl', KEYS[1]);";

        String expireLuaScript = "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then " +
                "redis.call('pexpire', KEYS[1], ARGV[1]); " +
                "return 1; " +
                "end; " +
                "return 0;";
    }


}
