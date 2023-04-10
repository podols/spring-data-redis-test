package com.example.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private ExternalApiService externalApiService;

    @Autowired
    StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {

        String userName = null;

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:" + userId);
        if(cachedName != null) {
            userName = cachedName;
        }
        else {
            userName = externalApiService.getUserName(userId);
            ops.set("nameKey:" + userId, userName, 5, TimeUnit.SECONDS);
        }

        int userAge = externalApiService.getUserAge(userId);

        System.out.println();
        return new UserProfile(userName, userAge);
    }
}
