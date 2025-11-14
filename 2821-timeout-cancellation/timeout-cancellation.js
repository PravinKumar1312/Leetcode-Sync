/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    // Schedule the function execution
    const timeoutId = setTimeout(() => {
        fn(...args);
    }, t);
    
    // Return a cancel function
    const cancelFn = () => {
        clearTimeout(timeoutId);
    };
    
    return cancelFn;
};