package Dao;
import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException{

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		
	}
	public static void testGetMenuItemListAdmin() {
		
		MenuItemDao menuItemDao=null;
		try{
			menuItemDao=new MenuItemDaoCollectionImpl();
			ArrayList<MenuItem> list=new ArrayList<MenuItem>(menuItemDao.getMenuItemListAdmin());
			System.out.println("Menu item list for admin"); 
            System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
            for(MenuItem items:list)
			{
            	System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),items.getDateOfLaunch(),items.getCategory(),items.isFreeDelivery()));
			}
		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    		}
			
		}
		
	public static void  testGetMenuItemListCustomer() {
		
		MenuItemDao menuItemDao=null;
		try {
			menuItemDao=new MenuItemDaoCollectionImpl();
			ArrayList<MenuItem> list=new ArrayList<MenuItem>(menuItemDao.getMenuItemListCustomer());
			System.out.println("Menu item list for customer");
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n", "Name", "Price", "Active",
					"Date Of Launch", "Category", "Free Delivery"));

			for (MenuItem items : list) {
				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n", items.getName(), items.getPrice(),
						items.isActive(), items.getDateOfLaunch(), items.getCategory(), items.isFreeDelivery()));
			}
		}
            catch(Exception e)
    		{
    			e.printStackTrace();
    		}
			
	}
	
	public static void testModifyMenuItem() throws ParseException {
		
		MenuItem item =new MenuItem((long) 04, "French Fries","Starters", (float) 57.0, false,true,DateUtil.convertToDate("02/07/2017"));
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(item);
		MenuItem items=menuItemDao.getMenuItem(item.getId());
		System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),items.getDateOfLaunch(),items.getCategory(),items.isFreeDelivery()));
	}
			
	}


