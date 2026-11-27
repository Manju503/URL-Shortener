package com.tinyurl.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShortUrlResonse {
    private String code;
    private String shortUrl;
    private String originalUrl;
}
