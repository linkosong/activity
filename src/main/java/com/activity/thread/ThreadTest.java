/**
 * 
 */
package com.activity.thread;

/**
 * @author 123
 *
 */
public class ThreadTest {
	static Thread a, b;

	public static void main(String[] args) {

		a = new Thread() {
			public synchronized void run() {

				try {

					a.sleep(100);
					System.out.println("2");
					notifyAll();

				} catch (Exception e) {
					System.out.println("A");
					return;
				}

				System.out.println("B");

			}
		};

		b = new Thread() {
			public synchronized void run() {

				try {
					b.wait();
					System.out.println("1");
				} catch (Exception e) {
					System.out.println("C");
					return;
				}
				System.out.println("D");
			}
		};
		a.start();
		b.start();

	}
}
