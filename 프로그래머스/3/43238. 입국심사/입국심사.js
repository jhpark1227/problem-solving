const MAX = 1_000_000_000;

function solution(n, times) {
    return binarySearch(n, times);
}

function binarySearch(n, times) {
    const maxTime = Math.max(...times);
    let left = 1;
    let right = maxTime * n;
    while(left < right) {
        const mid = Math.floor((left + right) / 2)
        if (isPossible(n, mid, times)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}

function isPossible(n, limit, times) {
    let sum = 0;
    for(let time of times) {
        sum += Math.floor(limit / time);
    }
    return n <= sum;
}