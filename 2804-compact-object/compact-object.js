var compactObject = function(obj) {
    if (obj === null) return null;
    if (Array.isArray(obj)) {
        return obj.map(compactObject).filter(Boolean);
    }
    if (typeof obj === 'object') {
        const result = {};
        for (const [key, value] of Object.entries(obj)) {
            const compacted = compactObject(value);
            if (compacted) {
                result[key] = compacted;
            }
        }
        return result;
    }
    return obj;
};