package com.tinyurl.service;

import com.tinyurl.DTO.ShortUrlResonse;
import com.tinyurl.model.ShortUrlEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShortUrlService {
    Map<String, String> map = new HashMap<>();
    public ShortUrlResonse createShortUrl(ShortUrlEntity shortURLEntity) {
        String code = generateCode();
        map.put(code, shortURLEntity.getUrl());
        String shortUrl = "https://localhost:8080/"+code;

        ShortUrlResonse response = new ShortUrlResonse();
        response.setCode(code);
        response.setShortUrl(shortUrl);
        response.setOriginalUrl(shortURLEntity.getUrl());
        return response;
    }
    private String generateCode(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 7; i++){
            int randomIndex = (int) (Math.random()*chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public String getOriginalUrl(@PathVariable String code) {
        return map.get(code);
    }
}
