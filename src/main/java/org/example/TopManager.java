package org.example;

//класс TopManager
class TopManager implements Employee {
    private float fixIncome;
    private float bonus;
    Company company;
    TopManager(float fixIncome, Company company) {
        this.fixIncome= fixIncome;
        this.bonus = (float) (fixIncome*1.5);
        this.company = company;
    }
    //гэттер возвращающий фиксированую зарплату топменеджера+бонус в случае если выручка компании
    //более 10000000 и возвращающий просто фикс зарплату в противном случае
    public float getMonthSalary() {
        if(company.getIncome() > 10000000){
            return fixIncome + bonus;
        }
        else{
            return fixIncome;
        }
    }
}
