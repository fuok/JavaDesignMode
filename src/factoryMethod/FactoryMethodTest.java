package factoryMethod;

interface Task {
	public void doWork();
}

class FactoryBeijingTask implements Task {
	public void doWork() {
		System.out.println("工厂Beijing的任务：生产北京分公司的部件....");
	}
}

class FactoryGuangzhouTask implements Task {
	public void doWork() {
		System.out.println("工厂Guangzhou的任务：生产广州分公司的部件....");
	}
}

interface ITaskFactory {
	public Task dispatchTask();
}

class FactoryBeijing implements ITaskFactory {
	public Task dispatchTask() {
		return new FactoryBeijingTask();
	}
}

class FactoryGuangzhou implements ITaskFactory {
	public Task dispatchTask() {
		return new FactoryGuangzhouTask();
	}
}

public class FactoryMethodTest {
	public static void main(String[] args) {
		ITaskFactory taskFactory = new FactoryBeijing();
		taskFactory.dispatchTask().doWork();

		taskFactory = new FactoryGuangzhou();
		taskFactory.dispatchTask().doWork();
	}
}