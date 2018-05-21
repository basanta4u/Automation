package com.ca.apm.saas.commom.database;

import com.ca.apm.saas.pojo.Result;
import com.ca.apm.saas.pojo.ResultGroup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestDB dbQuery=new TestDB();
		DBQuery dbQuery1 = new DBQuery();
		//dbQuery.testmethod();
		//System.out.println(dbQuery.getRangeDateTimeStamp(8));
		//System.out.println(dbQuery1.getMaxResult(1,8));
		System.out.println(dbQuery1.insertValidationPoint("TestData"));
	}

	private void testmethod()
	{
		String[] str_array = {"item1","item2","item3"};
		System.out.println(str_array.length+str_array[0]+str_array[1]+str_array[2]);
		List<String> list = new ArrayList<String>(Arrays.asList(str_array));
		list.remove("item2");
		if(list.size()>0) {
			Iterator<String> itr1 = list.iterator();
			while (itr1.hasNext()) {
				System.out.println("..." + itr1.next() + "..." + false + "..."
						+ "-1");
			}
		}
		str_array = list.toArray(new String[0]);
		System.out.println(str_array.length+str_array[0]+str_array[1]);
	}

	private  java.sql.Timestamp getRangeDateTimeStamp(int days) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss aa");
		java.util.Date today = new java.util.Date();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -days);
		System.out.println("Date = "+ cal.getTime());

		System.out.println("Current time:-------:"+dateFormat.format(today.getTime()));
		return new java.sql.Timestamp(today.getTime());

	}
	
	public List<ResultGroup> getResultGroup() {
		List<ResultGroup> list = new ArrayList<ResultGroup>();
		List<Result> tmplist;
		Map<String, Integer> vp;

		DBQuery dbQuery = new DBQuery();

		try {

			vp = dbQuery.getDXIVALIDATIONPOINT();
			tmplist = dbQuery.getDXIDemoResult(7,5,8);

			Iterator<Result> itr = tmplist.iterator();

			for (Map.Entry<String, Integer> entry : vp.entrySet()) {
				ResultGroup finalRS = new ResultGroup();
				List<Long> responseTime = new ArrayList<Long>();
				List<String> exeTime = new ArrayList<String>();

				finalRS.setValidationPoint(entry.getKey());
				while (itr.hasNext()) {
					Result element = (Result) itr.next();
					if (element.getValidationPoint().equalsIgnoreCase(
							entry.getKey())) {
						responseTime.add(element.getResponseTime());
						exeTime.add(element.getExeTime());

					}

					System.out.print(element + " ");
				}
				finalRS.setListResponseTime(responseTime);
				finalRS.setListexeTime(exeTime);
				System.out.print("LsitObject" + finalRS);
				list.add(finalRS);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
    
}
