package Command;

import java.util.ArrayList;
import java.util.List;


public class Menu{
	 private ArrayList<MenuItem> MenuItemsList = new ArrayList<MenuItem>();
	  //添加菜单项
	  public void addMenuItem(MenuItem item){
	     this.MenuItemsList.add(item);
	  }
	  //获得菜单项
	  public MenuItem getMenuItem(String itemName){
	     for(int i=0;i<MenuItemsList.size();i++){
	     if(MenuItemsList.get(i).getItemName().equals(itemName)){
	   return MenuItemsList.get(i);
	     }
	     }
	     return null;
	  }
	}