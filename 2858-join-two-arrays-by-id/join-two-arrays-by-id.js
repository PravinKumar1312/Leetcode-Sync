/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map = new Map();
    
    // Add all objects from arr1 to the map
    for (const obj of arr1) {
        map.set(obj.id, obj);
    }
    
    // Merge objects from arr2
    for (const obj of arr2) {
        if (map.has(obj.id)) {
            // Merge existing object with new object (arr2 overrides)
            const existing = map.get(obj.id);
            map.set(obj.id, { ...existing, ...obj });
        } else {
            map.set(obj.id, obj);
        }
    }
    
    // Convert map values to array and sort by id
    const result = Array.from(map.values());
    result.sort((a, b) => a.id - b.id);
    
    return result;
};