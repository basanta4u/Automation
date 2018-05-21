package todo.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import todo.model.FilePojo;
import todo.model.PropertyPoJo;

/**
 * Created by dwiba01 on 29/09/2016.
 */

public class JSONPropModel {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(JSONPropModel.class);
	static AtomicInteger seq = new AtomicInteger();

	
	/**
	 * read properties file and convert into JSON file
	 * 
	 * @param propFileName
	 * @param filePath
	 * @param jsonFileName
	 * @return void
	 */
	private static void convertpropsToJson(String propFileName,
			String filePath, String jsonFileName) throws FileNotFoundException,
			IOException {

		ObjectMapper mapper = new ObjectMapper();
		List<PropertyPoJo> listPojo = convertpropsToListPoJo(propFileName,
				filePath);
		listPojo.addAll(readCommentsPropertiesFromFile(filePath, propFileName));
		mapper.writeValue(new File(filePath + "/" + jsonFileName), listPojo);

	}
	
	
	public static void getFileNamesWithProps(String currentWorkingDir)
	{
		
		List<PropertyPoJo> list;
		File directory = new File(currentWorkingDir);
      //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
        	FilePojo filepojo=new FilePojo();
        	
            System.out.println(file.getName());
            if(file.getName().contains(".properties"))
            {filepojo.setFilename(file.getName());
            	try {
					list = convertpropsToJson(file.getName(), currentWorkingDir);
					filepojo.setProperties(list);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        //return list;
	}

	/**
	 * read properties file and convert into JSON file
	 * 
	 * @param propFileName
	 * @param filePath
	 * @param jsonFileName
	 * @return void
	 */
	static List<PropertyPoJo> convertpropsToJson(String propFileName,
			String filePath) throws FileNotFoundException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		List<PropertyPoJo> listPojo = convertpropsToListPoJo(propFileName,
				filePath);
		listPojo.addAll(readCommentsPropertiesFromFile(filePath, propFileName));
		return listPojo;
	}

	/**
	 * read properties file create a List object of type POJO
	 * 
	 * @param filePath
	 * @param filePath
	 * @return List<PropertyPoJo>
	 */
	private static List<PropertyPoJo> convertpropsToListPoJo(String fileName,
			String filePath) throws FileNotFoundException, IOException {

		List<PropertyPoJo> listPojo = new ArrayList<PropertyPoJo>();
		Properties properties = new Properties();
		properties.load(new FileInputStream(filePath + "/" + fileName));

		@SuppressWarnings("rawtypes")
		Enumeration e = properties.propertyNames();
		while (e.hasMoreElements()) {
			PropertyPoJo propspoJo = new PropertyPoJo();
			String key = (String) e.nextElement();
			LOGGER.info(key + " -- " + properties.getProperty(key));
			propspoJo.setId(seq.incrementAndGet());
			propspoJo.setKey(key);
			propspoJo.setValue(properties.getProperty(key).trim());
			propspoJo.setCommentedflag(false);
			listPojo.add(propspoJo);
		}
		return listPojo;
	}

	/**
	 * read JSON changes and update properties file accordingly
	 * 
	 * @param jsonFileName
	 * @param filePath
	 * @param propFileName
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	protected static void convertJsonToProp(String jsonFileName,
			String filePath, String propFileName) throws FileNotFoundException,
			IOException {
		ObjectMapper mapper = new ObjectMapper();

		try {

			Properties properties = new Properties();
			properties.load(new FileInputStream(filePath + "/" + propFileName));

			// Convert JSON string from file to Object
			ArrayList<Object> listPojo = mapper.readValue(new File(filePath
					+ "/" + jsonFileName), ArrayList.class);
			LOGGER.info(listPojo.toString());

			Iterator<Object> litr = listPojo.iterator();

			while (litr.hasNext()) {

				String s = litr.next().toString();

				updateProperties(filePath + "/" + propFileName,
						convertMapToPojo(convertListToMap(s)), properties);

			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * validation logic to modify data in properties file based on JSON changes
	 * 
	 * @param file
	 * @param propspoJo
	 * @param properties
	 * @return PropertyPoJo POJO object
	 */

	private static PropertyPoJo updateProperties(String file,
			PropertyPoJo propspoJo, Properties properties) {
		String s;
		String oldText = propspoJo.getKey() + "="
				+ properties.getProperty(propspoJo.getKey().trim());
		if (!propspoJo.isCommentedflag()) {

			if (properties.getProperty(propspoJo.getKey()) == null) {
				// Add properties
				s = propspoJo.getKey() + "=" + propspoJo.getValue();
				LOGGER.info("File Modify output::new::"
						+ replaceContentInFile(file, "AddLine", s));
			}
			// change value
			else if (!propspoJo.getValue().equalsIgnoreCase(
					properties.getProperty(propspoJo.getKey().trim()))) {

				s = propspoJo.getKey() + "=" + propspoJo.getValue();
				LOGGER.info("New Value sending:::" + s);
				LOGGER.info("File Modify output::update::"
						+ replaceContentInFile(file, oldText, s));

			}

			else if (propspoJo.getValue().equalsIgnoreCase(
					properties.getProperty(propspoJo.getKey().trim()))) {
				LOGGER.info("No change found so no file changes::::"
						+ propspoJo.getKey());
			}
		} else {
			if (!(properties.getProperty(propspoJo.getKey()) == null)) {
				// commented properties
				s = "#" + propspoJo.getKey() + "=" + propspoJo.getValue();
				LOGGER.info("File Modify output::commenst::"
						+ replaceContentInFile(file, oldText, s));
			}
		}

		return propspoJo;
	}

	/**
	 * convert Map to POJO object
	 * 
	 * @param Map
	 *            <String, Object>
	 * @return PropertyPoJo POJO object
	 */

	private static PropertyPoJo convertMapToPojo(Map<String, Object> ppMap) {
		PropertyPoJo pp = new PropertyPoJo();
		pp.setId((Integer) ppMap.get("id"));
		Boolean b = (Boolean) ppMap.get("commentedflag");
		pp.setCommentedflag(b.booleanValue());
		pp.setKey((String) ppMap.get("key"));
		LOGGER.info("MAp value:::" + ppMap.get("value"));
		pp.setValue((String) ppMap.get("value"));

		return pp;
	}

	/**
	 * convert String to a Map
	 * 
	 * @param String
	 * @return Map<String, Object>
	 */
	private static Map<String, Object> convertListToMap(String s) {
		Map<String, Object> mpp = new HashMap<String, Object>();

		LOGGER.info("...>>>>>...." + s);
		String[] splitString = s.trim().substring(1, s.length() - 1).split(",");
		for (String ts : splitString) {
			LOGGER.info("......." + ts);
			String[] splitString2 = ts.split("=");
			try {

				LOGGER.info("value::" + splitString2[0] + "........"
						+ splitString2[1]);
				if (splitString2[0].trim().equalsIgnoreCase("commentedflag")) {
					mpp.put(splitString2[0].trim(),
							new Boolean(splitString2[1]));
				} else if (splitString2[0].trim().equalsIgnoreCase("id")) {
					mpp.put(splitString2[0].trim(),
							new Integer(splitString2[1]));
				} else if (splitString2[0].trim().equalsIgnoreCase("key")) {
					mpp.put(splitString2[0].trim(), splitString2[1]);
				} else if (splitString2[0].trim().equalsIgnoreCase("value"))

				{
					String temp = s.substring(s.lastIndexOf("value=") + 6,
							s.indexOf("key=")).trim();
					mpp.put(splitString2[0].trim(),
							temp.substring(0, temp.length() - 1));

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				mpp.put(splitString2[0].trim(), "");
			}
		}

		return mpp;
	}

	/**
	 * replaces content in file
	 * 
	 * @param file
	 * @param oldText
	 * @param newText
	 * @return boolean
	 */
	public static boolean replaceContentInFile(String file, String oldText,
			String newText) {

		File f = new File(file);

		FileInputStream fs = null;
		InputStreamReader in = null;
		BufferedReader br = null;
		FileWriter fstream = null;
		BufferedWriter outobj = null;
		StringBuffer sb = new StringBuffer();
		String line = null;

		boolean success = false;
		try {
			fs = new FileInputStream(f);
			in = new InputStreamReader(fs);
			br = new BufferedReader(in);

			while ((line = br.readLine()) != null) {

				sb.append(line);
				sb.append(System.getProperty("line.separator"));
			}
			line = sb.toString();
			LOGGER.info("oldText:::" + oldText);
			if (line.contains(oldText)) {

				line = replaceAll(oldText, line, newText);
				LOGGER.info("All occurrences of String " + oldText
						+ " replaced with " + newText
						+ " successfully in file " + file);

			} else {
				if (oldText.equalsIgnoreCase("AddLine")) {
					sb.append(newText);
					sb.append(System.getProperty("line.separator"));
					line = sb.toString();
				}

			}
			fs.close();
			in.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			fstream = new FileWriter(f);
			outobj = new BufferedWriter(fstream);
			LOGGER.info(line);
			outobj.write(line);
			success = true;
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			try {
				outobj.close();
				fstream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	/**
	 * replaces All content in String
	 * 
	 * @param find
	 * @param string
	 * @param replace
	 * @return String
	 */
	private static String replaceAll(String find, String string, String replace) {
		int count = 0;
		int indexOf = 0;
		int startIndex = 0;
		StringBuffer superStr = new StringBuffer();
		while (indexOf > -1) {

			indexOf = string.indexOf(find, indexOf + 1);
			if (indexOf > -1) {
				superStr.append(string.substring(startIndex, (indexOf)));
				superStr.append(replace);
				startIndex = indexOf + find.length();
			}

			LOGGER.info("Index of first:::" + indexOf + "counter:::" + count);
			if (indexOf > -1)
				count++;
		}
		superStr.append(string.substring(startIndex, string.length()));
		return superStr.toString();
	}

	/**
	 * read comment properties from file
	 * 
	 * @param filePath
	 * @param fileName
	 * @return boolean
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static List<PropertyPoJo> readCommentsPropertiesFromFile(
			String filePath, String fileName) throws FileNotFoundException,
			IOException {

		File f = new File(filePath + "/" + fileName);

		FileInputStream fs = null;
		InputStreamReader in = null;
		BufferedReader br = null;
		String line = null;
		List<PropertyPoJo> listPojo = new ArrayList<PropertyPoJo>();
		Properties properties = new Properties();
		properties.load(new FileInputStream(filePath + "/" + fileName));
		try {
			fs = new FileInputStream(f);
			in = new InputStreamReader(fs);
			br = new BufferedReader(in);

			while ((line = br.readLine()) != null) {

				if (line.trim().startsWith("#") && line.contains("=")
						&& (countOccurrences("=", line) == 1)) {
					LOGGER.info("line...." + line);
					String subStr = line.substring(1, line.length());
					String[] splitStr = subStr.split("=");

					String key = splitStr[0];
					LOGGER.info("Found comment key:::" + " -- " + key
							+ "Is present::>>" + properties.getProperty(key));

					if (properties.getProperty(key) == null
							&& (!key.trim().contains(" "))) {
						PropertyPoJo pp = new PropertyPoJo();
						pp.setId(seq.incrementAndGet());
						if (key.startsWith("\""))
							pp.setKey(key.substring(1));
						else
							pp.setKey(key);

						try {
							String value = splitStr[1].trim();
							if (value.contains("\""))
								pp.setValue(value.substring(0,
										value.indexOf("\"")));
							else
								pp.setValue(splitStr[1].trim());
						} catch (ArrayIndexOutOfBoundsException e) {
							pp.setValue("");
						}

						pp.setCommentedflag(true);
						listPojo.add(pp);
					}
				}

			}
			fs.close();
			in.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPojo;
	}

	/**
	 * counter to identify number of Occurrences word found in string
	 * 
	 * @param find
	 * @param string
	 * @return Integer
	 */
	private static int countOccurrences(String find, String string) {
		int count = 0;
		int indexOf = 0;

		while (indexOf > -1) {
			indexOf = string.indexOf(find, indexOf + 1);
			if (indexOf > -1)
				count++;
		}
		return count;
	}

	public static void updateProperty(PropertyPoJo toDo)
			throws FileNotFoundException, IOException {
		String current = new java.io.File(".").getCanonicalPath();
		ObjectMapper mapper = new ObjectMapper();
		Properties properties = new Properties();

		System.out.println("Current working directory " + current);
		properties.load(new FileInputStream(current + "/config" + "/"
				+ "IntroscopeEnterpriseManager.properties"));
		updateProperties(current + "/config" + "/"
				+ "IntroscopeEnterpriseManager.properties", toDo, properties);

	}

}
