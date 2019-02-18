package wang.acgshelf.acgshelf.service.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wang.acgshelf.acgshelf.service.redis.service.RedisService;

@RestController
public class RedisController {
    private static final String RESULT_OK = "ok";

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(String key, String value, long seconds) {
        redisService.put(key, value, seconds);
        return RESULT_OK;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(String key) {
        String json = null;

        Object obj = redisService.get(key);
        if (obj != null) {
            json = (String) redisService.get(key);
        }

        return json;
    }
}
