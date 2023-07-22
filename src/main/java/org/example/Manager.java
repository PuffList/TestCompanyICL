package org.example;

// класс Manager
class Manager implements Employee {
    private float fixIncome;
    private float bonus;
    Manager(float fixIncome, float bonus) {
        this.fixIncome = fixIncome;
        this.bonus = bonus;
    }
    //гэттер возвращающий зарплату сотрудника плюс бонус от продаж
    public float getMonthSalary() {
        return fixIncome + bonus;
    }
}
