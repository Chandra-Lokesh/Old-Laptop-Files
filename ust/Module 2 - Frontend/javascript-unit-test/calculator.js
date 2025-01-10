let add = (a, b) => {
    if(typeof a != 'number' || typeof b != 'number'){
        throw new Error('Invalid Input');
    }
    return a + b;
}

let substract = (a, b) => {
    if(typeof a != 'number' || typeof b != 'number'){
        throw new Error('Invalid Input');
    }
    return a - b;
}

let multiply = (a, b) => {
    if(typeof a != 'number' || typeof b != 'number'){
        throw new Error('Invalid Input');
    }
    return a * b;
}

let divide = (a, b) => {
    if(typeof a != 'number' || typeof b != 'number'){
        throw new Error('Invalid Input');
    }
    if(b == 0){
        throw new Error("Cannot divide by Zero");
    }
    return a / b;
}

module.exports = {
    add,
    substract,
    multiply,
    divide
}