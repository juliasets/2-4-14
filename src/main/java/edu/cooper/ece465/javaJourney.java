package edu.cooper.ece465;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class javaJourney {

	private static Log LOG = LogFactory.getLog(javaJourney.class);

	public static void main(String[] args) {
		System.out.println("starting javaJourney.main()");
		LOG.debug("javaJourney.main() - begin");

		Runner myThread = new Runner();
		System.out.println(myThread);
		myThread.start();

		LOG.debug("javaJourney.main() - end");
		System.out.println("ending javaJourney.main()");
	}
}