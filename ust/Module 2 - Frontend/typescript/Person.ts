class Person{
    // private name:string;
    // private email:string;
    // private age:number;

    constructor(name, email, age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    print():void{
        console.log(this);
    }

}

let p:Person = new Person('lokesh', 'lokesh@gmail.com', 21);

p.print()