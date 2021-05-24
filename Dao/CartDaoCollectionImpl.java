package Dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	
	private HashMap<Long, Cart> userCarts;
	
	CartDaoCollectionImpl(){
		
		if(userCarts==null) {
			userCarts=new HashMap<Long, Cart>();
		}
		
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException {

		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem x=menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId)) {
			ArrayList<MenuItem> item=userCarts.get(userId).getMenuItemList();
			item.add(x);
		}
		else {
			ArrayList<MenuItem> item=new ArrayList<>();
			item.add(x);
			Cart c=new Cart(0,item);
			userCarts.put(userId, c);
			
		}		
			
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		long r=userId;
		System.out.println(r);
		ArrayList<MenuItem> item=userCarts.get(userId).getMenuItemList();
		if(item.isEmpty())
		{
			System.out.println("inside exception");
			throw new CartEmptyException();
		}
		else 
		{
			double price=0;
			for(MenuItem x:item)
			{
				price=price+x.getPrice();
			}
			userCarts.get(userId).setTotal(price);
			return item;
		}
	
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {

		ArrayList<MenuItem> item=userCarts.get(userId).getMenuItemList();
		for(MenuItem x: item) {
			if(x.getId()==menuItemId)
			{
				item.remove(x);
			}
		}
	}
	
}