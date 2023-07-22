package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// класс компании(Company)
public class Company {
    private float income;
    static List<Employee> employees = new ArrayList<Employee>();//список сотрудников компании

    public static void main(String[] args) { // добавление сотрудников в компанию и тестировка методов
        Company company = new Company();
        for(int i = 0; i < 180; i++){
            hire(new Operator(15000));
        }
        company.addMeneger();
        for(int i = 0; i < 10; i++){
            hire(new TopManager(70000, company));
        }
        List<Employee> topSalary = company.getTopSalaryStaff(15);
        System.out.println("Ниже перечислены 15 самых высоких зарплат сотрудников в компании :");
        for(Employee employee : topSalary){
            System.out.println(employee.getMonthSalary());
        }
        List<Employee> LowestSalary = company.getLowestSalaryStaff(30);
        System.out.println("Ниже перечислены 30 самых низких зарплат сотрудников в компании :");
        for(Employee employee : LowestSalary){
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("Количество сотрудников компании до увольнения :");
        System.out.println(employees.size());
        for (int i = 0; i < employees.size(); i++) {
            company.fire(employees.get(i));
        }
        System.out.println("Количество сотрудников компании после увольнения :");
        System.out.println(employees.size());
        System.out.println("Ниже перечислены 15 самых высоких зарплат сотрудников после увольнения :");
        List<Employee> topSalaryAfterFiring = company.getTopSalaryStaff(15);
        for (Employee employee : topSalaryAfterFiring) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("Ниже перечислены 30 самых низких зарплат сотрудников после увольнения :");
        List<Employee> LowestSalaryAfterFiring = company.getLowestSalaryStaff(15);
        for (Employee employee : LowestSalaryAfterFiring) {
            System.out.println(employee.getMonthSalary());
        }
    }

    // метод добовляющий менеджеров в компанию и сохрание выручки компании в income
    public void addMeneger(){
        for(int i = 0; i< 80; i++){
            float income = (float) (Math.random()*25000 + 115000);
            this.income += income;
            hire(new Manager(50000, (float) (income*0.05)));
        }
    }

    //метод добавляющтй одного сотрудника в список employees
    public static void hire(Employee employee) {
        employees.add(employee);
    }

    //метод добовляющий список сотрудников в список employees
    public void hireAll(List<Employee> employees) {
        Company.employees.addAll(employees);
    }

    // метод уволняющий сотрудника из списка
    public void fire(Employee employee) {
        employees.remove(employee);
    }

    // гэттер возвращающий выручку компании
    public float getIncome() {
        return income;
    }

    // гэттер возвращающий список указанной длины(зарплаты сотрудников по убыванию)
    public  List<Employee> getTopSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());
        if(count <= employees.size() && count > 0) {
            return employees.subList(0,count);
        }
        else{
            System.out.println("Введённое количество сотрудников не соотвнтствует реальному");
            System.exit(0);
            return employees.subList(0,count);
        }
    }

    // гэттер возвращающий список указанной длины(зарплаты сотрудников по возрастнанию)
    public  List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        if(count <= employees.size() && count > 0) {
            return employees.subList(0,count);
        }
        else{
            System.out.println("Введённое количество сотрудников не соотвнтствует реальному");
            System.exit(0);
            return employees.subList(0,count);
        }
    }
}






