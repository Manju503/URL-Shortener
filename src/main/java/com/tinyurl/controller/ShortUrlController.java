package com.tinyurl.controller;

import com.sun.net.httpserver.HttpsServer;
import com.tinyurl.DTO.ShortUrlResonse;
import com.tinyurl.model.ShortUrlEntity;
import com.tinyurl.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/urls")
public class ShortUrlController {
    private final ShortUrlService shortUrlService;

    @PostMapping
    public ResponseEntity<ShortUrlResonse> createShortUrl(@RequestBody ShortUrlEntity shortURLEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrlService.createShortUrl(shortURLEntity));
    }

        @GetMapping("/{code}")
        public ResponseEntity<Void> getUrl(@PathVariable String code){
            String originalUrl = shortUrlService.getOriginalUrl(code);
            if (originalUrl == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
        }
}
