/*-
 * +======================================================================+
 * Dummy
 * ---
 * Copyright (C) 2016 Sfera Labs S.r.l.
 * ---
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * -======================================================================-
 */

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
