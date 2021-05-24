package Dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartSqlTest {

	CartDao cartDao = new CartSqlImpl();
	
	public static void main(String[] args) throws CartEmptyException, ParseException
	{
		CartSqlTest testObj = new CartSqlTest();
		System.out.println("Cart items:");
		testObj.testAddCartItem();
		testObj.testGetAllCartItems();
		
		System.out.println("Cart items after remove:");
		testObj.testRemoveCartItem();
		testObj.testGetAllCartItems();
	}
	
	public void testRemoveCartItem()
	{
		cartDao.removeCartItem(2, 4);
		cartDao.removeCartItem(2, 3);
	}
	
	 public void testAddCartItem() throws ParseException
	 {
		 cartDao.addCartItem(1, 1);
		 cartDao.addCartItem(1, 2);
		 cartDao.addCartItem(2, 3);
		 cartDao.addCartItem(2, 4);
	 }
	 
	 public void testGetAllCartItems() throws CartEmptyException
	 {
		 ArrayList<MenuItem> item = cartDao.getAllCartItems(2);
		 
		 System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
         for(MenuItem items:item)
			{
         	System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),items.getDateOfLaunch(),items.getCategory(),items.isFreeDelivery()));
			}
	 }

}
