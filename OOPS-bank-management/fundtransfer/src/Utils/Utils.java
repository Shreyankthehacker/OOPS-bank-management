package Utils;

import java.sql.Timestamp;
import java.util.Random;

public class Utils {
	/* generating a 11 digit acc number
	*/

	public static String generateAccNo() {
	    Random rand = new Random();
	    int part1 = rand.nextInt(654321);  // Generates a random number up to 654320
	    int part2 = rand.nextInt(99999);   // Generates a random number up to 99998
	    return part1 + " " + part2;
	}
	
	/* get time stamp metho*/
	
	public static String getTimestamp() {
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    return timestamp.toString();
	}

	
	
}
