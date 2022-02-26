package program;

import java.io.File;
import java.util.ArrayList;

class RestartIfInactive extends Thread { 
	  private long lastActiveTime;
	  private long timeout;

	  public RestartIfInactive(long timeout) { 
	    this.timeout = timeout;
	    this.active();
	  }

	  // call inside event loop to reset
	  public void active() {
	    this.lastActiveTime = System.currentTimeMillis();
	  }

	  public void run() {
	    while(true) {
	      if (System.currentTimeMillis() - lastActiveTime > this.timeout) {
	    	//System.out.println("stop");
	        System.exit(0);
	      }

	      try {                                                                                                                                           
	        Thread.sleep(1000); // granularity to check
	      } catch(InterruptedException e){System.exit(-1);}
	    }
	  }
}