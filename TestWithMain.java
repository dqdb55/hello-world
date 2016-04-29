package org.abc;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestWithMain implements Cloneable {

	public static void main(String args[]) {
		method();
		method2();
	
	}

	private static void method4() {
		List<Integer> list0 = new ArrayList<Integer>();
		System.out.println(list0.getClass());

		List<Integer> list1 = Arrays.asList(1, 2);
		System.out.println(list1.getClass());

		List<Integer> list2 = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
			}
		};
		System.out.println(list2.getClass());
	}

	public void run() {

		Field[] fields = this.getClass().getDeclaredFields();

		// for (Field field : fields) {
		// if (field.isAnnotationPresent(DatabaseField.class)) {
		// DatabaseField databaseField = field
		// .getAnnotation(DatabaseField.class);
		// System.out.println("Field name: " + field.getName()
		// + " | Column name: " + databaseField.columnName());
		// }
		// }
	}

	private static void method3() {
		LinkedList m = new LinkedList();
		Random generator = new Random();
		for (int i = 0; i < 36; i++) {
			m.add(generator.nextInt(20));
		}
		System.out.println(m);
	}

	private static void method2() {
		int a = 5;
		int b = 3;
		int c = a++ + ++b; // c=a+b, a dopiero później b = b+1;
		System.out.println("c=" + c);
		System.out.println("b=" + b);

		c = (a++) + b; // c=a+b, a następnie a = a+1
	}

	private static void method() {
		final int a = 1;
		final TestInterface enum1 = TestEnum.ONE;
		System.out.println(enum1.test());

		String[] str = { "a", "b" };

		System.out.println(str instanceof Object);

		// BigDecimal is immutable
		BigDecimal test = new BigDecimal(0);
		System.out.println(test);
		test = test.add(new BigDecimal(30));
		System.out.println(test);
		test = test.add(new BigDecimal(45));
		System.out.println(test);

		new TestClass().finalMethod();

		// GenericClass<TestClass> genericClass = new GenericClass<TestClass>();
		GenericClass.method("asdf");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
