package model;

import java.io.Serializable;

/**
 * @author User
 * Класс Aspirant содержащий поля и их геттеры и сеттеры,а так же конструкор
 * соискателя 
 */
public class Aspirant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String surname;
	private String name;
	private String secondname;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private String email;
	private String education;
	private String experience;
	private String skills;

	public Aspirant(String surname, String name, String secondname, String dateOfBirth, String address,
			String phoneNumber, String email, String education, String experience, String skills) {
		this.surname = surname;
		this.name = name;
		this.secondname = secondname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.education = education;
		this.experience = experience;
		this.skills = skills;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * Переопределение метода toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Соискатель:\r\n");
		builder.append(surname);
		builder.append(" ");
		builder.append(name);
		builder.append(" ");
		builder.append(secondname);
		builder.append("\r\nДата рождения:\r\n");
		builder.append(dateOfBirth);
		builder.append("\r\nАдресс:\r\n");
		builder.append(address);
		builder.append("\r\nНомер телефона:\r\n");
		builder.append(phoneNumber);
		builder.append("\r\nЭл.почта:\r\n");
		builder.append(email);
		builder.append("\r\nОбразование:\r\n");
		builder.append(education.replaceAll("(?!\\r)\\n", "\r\n"));
		builder.append("\r\nОпыт работы:\r\n");
		builder.append(experience.replaceAll("(?!\\r)\\n", "\r\n"));
		builder.append("\r\nНавыки и достижения:\r\n");
		builder.append(skills.replaceAll("(?!\\r)\\n", "\r\n"));
		return builder.toString();
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the secondname
	 */
	public String getSecondname() {
		return secondname;
	}

	/**
	 * @param secondname
	 *            the secondname to set
	 */
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education
	 *            the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}

	/**
	 * @param experience
	 *            the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills
	 *            the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

}
