/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();
    let callCount = 0;
    
    const memoized = function(...args) {
        // Create a unique key for the arguments
        // For sum function, we need to preserve argument order
        const key = JSON.stringify(args);
        
        if (cache.has(key)) {
            return cache.get(key);
        }
        
        callCount++;
        const result = fn(...args);
        cache.set(key, result);
        return result;
    }
    
    // Add method to get call count
    memoized.getCallCount = function() {
        return callCount;
    }
    
    return memoized;
}