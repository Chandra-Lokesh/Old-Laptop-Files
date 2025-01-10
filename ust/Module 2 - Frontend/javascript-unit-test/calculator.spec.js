const { add, divide } = require("./calculator")

test('Valid Add Test', () => {
    expect(add(1, 2)).toBe(3)
})

test('Invalid Add Test', () => {
    expect(()=>add('1', '2')).toThrow('Invalid Input')
})

test('Valid Divide Test', () => {
    expect(divide(10, 2)).toBe(5)
})

test('Invalid Divide Test', () =>{
    expect(() => divide(10, 0)).toThrow('Cannot divide by Zero');
})