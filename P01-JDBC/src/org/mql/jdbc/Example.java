package org.mql.jdbc;

public class Example {
	private DataSource ds;
	private DataBase db;

	public Example() {
		config();
		ex04();
	}

	private void config() {
		ds = new MySQLDataSourceJDBC("users");
		db = new DataBase(ds);
	}

	private void ex01() {

		String users[][] = db.select();
		for (int i = 0; i < users.length; i++) {
			for (int j = 0; j < users[i].length; j++) {
				System.out.print("- " + users[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private void ex02() {
		int count = db.delete(6);
		System.out.println(">> " + count);
	}

	private void ex03() {
		int count = db.update(5, "fatiha", "slimani", "sidi yahya ou saad", "062312331");
		System.out.println(">> : " + count);
		ex01();
	}

	private void ex04() {
		int count = db.insert(11, "ali", "slimani", "sidi yahya ou saad", "062312331");
		System.out.println(">> : " + count);
		ex01();
	}

	public static void main(String[] args) {
		new Example();
	}
}
