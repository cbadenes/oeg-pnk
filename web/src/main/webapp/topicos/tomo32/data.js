var w = 150,
	h = 150;
 
var colorscale = d3.scale.category10();
 
//Legend titles
var LegendOptions = ['Female','Male', 'placeholder'];
 
//Data
var d = [ [ {axis:"Topic 0",value:0.011730140109177936}, {axis:"Topic 1",value:0.011934230522648064}, {axis:"Topic 2",value:0.9520430397011447}, {axis:"Topic 3",value:0.004698806552290982}, {axis:"Topic 4",value:0.01064869146367102}, {axis:"Topic 5",value:0.008945091651067267}] ];
 
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
	.text("Tomo 32");
	