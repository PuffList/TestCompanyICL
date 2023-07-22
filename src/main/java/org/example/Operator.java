package org.example;

//класс Operator
class Operator implements Employee {
    private float fixIncome;

    Operator(float fixIncome) {
        this.fixIncome = fixIncome;
    }
    //гэттер возвращающий фиксированную зарплату оператора
    public float getMonthSalary() {
        return fixIncome;
    }
}
