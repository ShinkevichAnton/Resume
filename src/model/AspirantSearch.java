package model;

import java.util.ArrayList;

/**
 * @author User
 * Класс для поика соискателей по фамилии
 *
 */
public class AspirantSearch {

	/**
	 * @param surname
	 * @param aspirantDB
	 * @return
	 * Реализация поиска
	 */
	public static ArrayList<Aspirant> foundBySurname(String surname, AspirantDataBase aspirantDB) {
		ArrayList<Aspirant> foundAspirant = new ArrayList<>();
		if (surname != null && aspirantDB.getAspirantDB() != null) {
			for (Aspirant aspirant : aspirantDB.getAspirantDB()) {
				if (aspirant != null) {
					if (surname.equalsIgnoreCase(aspirant.getSurname())) {
						foundAspirant.add(aspirant);
					}
				}
			}
		}
		return foundAspirant;
	}

}
