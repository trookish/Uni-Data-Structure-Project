
public class Item {

	private int Id;
	private String Name;
	private int preperaing_time;
	private float cost;
	private int count;

	public Item(int id, String name, int preperaing_time, float cost, int count) {
		this.Id = id;
		this.Name = name;
		this.preperaing_time = preperaing_time;
		this.cost = cost;
		this.count = count;
	}

	public Item(int id, String name, int preperaing_time, float cost) {
		this.Id = id;
		this.Name = name;
		this.preperaing_time = preperaing_time;
		this.cost = cost;
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

	public int getPreperaing_time() {
		return preperaing_time;
	}

	public void setPreperaing_time(int preperaing_time) {
		this.preperaing_time = preperaing_time;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Item [Id=" + Id + ", Name=" + Name + ", preperaing_time=" + preperaing_time + ", cost=" + cost
				+ ", count=" + count + "]";
	}

	public String OrdertoString(int A_Quantity_choice) {
		return "Item [Id=" + Id + ", Name=" + Name + ", preperaing_time=" + preperaing_time + ", cost=" + cost + "]";
	}

	public String DrinktoString() {
		return "Item [Id= " + Id + ", Name= " + Name + ", preperaing_time= " + preperaing_time + ", cost= " + cost
				+ "]";
	}

}
