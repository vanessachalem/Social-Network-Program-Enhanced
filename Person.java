package pa07;

/**
 * creates person with a name and age 
 * @author Vanessa
 */
public class Person {
	String name; 
	int age; 
	
	/**
	 * constructor - creates Person object 
	 * @param String name, int age 
	 */
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	/**
	 * returns Person's age 
	 * @return
	 */
	public int getAge(){
		return this.age;
	}
	
	/**
	 * returns Person's name
	 */
	public String getName(){
		return this.name;
	}
}
