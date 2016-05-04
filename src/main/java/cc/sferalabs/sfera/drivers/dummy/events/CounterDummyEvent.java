/**
 * 
 */
package cc.sferalabs.sfera.drivers.dummy.events;

import cc.sferalabs.sfera.events.Node;
import cc.sferalabs.sfera.events.NumberEvent;

/**
 * Event triggered every 2 seconds with an increasing value.
 * 
 * @author Giampiero Baggiani
 * 
 * @sfera.event_id counter
 * @sfera.event_val val an integer value
 *
 * @version 1.0.0
 *
 */
public class CounterDummyEvent extends NumberEvent implements DummyEvent {

	/**
	 * 
	 * @param source
	 * @param value
	 */
	public CounterDummyEvent(Node source, Number value) {
		super(source, "counter", value);
	}

}
