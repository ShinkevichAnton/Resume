package main;

import java.io.IOException;

import controller.Controller;
import database.DatabaseImpI;
import model.AspirantDataBase;

import view.View;

public class Runner {

	public static void main(String[] args) {
		// Создание внешнего вида
		View view = new View();
		// Создание БД соискателей
		AspirantDataBase aspirantDB = new AspirantDataBase();

		// Считывание файл при запуске приложения
		DatabaseImpI databaseImpI = new DatabaseImpI(view, aspirantDB);
		try {
			databaseImpI.ObjectInputStream();
		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}
		// Создание контроллера с последующим вызовом
		Controller controller = new Controller(view, databaseImpI, aspirantDB);
		controller.initController();

	}

}
