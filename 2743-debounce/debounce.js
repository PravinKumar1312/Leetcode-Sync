/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let timeoutId;
    
    return function(...args) {
        // Clear any existing timeout
        clearTimeout(timeoutId);
        
        // Set a new timeout with the latest arguments
        timeoutId = setTimeout(() => {
            fn.apply(this, args);
        }, t);
    };
};