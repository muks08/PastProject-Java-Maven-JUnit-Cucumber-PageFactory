package classes;

public class Product {

	private String name;
	private String price;

	public Product() {
		name = "default_name";
		price = "default_price";
	}

	public Product(String name, String price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
