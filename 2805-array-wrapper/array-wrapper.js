var ArrayWrapper = function(nums) {
    this.nums = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    // Return sum of all elements for the + operator
    return this.nums.reduce((sum, num) => sum + num, 0);
}

ArrayWrapper.prototype.toString = function() {
    // Return string representation in format "[element1,element2,...]"
    return `[${this.nums.join(',')}]`;
}