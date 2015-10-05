package singleton;

/** 单例模式，只创建一个实例 */
class SafeSingleton {
	public static class Holder {
		private static SafeSingleton instance = new SafeSingleton();
	}

	private SafeSingleton() {// 单例模式比较适合使用私有构造
		System.out.println("SafeSingleton initialized here....");
	}

	public static SafeSingleton getInstance() {
		return Holder.instance;
	}

}

public class Singleton {
	private static Singleton _instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		synchronized (Singleton.class) {
			if (_instance == null) {
				_instance = new Singleton();
			}
			return _instance;
		}
	}

	/**
	 * 这里SafeSingleton采取了lazy
	 * initialized方式来初始化，只有第一次调用时才会初始化Singleton这个实例。比Singleton类的实现要好一些
	 * 。不加synchronized()的Singleton在多线程环境下，则会出现问题，可能出现同时初始化的情况。
	 */
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());

		System.out.println(SafeSingleton.getInstance());
		System.out.println(SafeSingleton.getInstance());
	}
}
