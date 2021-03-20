package com.jpmc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp1 = new Employee(1, "Jeff Bezos", 10000.00);
		Employee emp2 = new Employee(2, "Bill Gates", 20000.00);
		Employee emp3 = new Employee(3, "Mark Zuckerberg", 30000.00);
		
		Employee[] arrayOfEmps = { emp1, emp2, emp3 };
		
		Stream.of(arrayOfEmps); // convert to stream using array
		
		List<Employee> empList = Arrays.asList(arrayOfEmps);
		
		EmployeeRepository employeeRepository = new EmployeeRepository(empList);
		
		//empList.stream(); // convert to stream using list
		
//		incrementSalaryForEachEmployee(empList);
//		System.out.println(empList.toString());
		
		//System.out.println(getElementCount(empList));
		
		//sortByName(empList);
		//System.out.println(sortByName(empList).toString());
		
		// distinct()
//		List<Integer> intList = Arrays.asList(2,5,3,2,4,3);
//		List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());
//		
//		System.out.println(distinctIntList.toString());
		
		System.out.println(findMinSalary(empList).toString());
		System.out.println(findMaxSalary(empList).toString());
		System.out.println(joinString(empList));
		
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		
		List<Integer> even = numbers.stream().map(n -> Integer.valueOf(n)).filter(number -> number % 2 ==0).collect(Collectors.toList());
		System.out.println(even);
		
		List<String> bingoNumbers = Arrays.asList("N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");
		
		bingoNumbers.stream()
					.map(String::toUpperCase)
					.filter(n->n.startsWith("G"))
					.sorted()
					.forEach(System.out::println);
		
		Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
		Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
		Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
		System.out.println(concatStream.distinct().peek(System.out::println).count());
				
	}
	
	static Map<String, Integer> myIterator(List<String> inList) {

		
		return inList.stream().filter(str -> str.length() > 5).collect(Collectors.toMap(str -> str, str -> str.length()));
	}
	
	static void incrementSalaryForEachEmployee(List<Employee> empList) {
		
		empList.stream().forEach(e -> e.salaryIncrement(10.0));
	}
	
	public static List<Employee> whenMapIdToEmployees(List<Employee> empList) {
		Integer[] empIds = { 1,2,3};
		
		EmployeeRepository empRepo = new EmployeeRepository(empList);
		
		return Stream.of(empIds).map(empRepo::findById).collect(Collectors.toList());
	}
	
	public static Long getElementCount(List<Employee> empList) {
		return empList.stream().filter(e -> e.getSalary() >= 20000).count();
	}
	
	static List<Employee> sortByName(List<Employee> empList) {
		 return empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
	}
	
	//min()
	static Employee findMinSalary(List<Employee> empList) {
		return empList.stream().min((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);
	}
	
	//max()
	static Employee findMaxSalary(List<Employee> empList) {
		return empList.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
	}
	
	//joining
	static String joinString(List<Employee> empList) {
		return empList.stream().map(Employee::getName).collect(Collectors.joining(", ")).toString();
	}
	
	//toSet
	static Set<String> getSet(List<Employee> empList) {
		return empList.stream().map(Employee::getName).collect(Collectors.toSet());
	}
	
	//toArray
	static void getArray(List<Employee> empList) {
		Employee[] emp = empList.stream().toArray(Employee[]::new);
	}
	
	//toCollection
	static void getVector(List<Employee> empList) {
		Vector<String> empNames = empList.stream().map(Employee::getName).collect(Collectors.toCollection(Vector::new));
	}
	
	//iterate
	static void getIterate() {
		Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
		
		List<Integer> collect = evenNumStream.limit(5).collect(Collectors.toList());
	}

}

class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void salaryIncrement(double inc) {
		this.salary *= inc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}


class EmployeeRepository {
    private List<Employee> empList;
    
    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;
    
    }
    public Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        
        return null;
    }
}
