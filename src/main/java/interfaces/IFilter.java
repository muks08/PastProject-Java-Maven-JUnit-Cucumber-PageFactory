package interfaces;

import classes.*;

import java.util.List;

public interface IFilter {

	default boolean ifSortedAscendingByPrice (List<Product> productList) {
		for(int i = 0; i < productList.size(); i++) {
			return productList.get(0).getPrice() <= productList.get(i + 1).getPrice();
		}
		return true;
	}

	default boolean ifSortedDescendingByPrice (List<Product> productList) {
		for(int i = 0; i < productList.size(); i++) {
			return productList.get(0).getPrice() >= productList.get(i + 1).getPrice();
		}
		return true;
	}
}
