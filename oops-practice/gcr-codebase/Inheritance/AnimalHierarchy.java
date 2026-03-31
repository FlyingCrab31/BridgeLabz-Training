
class Animal {
	String name;
	String age;
	public void makeSound() {
		System.out.println("Animal makes sound");
	}
}
class Dog extends Animal{
    @Override
	public void makeSound() {
		System.out.println("Bow Bow");
	}
	
	
}

class Cat extends Animal{
        @Override
	public void makeSound() {
		System.out.println("Meow");
	}
	
	
}
class Bird extends Animal{
    @Override
	public void makeSound() {
		System.out.println("chirpp chirp");
	}	
}
public class AnimalHierarchy{
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal bird = new Bird();
		animal.makeSound();
		dog.makeSound();
		bird.makeSound();
		cat.makeSound();
	}
}

