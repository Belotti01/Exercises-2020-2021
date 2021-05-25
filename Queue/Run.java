import java.util.*;
import java.net.*;

public class Run {
	public static void main(String[] beepboop) {
		try {
			var queue = new DynQueue<String>();
			var scn = new Scanner(System.in);

			System.out.print("> Queue size: ");
			int size = Integer.parseInt(getInput(scn));
			
			System.out.println("\n> Queue items: ");
			for(int i = 0; i < size; i++) {
				System.out.print("item " + (i+1) + ":\t\t");
				queue.enqueue(getInput(scn));
			}
			scn.close();

			System.out.println(queue.toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			try {
				java.awt.Desktop.getDesktop().browse(new URI("https://youtu.be/dQw4w9WgXcQ"));
			}catch(Exception ex) { }
		}
	}

	private static String getInput(Scanner scn) {
		String input = scn.nextLine();
		return input;
	}
}
