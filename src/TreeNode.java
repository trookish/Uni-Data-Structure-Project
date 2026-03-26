import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TreeNode<E> {

	int allTimeSum = 0;
	int TimeSum = 0;
	int CostSum = 0;

	static int A_Quantity_choice;

	public int Id;
	public String Name;
	private SinglyLinkedList<TreeNode> children;
	private SinglyLinkedList<Item> items;
	SinglyLinkedList<Item> orders = new SinglyLinkedList<>();
	LinkedQueue<SinglyLinkedList<Item>> OrdersLine = new LinkedQueue<>();

	Scanner input = new Scanner(System.in);

	public TreeNode(int id, String name) {
		this.Id = id;
		this.Name = name;
		this.children = new SinglyLinkedList<TreeNode>();
		this.items = new SinglyLinkedList<Item>();
	}

	public void addChild(TreeNode New) {
		children.addFirst(New);

	}

	public void addItem(Item New) {
		items.addLast(New);

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public boolean Contains(String nood) {
		children.moveToStart();

		for (int i = 0; i < children.size(); i++) {

			if ((children.getValue().Name).equalsIgnoreCase(nood)) {
				return true;
			}
			children.next();

		}

		return false;
	}

	public TreeNode GetNode(String name) {
		children.moveToStart();

		for (int i = 0; i < children.size(); i++) {

			if ((children.getValue().Name).equalsIgnoreCase(name)) {
				return children.getValue();
			}
			children.next();

		}
		return null;
	}

	public void PrintItems() {
		items.print();
	}

	public void PrintOrders() {
		if (orders.isEmpty()) {
			System.out.println("your order is empty\n");
		} else {
			orders.print();
		}

	}

	public Item ItemChoice(int i) {
		items.moveToStart();
		while (items.CurrPos() != items.size()) {
			if (items.getValue().getId() == i) {
				return items.getValue();
			}
			items.next();
		}
		return null;
	}

	public void ItemOrders(TreeNode Root, String name, int Id, int ItemCount) {
		boolean OK = true;
		Root.GetNode(name).items.moveToEnd();
		int Highest = ((Item) Root.GetNode(name).items.getValue()).getId();
		Root.GetNode(name).items.moveToStart();
		int Lowest = ((Item) Root.GetNode(name).items.getValue()).getId();
		do {
			if (Id > Highest) {
				OK = false;
				System.out.println("The ID out of range ! ");
				System.out.println("Enter Value from " + Lowest + " To " + Highest);
				Id = input.nextInt();

			} else if (Id < Lowest) {
				OK = false;
				System.out.println("The ID out of range ! ");
				System.out.println("Enter Value from " + Lowest + " To " + Highest);
				Id = input.nextInt();

			} else {
				OK = true;
			}
		} while (!OK);
		System.out.println(Root.GetNode(name).ItemChoice(Id));
		ItemCount = Root.GetNode(name).ItemChoice(Id).getCount();
		int TempCount = 0;
		do {
			System.out.println("Enter Quantity: ");
			A_Quantity_choice = input.nextInt();

			if (A_Quantity_choice > ItemCount) {
				System.out.println(
						"The Quantity is greater than the stock: " + Root.GetNode(name).ItemChoice(Id).getCount());

			} else if (A_Quantity_choice < 1) {
				System.out.println(
						"The Quantity is less than the stock: " + Root.GetNode(name).ItemChoice(Id).getCount());
			} else {
				TempCount = ItemCount;
				orders.addLast(Root.GetNode(name).ItemChoice(Id));
				System.out.println("Quantity has been added");
				ItemCount -= A_Quantity_choice;
				Root.GetNode(name).ItemChoice(Id).setCount(ItemCount);

			}

		} while ((A_Quantity_choice > TempCount || A_Quantity_choice < 1));

	}

	public SinglyLinkedList<Item> getOrders() {
		return orders;
	}

	public void AddToQueue(SinglyLinkedList<Item> orders) {

		OrdersLine.enqueue(orders);

	}

	public void EmptyQueue() {

		for (int i = 0; i < OrdersLine.length(); i++) {
			int ordernum = i;
			SinglyLinkedList<Item> temp = OrdersLine.dequeue();
			SinglyLinkedList<Item> temp2 = new SinglyLinkedList<>();
			temp2.addLast(temp.getValue());
			System.out.println("Order No." + (i + 1));
			temp.Orderprint(A_Quantity_choice);
			TimeSum = 0;
			CostSum = 0;
			temp.moveToStart();
			temp2.moveToStart();
			for (int j = 0; j < temp.size(); j++) {
				TimeSum += (temp.getValue().getPreperaing_time());
				CostSum += (temp.getValue().getCost()) * (A_Quantity_choice);
				temp.next();
				temp2.next();
			}

			System.out.println("Your Order will be ready in : " + TimeSum + " Min");
			System.out.println("Your Order's cost is " + CostSum + " SAR");
			OrdersLine.enqueue(temp);
			allTimeSum += TimeSum;
			Timer timer = new Timer();

			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("Order No. " + (ordernum + 1) + " is ready !");
				}

			};
			timer.schedule(task, TimeSum * 100);
		}

	}

	public void DeleteItem(int Id) {
		orders.moveToStart();
		for (int i = 0; i < orders.size(); i++) {
			if (Id == orders.getValue().getId()) {
				int x = A_Quantity_choice;
				orders.getValue().setCount(orders.getValue().getCount() + x);
				System.out.println(orders.remove(i));
				System.out.print(" Item Deleted successfully");
				System.out.println();

			}
			orders.next();
		}
	}

	public void DeleteOrder() {
		if (OrdersLine.length() < 1) {
			System.out.println("There is no orders !");
			return;
		}
		System.out.println("Enter The Order ID you want to delete");
		int DeleteOrderByNumber = input.nextInt();
		int CheckCountDelete = 0;
		for (int i = 0; i < OrdersLine.length(); i++) {
			SinglyLinkedList<Item> temp = OrdersLine.dequeue();
			temp.print();
			if (i + 1 != DeleteOrderByNumber) {
				OrdersLine.enqueue(temp);
			} else {
				CheckCountDelete++;
			}
		}
		if (CheckCountDelete >= 1) {
			System.out.println("Order Number " + (CheckCountDelete + 1) + " has been deleted");
		}

	}

	public int TimeSum() {

		if (orders.isEmpty()) {
			System.out.println("List is empty");
			return 0;
		}
		orders.moveToStart();

		int Sum = 0;
		for (int i = 0; i < orders.size(); i++) {
			Sum += (orders.getValue().getPreperaing_time());
			orders.next();
		}

		System.out.println("Your Order will be ready in : " + Sum + " Min");
		return Sum;

	}

	public void NewestOrder() {
		orders = new SinglyLinkedList<>();
	}

	public void PrintChildren() {

		children.print();
	}

	@Override
	public String toString() {
		return "TreeNode [ children= " + children + ", items= " + items + "]";
	}

}