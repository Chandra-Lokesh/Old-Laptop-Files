var Person = /** @class */ (function () {
    function Person(name, email, age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    Person.prototype.print = function () {
        console.log(this);
    };
    return Person;
}());
var p = new Person('lokesh', 'lokesh@gmail.com', 21);
p.print();
