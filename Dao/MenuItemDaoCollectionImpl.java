package Dao;

import java.util.*;

import java.text.ParseException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> list;

	public MenuItemDaoCollectionImpl() throws ParseException {

		if (list == null || list.isEmpty()) {

			list=new ArrayList<MenuItem>();
			list.add(new MenuItem((long) 01, "Sandwich", "Main Course", (float) 99.0, true, true,
					DateUtil.convertToDate("15/03/2017")));
			list.add(new MenuItem((long) 02, "Burger", "Main Course", (float) 129.0, true, false,
					DateUtil.convertToDate("23/12/2017")));
			list.add(new MenuItem((long) 03, "Pizza", "Main Course", (float) 149.0, true, false,
					DateUtil.convertToDate("21/08/2018")));
			list.add(new MenuItem((long) 04, "French Fries", "Starters", (float) 57.0, false, true,
					DateUtil.convertToDate("02/07/2017")));
			list.add(new MenuItem((long) 05, "Chocolate Brownie", "Dessert", (float) 32.0, true, true,
					DateUtil.convertToDate("02/11/2022")));
		}

	}

	@Override
	public ArrayList<MenuItem> getMenuItemListAdmin() {

		return list;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() throws ParseException {

		ArrayList<MenuItem> item = new ArrayList<MenuItem>();
		for (MenuItem l : list) {
			Date d = l.getDateOfLaunch();
			Date tDate = DateUtil.convertToDate("17/05/2021");
			if ((d.before(tDate) || d.equals(tDate)) && (l.isActive())) {
				item.add(l);
			}

		}
		return item;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem x : list) {
			if (x.equals(menuItem)) {
				x.setName(menuItem.getName());
				x.setActive(menuItem.isActive());
				x.setCategory(menuItem.getCategory());
				x.setDateOfLaunch(menuItem.getDateOfLaunch());
				x.setCategory(menuItem.getCategory());
				x.setFreeDelivery(menuItem.isFreeDelivery());

			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem x : list) {
			if (x.getId() == (menuItemId)) {
				return x;
			}
		}

		return null;

	}

}
