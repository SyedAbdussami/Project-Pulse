var chartDataStr=chartDataRaw.replace(/&quot;/g,'"');
var chartJSONArray=JSON.parse(chartDataStr);

var arrLength=chartJSONArray.length;
var valueData=[];
var labelData=[];

for(var i=0;i<arrLength;i++){
valueData[i]=chartJSONArray[i].value;
labelData[i]=chartJSONArray[i].label;
}

// For a pie chart
var myPieChart = new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
   // The data for our dataset
       data: {
//           labels: ['January', 'February', 'March'],
           labels:labelData,
           datasets: [{
               label: 'My First dataset',
               backgroundColor: ['rgba(39,12,8,255)','rgba(253,224,168,255)','rgba(184,220,228,255)'],
               data: valueData
           }]
       },

       // Configuration options go here
       options: {
       title:{
       display:true,
       text:'Project Statuses'
       }}
   });
//[{"value":1,"label":"COMPLETED"},{"value":2,"label":"INPROGRESS"},{}]
//function decodeHtml(html){
//            let txt=document.createElement("textarea");
//            txt.innerHTML = html;
//return txt.value;
//}