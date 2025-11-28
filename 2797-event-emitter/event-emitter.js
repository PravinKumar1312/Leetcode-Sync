class EventEmitter {
    constructor() {
        // Map to store events and their callbacks
        this.events = new Map();
        // Counter for subscription IDs
        this.idCounter = 0;
    }
    
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        // Initialize event if it doesn't exist
        if (!this.events.has(eventName)) {
            this.events.set(eventName, new Map());
        }
        
        const eventCallbacks = this.events.get(eventName);
        const subscriptionId = this.idCounter++;
        
        // Store callback with its ID
        eventCallbacks.set(subscriptionId, callback);
        
        return {
            unsubscribe: () => {
                // Remove this specific callback
                eventCallbacks.delete(subscriptionId);
                // Clean up empty events
                if (eventCallbacks.size === 0) {
                    this.events.delete(eventName);
                }
                return undefined;
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        // If event doesn't exist or has no callbacks, return empty array
        if (!this.events.has(eventName)) {
            return [];
        }
        
        const eventCallbacks = this.events.get(eventName);
        const results = [];
        
        // Call all callbacks in the order they were added
        // Map preserves insertion order in modern JavaScript
        for (const callback of eventCallbacks.values()) {
            results.push(callback(...args));
        }
        
        return results;
    }
}