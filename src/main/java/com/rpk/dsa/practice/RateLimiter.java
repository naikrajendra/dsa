package com.rpk.dsa.practice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimiter {
    private final long maxTokensPerClient;
    private final long refillIntervalMs;
    // Thread-safe map to store limiters for each clientId
    private final Map<String, TokenBucket> clientLimiters = new ConcurrentHashMap<>();

    public RateLimiter(long maxTokensPerClient, long refillIntervalMs) {
        this.maxTokensPerClient = maxTokensPerClient;
        this.refillIntervalMs = refillIntervalMs;
    }

    public boolean allowRequest(String clientId) {
        // Fetch existing limiter or create a new one atomically if it doesn't exist
        TokenBucket bucket = clientLimiters.computeIfAbsent(clientId, 
            id -> new TokenBucket(maxTokensPerClient, refillIntervalMs));
        
        return bucket.allowRequest();
    }

    // Inner class representing a single client's bucket
    private static class TokenBucket {
        private final long maxTokens;
        private final long refillIntervalMs;
        private final AtomicLong tokens;
        private long lastRefillTimestamp;

        public TokenBucket(long maxTokens, long refillIntervalMs) {
            this.maxTokens = maxTokens;
            this.refillIntervalMs = refillIntervalMs;
            this.tokens = new AtomicLong(maxTokens);
            this.lastRefillTimestamp = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            refill();
            if (tokens.get() >= 1) {
                tokens.decrementAndGet();
                return true;
            }
            return false;
        }

        private void refill() {
            long now = System.currentTimeMillis();
            if (now - lastRefillTimestamp >= refillIntervalMs) {
                tokens.set(maxTokens);
                lastRefillTimestamp = now;
            }
        }
    }

}
