/**
 * 
 */
package todo.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ca.apm.saas.pojo.MinMaxAvg;
import todo.model.PropertyPoJo;

import com.ca.apm.saas.commom.database.DBQuery;
import com.ca.apm.saas.pojo.Result;
import com.ca.apm.saas.pojo.ResultGroup;

/**
 * @author Basanta Dwibedy
 * 
 */
@Path("todos")
public class TodoResource {

	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PropertyPoJo> getTodosNew() throws IOException {
		List<PropertyPoJo> list = new ArrayList<PropertyPoJo>();
		String currentWorkingDir = new java.io.File( "." ).getCanonicalPath();
		System.out.println("The current working directory is..." +currentWorkingDir);
		JSONPropModel.getFileNamesWithProps(currentWorkingDir+"/config/");
		try {

			list = JSONPropModel.convertpropsToJson(
					"IntroscopeEnterpriseManager.properties", currentWorkingDir+"/config/");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}*/

	@PUT
	@Path("{key}/{value}/{commentedflag}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updatePropTodos(PropertyPoJo todo) throws FileNotFoundException, IOException {
		System.out.println("The key is..."+todo.getKey());
		JSONPropModel.updateProperty(todo);
	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(String productName) {

		String name = productName;
		DBQuery dbQuery=new DBQuery();
		try {

			boolean flag=dbQuery.insertValidationPoint(name);
			System.out.println("Data inserted status::"+flag);
			if(flag)
				return Response.status(201).entity(name).build();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(403).entity(name).build();

	}
	
	/*@GET
	@Path("{filename}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PropertyPoJo> getData(@PathParam("filename") String fileName) throws IOException {
		List<PropertyPoJo> list = new ArrayList<PropertyPoJo>();
		String currentWorkingDir = new java.io.File( "." ).getCanonicalPath();
		try {
			System.out.println(fileName);
			list = JSONPropModel.convertpropsToJson(
					fileName, currentWorkingDir+"/config/");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	} */

	
	@GET
	@Path("/getResult/{i}/{j}/{k}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Result> getresult(@PathParam("i") int i ,@PathParam("j") int j,@PathParam("k") int k) throws IOException {
		List<Result> list = new ArrayList<Result>();
		System.out.println("Value of I & J:::"+i+"::"+j);
		DBQuery dbQuery=new DBQuery();
			try {

				list=dbQuery.getDXIDemoResult(i,j,k);
					
			//list=dbQuery.getDXIDemoResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@GET
	@Path("/getMinResult/{i}/{j}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,Long> getMinResult(@PathParam("i") int i ,@PathParam("j") int j) throws IOException {
		Map<String,Long> map=new HashMap<String,Long>();
		System.out.println("Value of I & J:::"+i+"::"+j);
		DBQuery dbQuery=new DBQuery();
		try {

			map=dbQuery.getMinResult(i,j);

			//list=dbQuery.getDXIDemoResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@GET
	@Path("/getMinMaxAvgResult/{i}/{j}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MinMaxAvg> getMinMaxAvgResult(@PathParam("i") int i ,@PathParam("j") int j) throws IOException {
		List<MinMaxAvg> list = new ArrayList<MinMaxAvg>();
		Map<String,Long> min=new HashMap<String,Long>();
		Map<String,Long> max=new HashMap<String,Long>();
		Map<String,Long> avg=new HashMap<String,Long>();
		System.out.println("Value of I & J:::"+i+"::"+j);
		DBQuery dbQuery=new DBQuery();
		try {

			min=dbQuery.getMinResult(i,j);
			max=dbQuery.getMaxResult(i,j);
			avg=dbQuery.getAvgResult(i,j);

			for (Map.Entry<String,Long> entry : min.entrySet()) {
				MinMaxAvg mma=new MinMaxAvg();
				mma.setValidationPoint(entry.getKey());
				mma.setResponseTimeMin(entry.getValue());
				mma.setResponseTimeMax(max.get(entry.getKey()));
				mma.setResponseTimeAvg(avg.get(entry.getKey()));
				list.add(mma);
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}

			//list=dbQuery.getDXIDemoResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@GET
	@Path("/getMaxResult/{i}/{j}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,Long> getMaxResult(@PathParam("i") int i ,@PathParam("j") int j) throws IOException {
		Map<String,Long> map=new HashMap<String,Long>();
		System.out.println("Value of I & J:::"+i+"::"+j);
		DBQuery dbQuery=new DBQuery();
		try {

			map=dbQuery.getMaxResult(i,j);

			//list=dbQuery.getDXIDemoResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@GET
	@Path("/getAvgResult/{i}/{j}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,Long> getAvgResult(@PathParam("i") int i ,@PathParam("j") int j) throws IOException {
		Map<String,Long> map=new HashMap<String,Long>();
		System.out.println("Value of I & J:::"+i+"::"+j);
		DBQuery dbQuery=new DBQuery();
		try {

			map=dbQuery.getAvgResult(i,j);

			//list=dbQuery.getDXIDemoResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@GET
	@Path("/getResultInGroup/{i}/{j}/{k}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResultGroup> getResultGroup(@PathParam("i") int i ,@PathParam("j") int j,@PathParam("k") int k) {
		List<ResultGroup> list = new ArrayList<ResultGroup>();
		List<Result> tmplist;
		Map<String, Integer> vp;

		DBQuery dbQuery = new DBQuery();

		try {

			vp = dbQuery.getDXIVALIDATIONPOINT();
			tmplist = dbQuery.getDXIDemoResult(i,j,k);

			Iterator<Result> itr = tmplist.iterator();

			for (Map.Entry<String, Integer> entry : vp.entrySet()) {
				itr = tmplist.iterator();
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
				if(responseTime.size()>0) {
					finalRS.setListResponseTime(responseTime);
					finalRS.setListexeTime(exeTime);
					System.out.print("LsitObject" + finalRS);
					list.add(finalRS);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@GET
	@Path("/getAxASysResultInGroup/{i}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResultGroup> getAxASysResultInGroup(@PathParam("i") int i ) {
		List<ResultGroup> list = new ArrayList<ResultGroup>();
		List<Result> tmplist;
		Map<String, Integer> vp;

		DBQuery dbQuery = new DBQuery();

		try {

			vp = dbQuery.getDXIVALIDATIONPOINT();
			tmplist = dbQuery.getDXIDemoResult(i,2,5);

			Iterator<Result> itr = tmplist.iterator();

			for (Map.Entry<String, Integer> entry : vp.entrySet()) {
				itr = tmplist.iterator();
				ResultGroup sysResponseTime = new ResultGroup();
				ResultGroup axaResponseTime = new ResultGroup();
				List<Long> responseTime = new ArrayList<Long>();
				List<Long> responseTimeAxa = new ArrayList<Long>();
				List<String> exeTime = new ArrayList<String>();

				sysResponseTime.setValidationPoint(entry.getKey());
				axaResponseTime.setValidationPoint("AXA-"+entry.getKey());
				while (itr.hasNext()) {
					Result element = (Result) itr.next();
					if (element.getValidationPoint().equalsIgnoreCase(
							entry.getKey())) {
						responseTime.add(element.getResponseTime());
						responseTimeAxa.add(element.getAxaValues());
						exeTime.add(element.getExeTime());

					}

					System.out.print(element + " ");
				}
				if(responseTime.size()>0) {
					sysResponseTime.setListResponseTime(responseTime);
					sysResponseTime.setListexeTime(exeTime);
					axaResponseTime.setListResponseTime(responseTimeAxa);
					axaResponseTime.setListexeTime(exeTime);
					System.out.print("LsitObject" + axaResponseTime);
					list.add(sysResponseTime);
					list.add(axaResponseTime);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
}
