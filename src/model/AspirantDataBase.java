package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author User Класс содержащий базу соискателей
 *
 */
public class AspirantDataBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Aspirant> aspirantDB = new ArrayList<>();

	/**
	 * @return the aspirantDB
	 */
	public ArrayList<Aspirant> getAspirantDB() {
		return aspirantDB;
	}

	/**
	 * @param aspirantDB
	 *            the aspirantDB to set
	 */
	public void setAspirantDB(ArrayList<Aspirant> aspirantDB) {
		this.aspirantDB = aspirantDB;
	}

}
