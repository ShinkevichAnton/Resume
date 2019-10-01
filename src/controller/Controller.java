package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import database.DatabaseImpI;
import model.Aspirant;
import model.AspirantDataBase;
import view.View;

public class Controller {
	// поля для изменения контроллером
	View view;
	DatabaseImpI databaseImpI;
	AspirantDataBase aspirantDB;

	public Controller(View view, DatabaseImpI databaseImpI, AspirantDataBase aspirantDB) {
		this.view = view;
		this.databaseImpI = databaseImpI;
		this.aspirantDB = aspirantDB;
	}

	/**
	 * Запуск контроллера
	 */
	public void initController() {

		view.addWindowListener(new WindowAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.
			 * WindowEvent) Запись в файл при закрытии приложения
			 */
			public void windowClosing(WindowEvent e) {
				try {
					ObjectOutputStream outputStream = new ObjectOutputStream(
							new FileOutputStream("InputOutput\\aspirantInputOutput.out"));
					for (Aspirant aspirant : aspirantDB.getAspirantDB()) {
						outputStream.writeObject(aspirant);

					}
					outputStream.close();
				} catch (IOException ioException) {

					ioException.printStackTrace();
				}

			}
		});
		view.getSendResumeButton().addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) Считывание данных с панели
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				databaseImpI.add(view.getAspirantSurnameField().getText().trim(), view.getAspirantNameField().getText().trim(),
						view.getAspirantSecondnameField().getText().trim(), view.getAspirantDateOfBirthField().getText().trim(),
						view.getAspirantAddressField().getText().trim(), view.getAspirantPhoneNumberField().getText().trim(),
						view.getAspirantEmailField().getText().trim(), view.getAspirantEducationArea().getText(),
						view.getAspirantExperienceArea().getText(), view.getAspirantSkillsArea().getText());

			}
		});
		view.gethRManagerSearchButton().addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) Считывание данный для поиска
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				databaseImpI.search(view.gethRManagerSearchField().getText());

			}
		});
		view.gethRManagerOpenFileButton().addActionListener(new ActionListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * java.awt.event.ActionListener#actionPerformed(java.awt.event.
			 * ActionEvent) Открыти файла с соискателями
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				databaseImpI.OpenFile();

			}
		});
	}

}
