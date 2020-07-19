var niceChartData = decodeHtml(psc);
var jsonChartData = JSON.parse(niceChartData);


var arrayLength = jsonChartData.length;
var numericdata = [];
var labelData = [];

for(var i =0;i<arrayLength;i++){
	numericdata[i] = jsonChartData[i].stageCount;
	labelData[i] = jsonChartData[i].stage;
}

var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            borderColor: 'rgb(255, 99, 132)',
            data: numericdata
        }]
    },

    // Configuration options go here
    options: {
    	title:{
    		display: true,
    		text: "Project Statuses"
    	}
    }
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}