package prototype;

/**
 * 概述
 * 
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。<br>
 * <br>
 * 适用性<br>
 * 1.当一个系统应该独立于它的产品创建、构成和表示时。
 * 
 * 2.当要实例化的类是在运行时刻指定时，例如，通过动态装载。
 * 
 * 3.为了避免创建一个与产品类层次平行的工厂类层次时。
 * 
 * 4.当一个类的实例只能有几个不同状态组合中的一种时。
 * 
 * 建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。
 * 
 * 参与者<br>
 * 1. Prototype 声明一个克隆自身的接口。
 * 
 * 2. ConcretePrototype 实现一个克隆自身的操作。
 * 
 * 3. Client 让一个原型克隆自身从而创建一个新的对象。
 */
// Prototype
abstract class Prototype implements Cloneable {
	private String _name;

	public void setName(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

// Concrete Prototype
class TrainPrototype extends Prototype {
	public TrainPrototype(String name) {
		setName(name);
	}
}

public class PrototypeTest {
	public static void main(String[] args) {
		Prototype prototype = new TrainPrototype("北方火车");
		Prototype p2 = (Prototype) prototype.clone();
		System.out.println("prototype name: " + prototype.getName());
		System.out.println("p2 name: " + p2.getName());
	}
}
