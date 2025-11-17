var TimeLimitedCache = function() {
    this.cache = new Map();
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    const exists = this.cache.has(key) && this.cache.get(key).expirationTime > Date.now();
    this.cache.set(key, {
        value,
        expirationTime: Date.now() + duration
    });
    return exists;
};

TimeLimitedCache.prototype.get = function(key) {
    if (this.cache.has(key)) {
        const entry = this.cache.get(key);
        if (entry.expirationTime > Date.now()) {
            return entry.value;
        }
        this.cache.delete(key);
    }
    return -1;
};

TimeLimitedCache.prototype.count = function() {
    const now = Date.now();
    let count = 0;
    
    // Clean up while counting
    for (const [key, entry] of this.cache.entries()) {
        if (entry.expirationTime > now) {
            count++;
        } else {
            this.cache.delete(key);
        }
    }
    return count;
};