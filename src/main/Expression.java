package main;

public class Expression {
    static Number[] array = new Number[2];
    static char operation;

    public Expression (Number z1, Number z2, char operation) {
        this.array[0] = z1;
        this.array[1] = z2;
        this.operation = operation;
    }

    public ComplexNumber process() {

        ComplexNumber z1 = new ComplexNumber(array[0].getValue());
        ComplexNumber z2 = new ComplexNumber(array[1].getValue());
        if (operation == '+')
            return ComplexNumber.add(z1,z2);
        else
            return ComplexNumber.dif(z1,z2);
    }
}