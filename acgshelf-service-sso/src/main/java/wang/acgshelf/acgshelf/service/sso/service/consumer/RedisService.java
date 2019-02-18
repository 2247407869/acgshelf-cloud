package wang.acgshelf.acgshelf.service.sso.service.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wang.acgshelf.acgshelf.service.sso.service.consumer.fallback.RedisServiceFallback;

@FeignClient(value = "acgshelf-service-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(@RequestParam("key") String key,
                      @RequestParam("value") Object value,
                      @RequestParam("seconds") long seconds);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(@RequestParam("key") String key);
}
