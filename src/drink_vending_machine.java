import java.io.BufferedReader;
import java.io.FileReader;

public class drink_vending_machine<E> {

	LinkedStack<Item> juice = new LinkedStack<>();
	LinkedStack<Item> cola = new LinkedStack<>();
	LinkedStack<Item> water = new LinkedStack<>();

	public void DrinkAdd() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("Drinks.txt"));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");

				if (tokens[1].equalsIgnoreCase("juice")) {
					Item Juice = new Item(Integer.parseInt((tokens[0])), tokens[1], Integer.parseInt((tokens[2])),
							Float.parseFloat(tokens[3]));

					juice.push(Juice);
				} else if (tokens[1].equalsIgnoreCase("cola")) {
					Item Cola = new Item(Integer.parseInt((tokens[0])), tokens[1], Integer.parseInt((tokens[2])),
							Float.parseFloat(tokens[3]));

					cola.push(Cola);
				} else if (tokens[1].equalsIgnoreCase("water")) {
					Item Water = new Item(Integer.parseInt((tokens[0])), tokens[1], Integer.parseInt((tokens[2])),
							Float.parseFloat(tokens[3]));

					water.push(Water);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

	public Item DrinkOrder(int ID) {

		if (!juice.isEmpty()) {
			if (ID == 1) {
				System.out.println(juice.pop().DrinktoString());
				return juice.pop();

			}
		} else {
			System.out.println("juice is empty");
			return null;

		}

		if (!water.isEmpty()) {
			if (ID == 2) {
				System.out.println(water.pop().DrinktoString());
				return water.pop();
			}
		} else {
			System.out.println("water is empty");
			return null;

		}

		if (!cola.isEmpty()) {
			if (ID == 3) {
				System.out.println(cola.pop().DrinktoString());
				return cola.pop();

			}
		} else {
			System.out.println("water is empty");
			return null;
		}
		System.out.println("Enter a Valid ID");
		return null;

	}
}