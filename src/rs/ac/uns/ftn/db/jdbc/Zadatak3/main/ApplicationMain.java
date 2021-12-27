package rs.ac.uns.ftn.db.jdbc.Zadatak3.main;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.ui_handler.MainUIHandler;

import java.sql.SQLException;

public class ApplicationMain {

	public static void main(String[] args) throws SQLException {

		// set application log level
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");

		MainUIHandler mainUIHandler = new MainUIHandler();
		mainUIHandler.handleMainMenu();

	}

}
