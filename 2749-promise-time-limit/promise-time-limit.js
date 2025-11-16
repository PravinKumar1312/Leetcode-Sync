/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    return async function(...args) {
        return new Promise(async (resolve, reject) => {
            // Set up timeout rejection
            const timeoutId = setTimeout(() => {
                reject("Time Limit Exceeded");
            }, t);
            
            try {
                // Execute the original function
                const result = await fn(...args);
                clearTimeout(timeoutId); // Clear timeout if function completes
                resolve(result);
            } catch (err) {
                clearTimeout(timeoutId); // Clear timeout if function throws error
                reject(err);
            }
        });
    };
};