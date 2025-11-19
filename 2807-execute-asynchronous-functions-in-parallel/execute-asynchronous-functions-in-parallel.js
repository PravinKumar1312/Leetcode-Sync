/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        const results = new Array(functions.length);
        let completedCount = 0;
        
        // Handle empty array case
        if (functions.length === 0) {
            resolve(results);
            return;
        }
        
        functions.forEach((fn, index) => {
            // Execute each function to get a promise
            const promise = fn();
            
            promise
                .then(value => {
                    // Store result at the correct index to maintain order
                    results[index] = value;
                    completedCount++;
                    
                    // Check if all promises have resolved
                    if (completedCount === functions.length) {
                        resolve(results);
                    }
                })
                .catch(error => {
                    // Reject immediately on first error
                    reject(error);
                });
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */