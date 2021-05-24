package Dao;

import java.text.ParseException;
import java.util.List;
import com.cognizant.truyum.model.*;

public interface MenuItemDao {

	List<MenuItem> getMenuItemListAdmin();

	List<MenuItem> getMenuItemListCustomer() throws ParseException;

	void modifyMenuItem(MenuItem menuItem);

	MenuItem getMenuItem(long menuItemId);
}
