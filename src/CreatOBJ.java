import java.io.BufferedReader;
import java.io.FileReader;

public class CreatOBJ {

	static int counter = 2;

	public void CreatOB(TreeNode root) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Items.txt"));
			// Read the file line by line
			String line;

			String LastOBJ = null;
			TreeNode mainRoot = root;

			while ((line = reader.readLine()) != null) {
				// Do something with the line
				if (Character.isLetter(line.charAt(0))) {
					String[] tokens = line.split(" ");
					if (tokens.length > 1) {
						if (!(mainRoot.Contains(tokens[1]))) {
							String obj = tokens[1];
							TreeNode newest = new TreeNode(counter++, obj);
							root.addChild(newest);
						}
						if ((mainRoot.Contains(tokens[1]))) {
							TreeNode newest = new TreeNode(counter++, line);
							LastOBJ = line;
							mainRoot.GetNode(tokens[1]).addChild(newest);
						}
					}
					if (tokens.length <= 1) {
						TreeNode newest = new TreeNode(counter++, line);
						LastOBJ = line;
						mainRoot.addChild(newest);
					}
					if (tokens.length > 1) {
						root = mainRoot.GetNode(tokens[1]);
					}
					if (tokens.length <= 1) {
						root = mainRoot;
					}

				} else {

					String[] tokens = line.split(" ");
					TreeNode temp = root.GetNode(LastOBJ);
					Item Newitem = new Item(Integer.parseInt((tokens[0])), tokens[1], Integer.parseInt((tokens[2])),
							Float.parseFloat(tokens[3]), Integer.parseInt(tokens[4]));

					temp.addItem(Newitem);
				}
			}
			// Close the reader
			reader.close();
		}

		catch (Exception ex) {
			System.out.println(ex);
		}

	}
}