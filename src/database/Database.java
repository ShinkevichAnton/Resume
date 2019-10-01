package database;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Aspirant;

/**
 * @author User Интерфейс с необходимыми методами
 *
 */
public interface Database {

	boolean add(String surname, String name, String secondname, String dateOfBirth, String address, String phoneNumber,
			String email, String education, String experience, String skills);

	public String search(String surname);

	void clearFieldAspirant();

	void clearFieldHRManager();

	void writeInFile(Aspirant aspirant) throws IOException;

	void OpenFile();

	void ObjectInputStream() throws FileNotFoundException, IOException, ClassNotFoundException;

}
