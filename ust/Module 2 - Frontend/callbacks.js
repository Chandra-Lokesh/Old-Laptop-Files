function greet(name){
    console.log("Good Morning " + name);
}

setTimeout(() => greet('lokesh'), 3000);
console.log('have a nice day');

// function display(name, callback){
//     callback(name);
// }

// display('Gaurav', greet);

