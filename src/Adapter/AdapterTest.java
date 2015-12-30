package Adapter;

/**
 * 概述<br>
 * 将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。<br>
 * <br>
 * 
 * 适用性
 * 
 * 1.你想使用一个已经存在的类，而它的接口不符合你的需求。
 * 
 * 2.你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类（即那些接口 可能不一定兼容的类）协同工作。
 * 
 * 3.（仅适用于对象Adapter）你想使用一些已经存在的子类，但是不可能对每一个都进行 子类化以匹配它们的接口。对象适配器可以适配它的父类接口。
 * 
 * 参与者
 * 
 * 1.Target 定义Client使用的与特定领域相关的接口。
 * 
 * 2.Client 与符合Target接口的对象协同。
 * 
 * 3.Adaptee 定义一个已经存在的接口，这个接口需要适配。
 * 
 * 4.Adapter 对Adaptee的接口与Target接口进行适配
 */

// Target
interface Target {
	void newCall(String abc);
}

// Adaptee class,最终目的是通过适配器，使这个类的实例能够实现Target接口
class Adaptee {
	public void sampleOpertion(String abc) {
		System.out.println("called for sampleOperation: " + abc);
	}
}

// Adapter类，实现1
class Adapter implements Target {
	Adaptee _a;

	public Adapter(Adaptee a) {
		_a = a;
		System.out.println("This is light adapter for object construction.");
	}

	@Override
	public void newCall(String abc) {
		_a.sampleOpertion(abc);
	}
}

// Adapter类，实现2
class HeavyAdapter extends Adaptee implements Target {
	public HeavyAdapter() {
		System.out.println("this is heavy adapter for class extend.");
	}

	@Override
	public void newCall(String abc) {
		super.sampleOpertion(abc);
	}
}

public class AdapterTest {

	public static void main(String[] args) {
		Target t = new Adapter(new Adaptee());
		t.newCall("新方法");

		t = new HeavyAdapter();
		t.newCall("新方法");
	}
}