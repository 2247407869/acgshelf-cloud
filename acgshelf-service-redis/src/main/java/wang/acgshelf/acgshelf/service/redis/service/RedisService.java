package wang.acgshelf.acgshelf.service.redis.service;

public interface RedisService {
    public void set(String key, Object value, long seconds);

    public Object get(Object key);
}
