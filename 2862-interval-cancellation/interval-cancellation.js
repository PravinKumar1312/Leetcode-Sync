/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    // Call immediately
    fn.apply(null, args);
    
    // Set up the interval
    const timer = setInterval(() => fn.apply(null, args), t);
    
    // Return the cancel function
    const cancelFn = () => clearInterval(timer);
    return cancelFn;
};