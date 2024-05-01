package com.example.binancetest.controller;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api")
public class CryptoController {
    private final String url;

    public CryptoController(@Value("${binance.url}") String url) {
        this.url = url;
    }

    @GetMapping("/get-price")
    public String getPrice(@RequestParam String pair){
        UMFuturesClientImpl client = new UMFuturesClientImpl(url);

        return getResult(pair ,client);
    }

    private static String getResult(String crypto, UMFuturesClientImpl client) {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("symbol", crypto);
        return client.market().markPrice(linkedHashMap);
    }
}
