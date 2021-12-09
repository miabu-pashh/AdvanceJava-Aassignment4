package com.nagarro.springmvc.readcsv;

import java.io.File;


/**
 * The Class ReadCsv.
 */
public class ReadCsv {

	/**
	 * Read csv from folder.
	 *
	 * @return the file[]
	 */
	/*
	 * Read csv from folder. return the file[]
	 */
	public File[] readCsvFromFolder() {
		final String FILE_PATH = "C:\\Users\\mohammadpasha\\OneDrive - Nagarro\\Documents\\java files\\Asignment5-Advance Java\\Assigment Links\\Assigment Links";
		File file = new File(FILE_PATH);
		File[] SubFiles = file.listFiles();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		;
		return SubFiles;
	}

}
