package test;

import static org.junit.Assert.*;

import org.junit.Test;

import database.DatabaseImpI;
import model.Aspirant;
import model.AspirantDataBase;
import view.View;

public class SearchTest {
	private View view = new View();
	private AspirantDataBase aspirantDB = new AspirantDataBase();
	private DatabaseImpI databaseImpI = new DatabaseImpI(view, aspirantDB);
	/**
	 * Сообщение в случае, если тест не пройдет
	 */
	private static final String INCORRECT_INPUT = "Вы не заполнили поле для поиска";
	private static final String ASPIRANT_NOT_FOUND = "Отсутствие совпадений";
	

	/**
	 * Проверяем правильность поиска при не заполненом поле
	 */
	@Test
	public void searchWithEmptySurnameTest() {
		assertEquals(INCORRECT_INPUT, "Вы не заполнили поле ввода", databaseImpI.search(""));
	}

	/**
	 * Проверяем правильность поиска при отсутствии совпадении
	 */
	@Test
	public void serchWithNoMatch() {
		createAspirantTest();
		assertEquals(ASPIRANT_NOT_FOUND, "Такого соискателя в базе нет", databaseImpI.search("incorrectSurname"));
	}
	/**
	 * Проверяем правильность поиска при совпадении
	 */
	public void searchWithAMatch(){
		createAspirantTest();
		String aspirant = aspirantDB.getAspirantDB().get(0).toString();
		assertEquals(ASPIRANT_NOT_FOUND, aspirant, databaseImpI.search("surname"));
	}

	private Aspirant createAspirantTest() {
		Aspirant aspirant = new Aspirant("surname", "name", "secondname", "dateOfBirth", "address", "phoneNumber",
				"email", "education", "experience", "skills");
		return aspirant;
	}

}
