var w = 150,
	h = 150;
 
var colorscale = d3.scale.category10();
 
//Legend titles
var LegendOptions = ['Female','Male', 'placeholder'];
 
//Data
var d = [ [ {axis:"Topic 0",value:0.009970471598853847}, {axis:"Topic 1",value:0.7382143242502813}, {axis:"Topic 2",value:0.2326430528134934}, {axis:"Topic 3",value:0.004355210749164379}, {axis:"Topic 4",value:0.00533079186940931}, {axis:"Topic 5",value:0.009486148718797898}] ];
 
//Options for the Radar chart, other than default
var mycfg = {
  w: w,
  h: h,
  maxValue: 0.6,
  levels: 5,
  ExtraWidthX: 300
}
 
//Call function to draw the Radar chart
//Will expect that data is in %'s
RadarChart.draw('#chart', d, mycfg);
 
////////////////////////////////////////////
/////////// Initiate legend ////////////////
////////////////////////////////////////////
 
var svg = d3.select('#body')
	.selectAll('svg')
	.append('svg')
	.attr("width", w+300)
	.attr("height", h+300)
 
//Create the title for the legend
var text = svg.append("text")
	.attr("class", "title")
	.attr("x", w+(w/2) )
	.attr("y", h+80)
	.attr("text-anchor", "middle")
	.attr("font-size", "18px")
	.attr("font-weight", 500)
	.text("Tomo 59");
	