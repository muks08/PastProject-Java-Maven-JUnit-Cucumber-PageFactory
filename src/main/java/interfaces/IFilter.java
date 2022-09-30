package interfaces;

import classes.*;

import java.util.List;

public interface IFilter {

	default boolean ifSortedAscendingByPrice (List<Product> productList) {
		for(int i = 0; i < productList.size()-1; i++) {
			System.out.println(productList.get(i).getPrice() + " " + productList.get(i+1).getPrice());
			if (productList.get(i).getPrice() <= productList.get(i + 1).getPrice()) continue;
			else return false;
		}
		return true;
	}

	default boolean ifSortedDescendingByPrice (List<Product> productList) {
		for(int i = 0; i < productList.size()-1; i++) {
			System.out.println(productList.get(i).getPrice() + " " + productList.get(i+1).getPrice());
			if (productList.get(i).getPrice() >= productList.get(i + 1).getPrice()) continue;
			else return false;
		}
		return true;
	}
}
