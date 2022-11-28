package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<String, Integer> diego = new HashMap<>();
		diego.put("Temi", 71);
		diego.put("Meryl", 67);
		diego.put("Doug", 69);
		diego.put("Gabby", 65);
		diego.put("Diego", 74);
		diego.put("Cassie", 64);
		diego.put("Vicky", 67);
		String input = "";
		while (!(input.equals("quit"))) {
			input = in.next();
			if ((diego.get(input))==null) {
				System.out.println("No height exists for this name");
			} else {
				System.out.println(diego.get(input));
			}
		}
	}
}
