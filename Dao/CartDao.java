package Dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	void addCartItem(long userId, long menuItemId) throws ParseException;

	ArrayList<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	void removeCartItem(long userId, long menuItemId);

}
