package com.ca.apm.saas.commom.database;

import java.util.Iterator;
import java.util.List;

import com.ca.apm.saas.pojo.ResultGroup;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;

public class LineChart_AWT extends ApplicationFrame {

   public LineChart_AWT( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","Number of Schools",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
   //   Default
      
     TestDB tdb=new TestDB();
      List<ResultGroup> list=tdb.getResultGroup();
      
      Iterator<ResultGroup> itr = list.iterator();
      
      while (itr.hasNext()) {
    	  ResultGroup element = (ResultGroup) itr.next();
    	  List<Long> responseTime = element.getListResponseTime();
			List<String> exeTime = element.getListexeTime();
			final XYSeries addS = new XYSeries(element.getValidationPoint());
			addDataSet(dataset,element.getValidationPoint(),responseTime,exeTime);
			break;
      }
      
    /*  dataset.addValue( 15 , "schools" , "1970" );
      dataset.addValue( 30 , "schools" , "1980" );
      dataset.addValue( 60 , "schools" ,  "1990" );
      dataset.addValue( 120 , "schools" , "2000" );
      dataset.addValue( 240 , "schools" , "2010" );
      dataset.addValue( 300 , "schools" , "2014" );
   */   return dataset;
   }
   
   private void addDataSet(DefaultCategoryDataset dataset,String st,List<Long> responseTime,List<String> exeTime)
   {
	   int i=0;
	   for(;i<responseTime.size();)
	   {
		   dataset.addValue(responseTime.get(i),st,exeTime.get(i));
		   i++;
	   }
	   
	   
	   
   }
   
   private void addDataSet(XYSeries addS,List<Long> responseTime,List<String> exeTime)
   {
	   int i=0;
	   for(;i<responseTime.size();)
	   {
		//   addS.add(responseTime.get(i),exeTime.get(i));
		   i++;
	   }
	   
	   
	   
   }

   
   public static void main( String[ ] args ) {
      LineChart_AWT chart = new LineChart_AWT(
         "School Vs Years" ,
         "Response Time vs Time of Execution");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}
