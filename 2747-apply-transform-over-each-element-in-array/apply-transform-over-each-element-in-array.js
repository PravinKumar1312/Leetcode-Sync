/*
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const result = [];
    
    for (let i = 0; i < arr.length; i++) {
        // Apply the function to current element and index
        const transformedValue = fn(arr[i], i);
        result.push(transformedValue);
    }
    
    return result;
};