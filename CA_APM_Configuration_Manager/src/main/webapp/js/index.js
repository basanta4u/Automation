// var data = {
//   // A labels array that can contain any sort of values
//   labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
//   // Our series array that contains series objects or in this case series data arrays
//    series: [
//     [5, 2, 4, 2, 0],
//     [2, 5, 4, 2, 0],
//      [7, 9, 10, 2, 0],
//     [17, 29, 20, 2, 10]
//   ]
// };

// Create a new line chart object where as first parameter we pass in a selector
// that is resolving to our chart container element. The Second parameter
// is the actual data object.
//new Chartist.Line('.ct-chart', data);
 

//2nd chart
 //alert("Hi");
function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

 
 var jsonData = $.ajax({
	 url: "http://localhost:8080/AngularJSRestful/rest/todos/getResultInGroup/7/1/19",
    //url: 'https://api.myjson.com/bins/qifk7',
    // url: "https://api.myjson.com/bins/apiun" ,
    // url: "https://api.myjson.com/bins/1fmyzu",
   dataType: 'json',
   
   success: function(response)
        {
          
        var data =  JSON.stringify(response); 
           
var json_obj = $.parseJSON(data);//parse JSON
          //alert(json_obj.length);
   var keys=Object.keys(json_obj);
         // alert(keys[0]);
           
            for (var i in json_obj) 
            {
             //alert(json_obj[i].listResponseTime[0]);
                           //console.log("ddd");
 console.log(json_obj[i]);
             }
    var label=json_obj[0].listexeTime;
          
          var mydata = {type: 'line',
                        data:{
                          labels: label,
                        
                        datasets:[]
                        },
                        options: {
    title: {
      display: true,
      text: 'Component Response Time Graph'
    }
  }
                        
                       };
for (var i = 0; i < json_obj.length; i++)
{
    var key = keys[i];
    //push the key into the dataset array as an object {}
 //alert(json_obj[i].validationPoint ); 
  
  //alert(json_obj[i].listResponseTime);
    mydata.data.datasets.push({label:json_obj[i].validationPoint, data:json_obj[i].listResponseTime, fill:false, borderColor: getRandomColor() });   
                          
}
        
  ////
 
//alert(json_obj[0]); 


    //["2018-04-27 16:46:49.343","date2","dat3","date4","date5","date6","date7"];
var data={
  type: 'line',
  data: {
    labels: label, //[1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
    
    mydata
  },
  options: {
    title: {
      display: true,
      text: 'DIX DEMO Component response Time'
    }
  }
};
  
new Chart(document.getElementById("line-chart"),  mydata);
        }
});

var jsonData1 = $.ajax({
	 //url: "http://localhost:8080/AngularJSRestful/rest/todos/getAxASysResultInGroup/7",
    //url: 'https://api.myjson.com/bins/qifk7',
    // url: "https://api.myjson.com/bins/apiun" ,
     url: "http://localhost:8080/AngularJSRestful/rest/todos/getAxASysResultInGroup/7",
   dataType: 'json',

   success: function(response)
        {

        var data =  JSON.stringify(response);

var json_obj = $.parseJSON(data);//parse JSON
          //alert(json_obj.length);
   var keys=Object.keys(json_obj);
         // alert(keys[0]);

            for (var i in json_obj)
            {
             //alert(json_obj[i].listResponseTime[0]);
                           //console.log("ddd");
 console.log(json_obj[i]);
             }
    var label=json_obj[0].listexeTime;

          var mydata = {type: 'line',
                        data:{
                          labels: label,

                        datasets:[]
                        },
                        options: {
    title: {
      display: true,
      text: 'AXA VS System Response Time Graph'
    }
  }

                       };
for (var i = 0; i < json_obj.length; i++)
{
    var key = keys[i];
    //push the key into the dataset array as an object {}
 //alert(json_obj[i].validationPoint );

  //alert(json_obj[i].listResponseTime);
    mydata.data.datasets.push({label:json_obj[i].validationPoint, data:json_obj[i].listResponseTime, fill:false, borderColor: getRandomColor() });

}

  ////

//alert(json_obj[0]);


    //["2018-04-27 16:46:49.343","date2","dat3","date4","date5","date6","date7"];
var data={
  type: 'line',
  data: {
    labels: label, //[1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],

    mydata
  },
  options: {
    title: {
      display: true,
      text: 'DIX DEMO Component response Time'
    }
  }
};

new Chart(document.getElementById("line-chart2"),  mydata);
        }
});

var tablejsonData = $.ajax({
	url: "http://localhost:8080/AngularJSRestful/rest/todos/getMinMaxAvgResult/2/5",
   dataType: 'json',
   type: "GET",

   success: function(response)
        {

        //var data =  JSON.stringify(response);

//var json_obj = $.parseJSON(data);//parse JSON
     //alert(response);
   //var keys=Object.keys(json_obj);
   var output="<table>";
   output+="<th>Component Name</th><th>Min Millisecond</th><th>Max Millisecond</th><th>Average Millisecond</th>";
   //for (var i in json_obj)
   	for (var i = 0; i < response.length; i++)
   {
   		output+="<tr>";
       output+="<td>" + response[i].validationPoint + "</td>" +
       "<td>" + response[i].responseTimeMin + "</td>"+
       "<td>" + response[i].responseTimeMax + "</td>"+
       "<td>" + response[i].responseTimeAvg + "</td>";

       output+="</tr>";
   }
   output+="</table>";

   $('#tableccn').html(output);
        }
});

var tablejsonData = $.ajax({
	url: "http://localhost:8080/AngularJSRestful/rest/todos/getMinMaxAvgResult/10/19",
   dataType: 'json',
   type: "GET",

   success: function(response)
        {

        //var data =  JSON.stringify(response);

//var json_obj = $.parseJSON(data);//parse JSON
     //alert(response);
   //var keys=Object.keys(json_obj);
   var output="<table>";
   output+="<th>Component Name</th><th>Min Millisecond</th><th>Max Millisecond</th><th>Average Millisecond</th>";
   //for (var i in json_obj)
   	for (var i = 0; i < response.length; i++)
   {
   		output+="<tr>";
       output+="<td>" + response[i].validationPoint + "</td>" +
       "<td>" + response[i].responseTimeMin + "</td>"+
       "<td>" + response[i].responseTimeMax + "</td>"+
       "<td>" + response[i].responseTimeAvg + "</td>";

       output+="</tr>";
   }
   output+="</table>";

   $('#tableccn1').html(output);
        }
});