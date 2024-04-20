package com.tyss.easywhiz.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.FILEPATH);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
