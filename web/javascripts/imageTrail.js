
/*
Simple Image Trail script- By JavaScriptKit.com
Visit http://www.javascriptkit.com for this script and more
This notice must stay intact
*/

/*
This should be called into the <BODY> tag --- SuN --- 2008-10-18 ---
*/

var trailimage=["../images/ajaxload.gif", 16, 16]; //image path, plus width and height
var offsetfrommouse=[10,-20]; //image x,y offsets from cursor position in pixels. Enter 0,0 for no offset
var displayduration=2; //duration in seconds image should remain visible. 0 for always.

if (document.getElementById || document.all) {
  var snItemDiv = '<div id="trailimageid" style="position:absolute;visibility:hidden;left:0px;top:0px;width:1px;height:1px">';
  snItemDiv += '<img src="'+trailimage[0]+'" border="0" width="'+trailimage[1]+'px" height="'+trailimage[2]+'px">';
  snItemDiv += '<span id="trailimageTextId" style="width:100px;"><font size="1" color="blue">';
  snItemDiv += '<b><i> Please wait...</i></b>';
  snItemDiv += '</font></span></div>';
  //alert('This is activated\n' + snItemDiv);
  document.write(snItemDiv);
} else {
 //alert('This is NOT activated');
}

function gettrailobj(){
if (document.getElementById)
 return document.getElementById("trailimageid").style;
else if (document.all)
 return document.all.trailimagid.style;
}

function truebody(){
return (!window.opera && document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body;
}

function hidetrail(){
gettrailobj().visibility="hidden";
document.onmousemove="";
}

function showtrail(){
gettrailobj().visibility="visible";
document.onmousemove=followmouse;
}

function followmouse(e){
var xcoord=offsetfrommouse[0];
var ycoord=offsetfrommouse[1];
if (typeof e != "undefined"){
  xcoord+=e.pageX;
  ycoord+=e.pageY;
}
else if (typeof window.event !="undefined"){
  xcoord+=truebody().scrollLeft+event.clientX;
  ycoord+=truebody().scrollTop+event.clientY;
}
var docwidth=document.all? truebody().scrollLeft+truebody().clientWidth : pageXOffset+window.innerWidth-15;
var docheight=document.all? Math.max(truebody().scrollHeight, truebody().clientHeight) : Math.max(document.body.offsetHeight, window.innerHeight)
if (xcoord+trailimage[1]+3>docwidth || ycoord+trailimage[2]> docheight)
  gettrailobj().display="none";
else 
  gettrailobj().display="";
gettrailobj().left=xcoord+"px"
gettrailobj().top=ycoord+"px"
}

document.onmousemove=followmouse

if (displayduration>0) {
  setTimeout("hidetrail()", displayduration*1000);
}

