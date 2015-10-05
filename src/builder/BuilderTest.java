package builder;

/**
 * 概述： 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。<br>
 * <br>
 * 适用性<br>
 * 1.当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时。
 * 
 * 2.当构造过程必须允许被构造的对象有不同的表示时。<br>
 * <br>
 * 参与者 <br>
 * 1.Builder 为创建一个Product对象的各个部件指定抽象接口。
 * 
 * 2.ConcreteBuilder 实现Builder的接口以构造和装配该产品的各个部件。 定义并明确它所创建的表示。 提供一个检索产品的接口。
 * 
 * 3.Director 构造一个使用Builder接口的对象。
 * 
 * 4.Product 表示被构造的复杂对象。ConcreteBuilder创建该产品的内部表示并定义它的装配过程。
 * 包含定义组成部件的类，包括将这些部件装配成最终产品的接口。
 */
abstract class Train {
	private String _body;
	private String _head;
	private String _tail;

	public String getBody() {
		return _body;
	}

	public String getHead() {
		return _head;
	}

	public String getTail() {
		return _tail;
	}

	public void setBody(String body) {
		_body = body;
	}

	public void setHead(String head) {
		_head = head;
	}

	public void setTail(String tail) {
		_tail = tail;
	}
}

class NorthTrain extends Train {
	public NorthTrain() {
		System.out.println("北方火车");
	}
}

// Builder
interface ITrainBuilder {
	void buildBody();

	void buildHead();

	void buildTail();

	Train buildTrain();
}

// Concrete Builder
class TrainBuilder implements ITrainBuilder {
	Train train;

	public TrainBuilder() {
		train = new NorthTrain();
	}

	public void buildBody() {
		train.setBody("制造车身...");
	}

	public void buildHead() {
		train.setHead("制造车头...");
	}

	public void buildTail() {
		train.setTail("制造车尾...");
	}

	public Train buildTrain() {
		return train;
	}
}

// Director
class TrainDirector {
	public Train constructTrain(ITrainBuilder itb) {
		itb.buildBody();
		itb.buildHead();
		itb.buildTail();
		return itb.buildTrain();
	}
}

public class BuilderTest {
	public static void main(String[] args) {
		TrainDirector td = new TrainDirector();
		Train train = td.constructTrain(new TrainBuilder());
		System.out.println(train.getBody());
		System.out.println(train.getHead());
		System.out.println(train.getTail());
	}
}