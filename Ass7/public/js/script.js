function sum(numbers) {
    return numbers.reduce((acc, num) => acc + num, 0);
}

function multiply(numbers) {
    return numbers.reduce((acc, num) => acc * num, 1);
}

function reverse(str) {
    return str.split('').reduce((acc, char) => char + acc, '');
}

function filterLongWords(words, length) {
    return words.filter(word => word.length > length);
}

const nums = [1, 2, 3, 4];
console.log(sum(nums));
console.log(multiply(nums));

const str = "hello";
console.log(reverse(str));

const words = ["hello", "world", "JavaScript", "is", "fun"];
const minLength = 3;
console.log(filterLongWords(words, minLength));