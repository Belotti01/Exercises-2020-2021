import java.io.*;
import java.util.*;

public class FileParser {
	private final static char CATEGORY_DELIMITER = '#';
	private final static char QUESTION_DELIMITER = '?';
	private final static char ANSWER_DELIMITER   = '@';

	public FileParser() { }

	public List<Category> parse(String filePath) throws Exception {
		File f = new File(filePath);
		if(!f.exists()) throw new Exception("File \"" + filePath + "\" doesn't exist.");
		Scanner stream = new Scanner(f);

		String categoryName = "";
		String question = "";
		var cs = new ArrayList<Category>();
		var qs = new ArrayList<Question>();
		var as = new ArrayList<Answer>();

		while(stream.hasNextLine()) {
			var str = stream.nextLine().trim();
			if(str.length() == 0) continue;
			var cmd = str.charAt(0);
			var s = str.substring(1).trim();

			switch(cmd) {
				case CATEGORY_DELIMITER:
					if(qs.size() != 0) {
						cs.add(new Category(categoryName, qs));
						qs = new ArrayList<Question>();
					}
					categoryName = s;
					System.out.println(categoryName);
					break;
				case QUESTION_DELIMITER:
					if(as.size() != 0) {
						qs.add(new Question(question, as));
						as = new ArrayList<Answer>();
					}
					question = s;
					System.out.println(question);
					break;
				case ANSWER_DELIMITER:
					var args = s.split(":", 2);
					System.out.println(args[1]);
					as.add(new Answer(args[1], Integer.parseInt(args[0])));
					break;
				default:
					break;
			}
		}
		cs.add(new Category(categoryName, qs));
		stream.close();
		return cs;
	}
}
