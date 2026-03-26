import java.util.Scanner;

/*
 * NAME OF PROJECT DEVELOPERS
 * Turki Almufarrej 444002451
 * Mohammed Ababotain 444001924
 * Turki Alshaalan 444002032
 * Omar Alshuger 443015388*/
public class main {

	public static void main(String[] args) {

		Tree Restaurant = new Tree();
		TreeNode Menu = new TreeNode(1, "Menu");
		Restaurant.addRoot(Menu);
		CreatOBJ sl = new CreatOBJ();
		sl.CreatOB(Menu);
		drink_vending_machine<Item> Drinks = new drink_vending_machine<>();
		Drinks.DrinkAdd();

		System.out.println("---------------------------------------------------");
		System.out.println("-------------Welcome to our restaurant-------------");
		System.out.println("---------------------------------------------------");
		Scanner input = new Scanner(System.in);
		int A_item_choice = 0;
		int A_Quantity_choice = 0;
		int Select = 0;
		int itemCount = 0;
		int VendingOrder = 0;
		int DeleteItem = 0;
		int DeleteOrder = 0;
		do {// variables must be outside the loop so it can be identified within the main
			System.out.println("1-Order from Menu");
			System.out.println("2-View Order");
			System.out.println("3-View Line of Orders(And Execute)");
			System.out.println("4-Delete Item of Orders");
			System.out.println("5-Delete Order By ID");
			System.out.println("6-Order from Vending machine");
			System.out.println("Enter (-1) to exit out of the restraunt");
			System.out.println("Enter (-2) to Close The Order");
			System.out.println("Enter (-3) to check the rest of Count");
			Select = input.nextInt();

			switch (Select) {
			case 1:

				int x = 0;
				do {
					System.out.println("---------------------------------------------------");
					System.out.println("-------------Choose your order-------------");
					System.out.println("---------------------------------------------------");
					System.out.println("Menu:");
					System.out.println("1-Appetizers\n2-Salads\n3-Burgers\n4-Pizzas\n5-Desserts");
					System.out.println("What would you like?:(Enter -1 to exit the menu)");

					x = input.nextInt();
					switch (x) {
					case 1:
						Menu.GetNode("Appetizers").PrintItems();
						System.out.println("Pick an Item By entering ID Number : ");
						A_item_choice = input.nextInt();
						Menu.ItemOrders(Menu, "Appetizers", A_item_choice, 0);

						break;
					case 2:
						Menu.GetNode("Salads").PrintItems();
						System.out.println("Pick an Item By entering ID Number : ");
						A_item_choice = input.nextInt();
						Menu.ItemOrders(Menu, "Salads", A_item_choice, 0);
						break;
					case 3:
						int z = 0;
						do {
							System.out.println("1-Fried Burgers\n2-Griled Burgers");
							System.out.println("What would you like?:(Enter -1 to exit the menu)");
							z = input.nextInt();
							switch (z) {
							case 1:
								Menu.GetNode("Burgers").GetNode("Fried Burgers").PrintItems();
								System.out.println("Pick an Item By entering ID Number : ");
								A_item_choice = input.nextInt();
								Menu.ItemOrders(Menu.GetNode("Burgers"), "Fried Burgers", A_item_choice, 0);
								break;
							case 2:
								Menu.GetNode("Burgers").GetNode("Griled Burgers").PrintItems();
								System.out.println("Pick an Item By entering ID Number : ");
								A_item_choice = input.nextInt();
								Menu.ItemOrders(Menu.GetNode("Burgers"), "Griled Burgers", A_item_choice, 0);
								break;
							case -1:
								break;
							default:
								System.out.println("sorry we dont have that in the menu...");
								break;
							}
						} while (!(z >= 1 && z <= 2) && z != -1);
						break;
					case 4:
						Menu.GetNode("Pizzas").PrintItems();
						System.out.println("Pick an Item By entering ID Number : ");
						A_item_choice = input.nextInt();
						Menu.ItemOrders(Menu, "Pizzas", A_item_choice, 0);
						break;
					case 5:
						Menu.GetNode("Desserts").PrintItems();
						System.out.println("Pick an Item By entering ID Number : ");
						A_item_choice = input.nextInt();
						Menu.ItemOrders(Menu, "Desserts", A_item_choice, 0);
						break;
					case -1:
						break;
					default:
						System.out.println("sorry we dont have that in the menu...");
						break;
					}
				} while (x != -1);
				// (!(x >= 1 && x <= 5) && x != -1)
				break;
			case 6:
				System.out.println("choose your drink\n1-Juice\n2-water\n3-cola");
				VendingOrder = input.nextInt();
				switch (VendingOrder) {
				case 1:
					Menu.orders.addLast(Drinks.DrinkOrder(VendingOrder));
					break;
				case 2:
					Menu.orders.addLast(Drinks.DrinkOrder(VendingOrder));
					break;
				case 3:
					Menu.orders.addLast(Drinks.DrinkOrder(VendingOrder));
					break;

				default:
					System.out.println("Enter a Valid ID");
				}
				break;
			case 2:
				Menu.PrintOrders();

				break;
			case 3:
				Menu.EmptyQueue();
				break;
			case 4:
				Menu.PrintOrders();
				System.out.println("Enter The Item ID you want to delete");
				DeleteItem = input.nextInt();
				Menu.DeleteItem(DeleteItem);
				break;
			case 5:
				Menu.DeleteOrder();
				break;
			case -1:
				System.out.println("Thank you for visting our restraunt!");
				break;
			case -2:
				System.out.println("Enter The New Order : ");
				Menu.AddToQueue(Menu.getOrders());
				Menu.NewestOrder();
				break;
			case -3:
				System.out.println("Appetizers");
				Menu.GetNode("Appetizers").PrintItems();
				System.out.println("\n\n");
				System.out.println("Salads");
				Menu.GetNode("Salads").PrintItems();
				System.out.println("\n\n");
				System.out.println("Fried Burgers");
				Menu.GetNode("Burgers").GetNode("Fried Burgers").PrintItems();
				System.out.println("\n\n");
				System.out.println("Griled Burgers");
				Menu.GetNode("Burgers").GetNode("Griled Burgers").PrintItems();
				System.out.println("\n\n");
				System.out.println("Pizzas");
				Menu.GetNode("Pizzas").PrintItems();
				System.out.println("\n\n");
				System.out.println("Desserts");
				Menu.GetNode("Desserts").PrintItems();
				break;
			}
		} while (Select != -1);
		input.close();
	}

}
