package cc.sferalabs.sfera.drivers.dummy;

import cc.sferalabs.sfera.core.Configuration;
import cc.sferalabs.sfera.drivers.Driver;
import cc.sferalabs.sfera.drivers.dummy.events.CounterDummyEvent;
import cc.sferalabs.sfera.events.Bus;

/**
 *
 * @author Giampiero Baggiani
 *
 * @version 1.0.0
 *
 */
public class Dummy extends Driver {

	private long counter;

	public Dummy(String id) {
		super(id);
	}

	@Override
	protected boolean onInit(Configuration config) throws InterruptedException {
		counter = 0;
		return true;
	}

	@Override
	protected boolean loop() throws InterruptedException {
		Bus.post(new CounterDummyEvent(this, counter++));
		Thread.sleep(2000);
		return true;
	}

	@Override
	protected void onQuit() {
	}

	/**
	 * Sets the counter to the specified value.
	 * 
	 * @param val
	 *            the value to set
	 */
	public void setCounter(long val) {
		this.counter = val;
	}

}
