package database;

import java.awt.Desktop;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Date;

import model.Aspirant;
import model.AspirantDataBase;
import model.AspirantSearch;

import view.View;

/**
 * @author User Реализация интерфейса Database
 *
 */
public class DatabaseImpI implements Database {

	// Константы для вывод информации
	private static final String MESSEGE_DIALOG_TITLE = "Информация";
	private static final String INCORRECT_INPUT = "Вы заполнили не все поля";
	private static final String RESUME_SENT = "Ваше резюме отправлено";
	private static final String ASPIRANT_NOT_FOUND = "Такого соискателя в базе не существует";
	private static final String FILE_NOT_FOUND = "База с соискателями еще не создана";

	private View view;
	private AspirantDataBase aspirantDB;

	public DatabaseImpI(View view, AspirantDataBase aspirantDB) {
		this.view = view;
		this.aspirantDB = aspirantDB;
	}

	/*
	 * Метод длбавления соискателей в базу
	 */
	@Override
	public boolean add(String surname, String name, String secondname, String dateOfBirth, String address,
			String phoneNumber, String email, String education, String experience, String skills) {

		if (surname.isEmpty() || name.isEmpty() || secondname.isEmpty() || dateOfBirth.isEmpty() || address.isEmpty()
				|| phoneNumber.isEmpty() || email.isEmpty() || education.isEmpty() || experience.isEmpty()
				|| skills.isEmpty()) {
			view.showMessage(view, INCORRECT_INPUT, MESSEGE_DIALOG_TITLE);
		} else {
			Aspirant aspirant = new Aspirant(surname, name, secondname, dateOfBirth, address, phoneNumber, email,
					education, experience, skills);
			aspirantDB.getAspirantDB().add(aspirant);
			try {
				writeInFile(aspirant);
			} catch (IOException e) {

				e.printStackTrace();
			}
			view.showMessage(view, RESUME_SENT, MESSEGE_DIALOG_TITLE);
			clearFieldAspirant();
		}
		return false;
	}

	/*
	 * Метод для поиска соискателей по фамилии
	 */
	@Override
	public String search(String surname) {
		String massege = "";
		if (surname.isEmpty()) {
			massege = "Вы не заполнили поле ввода";
			view.showMessage(view, INCORRECT_INPUT, MESSEGE_DIALOG_TITLE);

		} else {
			ArrayList<Aspirant> foundAspirant = AspirantSearch.foundBySurname(surname, aspirantDB);
			if (foundAspirant.isEmpty()) {
				massege = "Такого соискателя в базе нет";
				view.showMessage(view, ASPIRANT_NOT_FOUND, MESSEGE_DIALOG_TITLE);
			} else {
				for (Aspirant aspirant : foundAspirant) {
					massege = "Результат поиска";
					view.showMessage(view, aspirant.toString(), MESSEGE_DIALOG_TITLE);
					clearFieldHRManager();
				}
			}
		}
		return massege;
	}

	/*
	 * Очистка текстовых полей соискателя
	 */
	@Override
	public void clearFieldAspirant() {
		view.getAspirantSurnameField().setText("");
		view.getAspirantNameField().setText("");
		view.getAspirantSecondnameField().setText("");
		view.getAspirantDateOfBirthField().setText("");
		view.getAspirantAddressField().setText("");
		view.getAspirantPhoneNumberField().setText("");
		view.getAspirantEmailField().setText("");
		view.getAspirantEducationArea().setText("");
		view.getAspirantExperienceArea().setText("");
		view.getAspirantSkillsArea().setText("");
	}

	/*
	 * Очистка текстовых полей HR-менеджера
	 */
	@Override
	public void clearFieldHRManager() {
		view.gethRManagerSearchField().setText("");

	}

	/*
	 * Запись соискателей в базу(файл)
	 */
	@Override
	public void writeInFile(Aspirant aspirant) throws IOException {

		Date date = new Date();
		FileWriter writer = new FileWriter("InputOutput\\aspirantDB.txt", true);

		try {
			String objectSeparator = "\r\n=========================";
			String lineBreak = "\r\n";
			writer.write(date.toString());
			writer.write(lineBreak);
			writer.write(aspirant.toString());
			writer.write(objectSeparator);

		} finally {
			writer.close();
		}
	}

	/*
	 * Открытие базы соискателей(файл)
	 */
	@Override
	public void OpenFile() {
		Desktop openAspirantFile = null;
		if (Desktop.isDesktopSupported()) {
			openAspirantFile = Desktop.getDesktop();
		}
		if (new File("InputOutput\\aspirantDB.txt").exists()) {
			try {

				openAspirantFile.open(new File("InputOutput\\aspirantDB.txt"));
			} catch (IOException ioException) {

				ioException.printStackTrace();

			}
		} else {
			view.showMessage(view, FILE_NOT_FOUND, MESSEGE_DIALOG_TITLE);
		}

	}

	/*
	 * Загрузка уже существующих соискателей из файла
	 */
	@Override
	public void ObjectInputStream() throws FileNotFoundException, IOException, ClassNotFoundException {
		if (new File("InputOutput\\aspirantInputOutput.out").exists()) {
			ObjectInputStream inputStream = new ObjectInputStream(
					new FileInputStream("InputOutput\\aspirantInputOutput.out"));
			while (true) {
				try {
					aspirantDB.getAspirantDB().add((Aspirant) inputStream.readObject());

				} catch (EOFException e) {
					inputStream.close();
					break;
				}
			}
		}

	}

}
