package patterndemos.proxy;

public class NamingDogProxy {
	private Dog dog;

	public NamingDogProxy(Dog dog) {
		this.dog = dog;
	}

	public String bark() {
		return this.dog.getName() + " says: " + this.dog.bark();
	}
}
