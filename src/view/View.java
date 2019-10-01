package view;

import java.awt.BorderLayout;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {

	/**
	 * 
	 */
	
	// Константы необходиме для настройки
	private static final long serialVersionUID = 1L;
	private static final String FRAME_TITTLE = "Резюме";
	private static final int FRAME_WIDTH = 250;
	private static final int FRAME_HEiGHT = 780;
    
	private static final String ASPIRANT_SURNAME_LABEL_TEXT = "Фамилия";
	private static final String ASPIRANT_NAME_LABEL_TEXT = "Имя";
	private static final String ASPIRANT_SECONDNAME_LABEL_TEXT = "Отчество";
	private static final String ASPIRANT_DATE_OF_BIRTH_LABEL_TEXT = "Дата рождения";
	private static final String ASPIRANT_ADDRESS_LABEL_TEXT = "Адресс(Страна и город)";
	private static final String ASPIRANT_PHONE_NUMBER_LABEL_TEXT = "Номер телефона";
	private static final String ASPIRANT_EMAIL_LABEL_TEXT = "Электронная почта";
	private static final String ASPIRANT_EDUCATION_LABEL_TEXT = "Образование";
	private static final String ASPIRANT_EXPERIENCE_LABEL_TEXT = "Опыт работы";
	private static final String ASPIRANT_SKILLS_LABEL_TEXT = "Навыки и достижения";
	private static final int TEXT_FIELD_SIZE = 20;
	private static final int TEXT_AREA_HEIGHT = 5;
	private static final int TEXT_AREA_WIDTH = 20;
	private static final String SEND_BUTTON_TEXT = "Отпрваить резюме";
	private static final String SEARCH_BY_SURNAME = "Поиск по фамилии:";
	private static final String SEARCH_BUTTON_TEXT = "Найти соискателя";
	private static final String OPEN_FILE_BUTTON_TEXT = "Открыть полную базу соискателей";

	// Текстовые поля и кнопки необходимые для передачи контроллеру
	private JTextField aspirantSurnameField;
	private JTextField aspirantNameField;
	private JTextField aspirantSecondnameField;
	private JTextField aspirantDateOfBirthField;
	private JTextField aspirantAddressField;
	private JTextField aspirantPhoneNumberField;
	private JTextField aspirantEmailField;
	private JTextArea aspirantEducationArea;
	private JTextArea aspirantExperienceArea;
	private JTextArea aspirantSkillsArea;
	private JScrollPane aspirantEducationScroll;
	private JScrollPane aspirantExperienceScroll;
	private JScrollPane aspirantSkillsScroll;
	private JButton sendResumeButton;
	private JTextField hRManagerSearchField;
	private JButton hRManagerSearchButton;
	private JButton hRManagerOpenFileButton;

	/**
	 * Вызов метода создания внешнего вида
	 */
	public View() {
		super(FRAME_TITTLE);
		initView();

	}

	/**
	 * Создание внешнего вида
	 */
	private void initView() {
		add(initPanel());
		setSize(FRAME_WIDTH, FRAME_HEiGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * @return
	 * Создание основной панели
	 */
	private JPanel initPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		Font font = new Font("Verdana", Font.BOLD, 18);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(font);
		tabbedPane.addTab("Для соискателя", initAspirantPanel());
		tabbedPane.addTab("Для HR-менеджеров", initHRManagerPanel());
		mainPanel.add(tabbedPane);

		return mainPanel;
	}

	/**
	 * @return
	 * Создание панели соискателя
	 */
	private JPanel initAspirantPanel() {
		JPanel aspirantPanel = new JPanel();
		JLabel aspirantSurnameLabel = new JLabel(ASPIRANT_SURNAME_LABEL_TEXT);
		aspirantSurnameField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantNameLabel = new JLabel(ASPIRANT_NAME_LABEL_TEXT);
		aspirantNameField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantSecondnameLabel = new JLabel(ASPIRANT_SECONDNAME_LABEL_TEXT);
		aspirantSecondnameField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantDateOfBirthLabel = new JLabel(ASPIRANT_DATE_OF_BIRTH_LABEL_TEXT);
		aspirantDateOfBirthField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantAddressLabel = new JLabel(ASPIRANT_ADDRESS_LABEL_TEXT);
		aspirantAddressField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantPhoneNumberLabel = new JLabel(ASPIRANT_PHONE_NUMBER_LABEL_TEXT);
		aspirantPhoneNumberField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantEmailLabel = new JLabel(ASPIRANT_EMAIL_LABEL_TEXT);
		aspirantEmailField = new JTextField(TEXT_FIELD_SIZE);
		JLabel aspirantEducationLabel = new JLabel(ASPIRANT_EDUCATION_LABEL_TEXT);
		aspirantEducationArea = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		JLabel aspirantExperienceLabel = new JLabel(ASPIRANT_EXPERIENCE_LABEL_TEXT);
		aspirantExperienceArea = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		JLabel aspirantSkillsLabel = new JLabel(ASPIRANT_SKILLS_LABEL_TEXT);
		aspirantSkillsArea = new JTextArea(TEXT_AREA_HEIGHT, TEXT_AREA_WIDTH);
		aspirantEducationScroll = new JScrollPane(aspirantEducationArea);
		aspirantExperienceScroll = new JScrollPane(aspirantExperienceArea);
		aspirantSkillsScroll = new JScrollPane(aspirantSkillsArea);
		sendResumeButton = new JButton(SEND_BUTTON_TEXT);
		aspirantPanel.add(aspirantSurnameLabel);
		aspirantPanel.add(aspirantSurnameField);
		aspirantPanel.add(aspirantNameLabel);
		aspirantPanel.add(aspirantNameField);
		aspirantPanel.add(aspirantSecondnameLabel);
		aspirantPanel.add(aspirantSecondnameField);
		aspirantPanel.add(aspirantDateOfBirthLabel);
		aspirantPanel.add(aspirantDateOfBirthField);
		aspirantPanel.add(aspirantAddressLabel);
		aspirantPanel.add(aspirantAddressField);
		aspirantPanel.add(aspirantPhoneNumberLabel);
		aspirantPanel.add(aspirantPhoneNumberField);
		aspirantPanel.add(aspirantEmailLabel);
		aspirantPanel.add(aspirantEmailField);
		aspirantPanel.add(aspirantEducationLabel);
		aspirantPanel.add(aspirantEducationScroll);
		aspirantPanel.add(aspirantExperienceLabel);
		aspirantPanel.add(aspirantExperienceScroll);
		aspirantPanel.add(aspirantSkillsLabel);
		aspirantPanel.add(aspirantSkillsScroll);
		aspirantPanel.add(sendResumeButton);
		return aspirantPanel;

	}

	/**
	 * @return
	 * Создание панели HR-менеджера
	 */
	private JPanel initHRManagerPanel() {

		JPanel hRManagerPanel = new JPanel();
		JLabel searchLabel = new JLabel(SEARCH_BY_SURNAME);
		hRManagerSearchField = new JTextField(TEXT_FIELD_SIZE);
		hRManagerSearchButton = new JButton(SEARCH_BUTTON_TEXT);
		hRManagerOpenFileButton = new JButton(OPEN_FILE_BUTTON_TEXT);
		JLabel jLabel = new JLabel();
		ImageIcon iconLogo = new ImageIcon("images\\imageForPanel.jpg");
		jLabel.setIcon(iconLogo);
		hRManagerPanel.add(searchLabel);
		hRManagerPanel.add(hRManagerSearchField);
		hRManagerPanel.add(hRManagerSearchButton);
		hRManagerPanel.add(hRManagerOpenFileButton);
		hRManagerPanel.add(jLabel);
		return hRManagerPanel;
	}

	/**
	 * @param view
	 * @param message
	 * @param tittle
	 * Вызов диалогового окна
	 */
	public void showMessage(View view, String message, String tittle) {
		JOptionPane.showMessageDialog(view, message, tittle, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * @return the aspirantSurnameField
	 */
	public JTextField getAspirantSurnameField() {
		return aspirantSurnameField;
	}

	/**
	 * @return the aspirantNameField
	 */
	public JTextField getAspirantNameField() {
		return aspirantNameField;
	}

	/**
	 * @return the aspirantSecondnameField
	 */
	public JTextField getAspirantSecondnameField() {
		return aspirantSecondnameField;
	}

	/**
	 * @return the aspirantDateOfBirthField
	 */
	public JTextField getAspirantDateOfBirthField() {
		return aspirantDateOfBirthField;
	}

	/**
	 * @return the aspirantAddressField
	 */
	public JTextField getAspirantAddressField() {
		return aspirantAddressField;
	}

	/**
	 * @return the aspirantPhoneNumberField
	 */
	public JTextField getAspirantPhoneNumberField() {
		return aspirantPhoneNumberField;
	}

	/**
	 * @return the aspirantEmailField
	 */
	public JTextField getAspirantEmailField() {
		return aspirantEmailField;
	}

	/**
	 * @return the aspirantEducationArea
	 */
	public JTextArea getAspirantEducationArea() {
		return aspirantEducationArea;
	}

	/**
	 * @return the aspirantExperienceArea
	 */
	public JTextArea getAspirantExperienceArea() {
		return aspirantExperienceArea;
	}

	/**
	 * @return the aspirantSkillsArea
	 */
	public JTextArea getAspirantSkillsArea() {
		return aspirantSkillsArea;
	}

	/**
	 * @return the sendResumeButton
	 */
	public JButton getSendResumeButton() {
		return sendResumeButton;
	}

	/**
	 * @return the hRManagerSearchField
	 */
	public JTextField gethRManagerSearchField() {
		return hRManagerSearchField;
	}

	/**
	 * @return the hRManagerSearchButton
	 */
	public JButton gethRManagerSearchButton() {
		return hRManagerSearchButton;
	}

	/**
	 * @return the hRManagerOpenFileButton
	 */
	public JButton gethRManagerOpenFileButton() {
		return hRManagerOpenFileButton;
	}

	/**
	 * @param aspirantSurnameField
	 *            the aspirantSurnameField to set
	 */
	public void setAspirantSurnameField(JTextField aspirantSurnameField) {
		this.aspirantSurnameField = aspirantSurnameField;
	}

	/**
	 * @param aspirantNameField
	 *            the aspirantNameField to set
	 */
	public void setAspirantNameField(JTextField aspirantNameField) {
		this.aspirantNameField = aspirantNameField;
	}

	/**
	 * @param aspirantSecondnameField
	 *            the aspirantSecondnameField to set
	 */
	public void setAspirantSecondnameField(JTextField aspirantSecondnameField) {
		this.aspirantSecondnameField = aspirantSecondnameField;
	}

	/**
	 * @param aspirantDateOfBirthField
	 *            the aspirantDateOfBirthField to set
	 */
	public void setAspirantDateOfBirthField(JTextField aspirantDateOfBirthField) {
		this.aspirantDateOfBirthField = aspirantDateOfBirthField;
	}

	/**
	 * @param aspirantAddressField
	 *            the aspirantAddressField to set
	 */
	public void setAspirantAddressField(JTextField aspirantAddressField) {
		this.aspirantAddressField = aspirantAddressField;
	}

	/**
	 * @param aspirantPhoneNumberField
	 *            the aspirantPhoneNumberField to set
	 */
	public void setAspirantPhoneNumberField(JTextField aspirantPhoneNumberField) {
		this.aspirantPhoneNumberField = aspirantPhoneNumberField;
	}

	/**
	 * @param aspirantEmailField
	 *            the aspirantEmailField to set
	 */
	public void setAspirantEmailField(JTextField aspirantEmailField) {
		this.aspirantEmailField = aspirantEmailField;
	}

	/**
	 * @param aspirantEducationArea
	 *            the aspirantEducationArea to set
	 */
	public void setAspirantEducationArea(JTextArea aspirantEducationArea) {
		this.aspirantEducationArea = aspirantEducationArea;
	}

	/**
	 * @param aspirantExperienceArea
	 *            the aspirantExperienceArea to set
	 */
	public void setAspirantExperienceArea(JTextArea aspirantExperienceArea) {
		this.aspirantExperienceArea = aspirantExperienceArea;
	}

	/**
	 * @param aspirantSkillsArea
	 *            the aspirantSkillsArea to set
	 */
	public void setAspirantSkillsArea(JTextArea aspirantSkillsArea) {
		this.aspirantSkillsArea = aspirantSkillsArea;
	}

	/**
	 * @param sendResumeButton
	 *            the sendResumeButton to set
	 */
	public void setSendResumeButton(JButton sendResumeButton) {
		this.sendResumeButton = sendResumeButton;
	}

	/**
	 * @param hRManagerSearchField
	 *            the hRManagerSearchField to set
	 */
	public void sethRManagerSearchField(JTextField hRManagerSearchField) {
		this.hRManagerSearchField = hRManagerSearchField;
	}

	/**
	 * @param hRManagerSearchButton
	 *            the hRManagerSearchButton to set
	 */
	public void sethRManagerSearchButton(JButton hRManagerSearchButton) {
		this.hRManagerSearchButton = hRManagerSearchButton;
	}

	/**
	 * @param hRManagerOpenFileButton
	 *            the hRManagerOpenFileButton to set
	 */
	public void sethRManagerOpenFileButton(JButton hRManagerOpenFileButton) {
		this.hRManagerOpenFileButton = hRManagerOpenFileButton;
	}

}
