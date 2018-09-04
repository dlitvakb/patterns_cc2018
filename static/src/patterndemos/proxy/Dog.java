package patterndemos.proxy;

public class Dog {

	private String name;

	public Dog(String name) {
		this.name = name;
	}

	public String bark() {
		return "woof";
	}

	public String getName() {
		return this.name;
	}

}
