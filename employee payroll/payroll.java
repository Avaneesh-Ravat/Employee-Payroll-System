import java.util.*;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }

    public abstract double calSalary();

    @Override
    public String toString(){
        return "Employee : { Name : "+name+"    "+" ID : "+id+"    "+" Salary : "+calSalary()+"}";
    }
    
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourRate = hourRate;
    }

    @Override
    public double calSalary(){
        return hourRate*hoursWorked;
    }
}


class PayRollSystem{
    private ArrayList<Employee> employeeList;
    
    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeRemove = null;
        for(Employee employee : employeeList){
            if(employee.getID()==id){
                employeeRemove = employee;
                break;
            }
        }
        if(employeeRemove != null){
            employeeList.remove(employeeRemove);
        }
    }

    public void DisplayEmp(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }

    public void ParticularSalary(int id){
        for(Employee employee : employeeList){
            if(employee.getID()==id){
                System.out.println(employee);
                break;
            }
        }
    }
}





public class payroll{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PayRollSystem payroll = new PayRollSystem();
        char c = 'y';
        do{
            System.out.println("\nOperations : \n1-> Add employee\n2-> Display employee\n3-> Remove employee\n4-> About a particular employee");
            System.out.println("\nEnter your choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1: System.out.println("\nEnter employee type : \n1-> Full time\n2-> Part Time");
                            int emp = sc.nextInt();
                            if(emp==1){
                                System.out.println("Employee name : ");
                                String empName = sc.next();
                                System.out.println("Employee ID :");
                                int empID = sc.nextInt();
                                System.out.println("Employee monthly salary :");
                                double monthSal = sc.nextDouble();
                                FullTimeEmployee empDetail = new FullTimeEmployee(empName, empID, monthSal);
                                payroll.addEmployee(empDetail);
                            }
                            else if(emp==2){
                                System.out.println("\nEmployee name : ");
                                String empName = sc.next();
                                System.out.println("Employee ID :");
                                int empID = sc.nextInt();
                                System.out.println("Number of hours work : ");
                                int hours = sc.nextInt();
                                System.out.println("Hour rate :");
                                double hourPrice = sc.nextDouble();
                                PartTimeEmployee empDetail = new PartTimeEmployee(empName, empID, hours, hourPrice);
                                payroll.addEmployee(empDetail);
                            }
                            else{
                                System.out.println("\nInvalid choice");
                            }
                        break;

                case 2: System.out.println("\nCurrent employee details are :");
                        payroll.DisplayEmp();
                        break;
                
                case 3: System.out.println("\nEnter the employee ID to remove :");
                        int removeID = sc.nextInt();
                        payroll.removeEmployee(removeID);
                        break;
                
                case 4: System.out.println("\nEnter the employee ID to fetch : ");
                        int fetchID = sc.nextInt();
                        payroll.ParticularSalary(fetchID);
                        break;
                
                default: System.out.println("\nInvalid choice.......");
            }
            System.out.println("\nFor more query / operation press-> y else anything :");
            c = sc.next().charAt(0);
        }while(c=='y');
    }
}