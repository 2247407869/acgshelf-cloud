package wang.acgshelf.acgshelf.service.sso.service.consumer.fallback;

import org.springframework.stereotype.Component;
import wang.acgshelf.acgshelf.common.hystrix.Fallback;
import wang.acgshelf.acgshelf.service.sso.service.consumer.RedisService;

@Component
public class RedisServiceFallback implements RedisService {
    @Override
    public String put(String key, String value, long seconds) {
        return Fallback.badGateway();
    }

    @Override
    public String get(String key) {
        return Fallback.badGateway();
    }
}
