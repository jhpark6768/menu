package menu.DAO;

import menu.Menu;

public interface DatabaseService{
	public boolean insert(Menu m);
	public String getUse(boolean use);
}