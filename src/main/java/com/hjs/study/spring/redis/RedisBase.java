package com.hjs.study.spring.redis;

import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisBase {

    private StringRedisTemplate template;

    /**
     * @return the template
     */
    public StringRedisTemplate getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }

}
