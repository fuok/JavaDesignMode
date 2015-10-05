package abstractFactory;

/**
 * 概述： 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。<br>
 * <br>
 * 适用性：<br>
 * 1.一个系统要独立于它的产品的创建、组合和表示时。
 * 
 * 2.一个系统要由多个产品系列中的一个来配置时。
 * 
 * 3.当你要强调一系列相关的产品对象的设计以便进行联合使用时。
 * 
 * 4.当你提供一个产品类库，而只想显示它们的接口而不是实现时。<br>
 * <br>
 * 参与者：<br>
 * 1.AbstractFactory 声明一个创建抽象产品对象的操作接口。
 * 
 * 2.ConcreteFactory 实现创建具体产品对象的操作。
 * 
 * 3.AbstractProduct 为一类产品对象声明一个接口。
 * 
 * 4.ConcreteProduct 定义一个将被相应的具体工厂创建的产品对象。 实现AbstractProduct接口。
 * 
 * 5.Client 仅使用由AbstractFactory和AbstractProduct类声明的接口
 */
// abstract product
interface ITrainStair {
	void make();
}

interface ITrainBody {
	void make();
}

// concrete product
class NorthTrainStair implements ITrainStair {
	public void make() {
		System.out.println("生产椅子(北方样式)完成......");
	}
}

class NorthTrainBody implements ITrainBody {
	public void make() {
		System.out.println("生产车身(北方样式)完成......");
	}
}

class SouthTrainStair implements ITrainStair {
	public void make() {
		System.out.println("生产椅子(南方样式)完成......");
	}
}

class SouthTrainBody implements ITrainBody {
	public void make() {
		System.out.println("生产车身(南方样式)完成......");
	}
}

// abstract factory
interface ITrainFactory {
	ITrainStair createTrainChair();

	ITrainBody createTrainBody();
}

// Concrete Factory
class NorthFactory implements ITrainFactory {
	public ITrainStair createTrainChair() {
		System.out.println("北车公司, 生产火车椅子零件(from North)...");
		ITrainStair its = new NorthTrainStair();
		return its;
	}

	public ITrainBody createTrainBody() {
		System.out.println("北车公司, 生产火车车身零件(from North)...");
		ITrainBody itb = new NorthTrainBody();
		return itb;
	}
}

class SouthFactory implements ITrainFactory {
	public ITrainStair createTrainChair() {
		System.out.println("南车公司, 生产火车椅子零件(from South)...");
		ITrainStair its = new SouthTrainStair();
		return its;
	}

	public ITrainBody createTrainBody() {
		System.out.println("南车公司, 生产火车车身零件(from South)...");
		ITrainBody itb = new SouthTrainBody();
		return itb;
	}
}

// 当提供一类对象的创建，只想显示它们的接口而不是实现的时候，比较实用
public class AbstractFactoryTest {
	public static void main(String[] args) {
		ITrainFactory itf = new NorthFactory();
		itf.createTrainChair().make();
		itf.createTrainBody().make();

		itf = new SouthFactory();
		itf.createTrainChair().make();
		itf.createTrainBody().make();
	}
}
