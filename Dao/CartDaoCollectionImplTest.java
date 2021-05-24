package Dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException, CartEmptyException {

		testAddCartItem();
		//testGetAllCartItems();
		//testRemoveCartItem();
	}

	public static void testAddCartItem() throws ParseException, CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 3);
		cartDao.addCartItem(1, 2);
		cartDao.addCartItem(1, 4);
		// testGetAllCartItems();
	}

	public static void testGetAllCartItems() throws CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		ArrayList<MenuItem> item = cartDao.getAllCartItems(1);
		System.out.println("Cart Items of 1");
		System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n", "Name", "Price", "Active",
				"Date Of Launch", "Category", "Free Delivery"));

		for (MenuItem items : item) {
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n", items.getName(), items.getPrice(),
					items.isActive(), items.getDateOfLaunch(), items.getCategory(), items.isFreeDelivery()));
		}

	}

	public static void testRemoveCartItem() {

		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			cartDao.removeCartItem(1, 2);
			cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}
}
