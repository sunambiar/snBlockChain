/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var trailimage;

function fetchLocalities() {
  var catindex = document.getElementById("location_code").selectedIndex;
  var catcode = document.getElementById("location_code")[catindex].value;
  
  var url = "../../ReportFilters?cmd=getLocalities&loc_code=" + escape(catcode);
  //alert("Locality :: " + url);
  if (window.XMLHttpRequest) {
    req = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    req = new ActiveXObject("Microsoft.XMLHTTP");
  }
  req.open("Post", url, true);
  //alert(url);
  req.onreadystatechange = CatCallbackL;
  req.send(null);
}//end function fetchLocalities

function CatCallbackL() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      var locList = req.responseText;
      //alert("Locality :: " + locList);
      setLocalities(locList);
    }//end req.status 
    if (trailimage != null) {
      hidetrail();
    }
  } else {
    if (trailimage != null) {
      showtrail();
    }
  }//end if readystate
}//end function callback

function setLocalities(locList) {
  var cat_obj = document.getElementById("localities");
  cat_obj.length = 0;
  if (locList != '?') {
    //alert("inside");
    var Cat_arr = locList.split(';');
    var i = 0;
    cat_obj.options[0] = new Option("--All--", "-1", false, false);
    for (i = 0; i < Cat_arr.length; i++) {
      var Cat = Cat_arr[i].split(':');
      cat_obj.options[cat_obj.options.length] = new Option(Cat[1], Cat[0], false, false);
    }//end for i
    //  fetchSAPCust();
  } else {//end if ?
    //alert("inside");
    cat_obj.options[0] = new Option("--All--", "-1", false, false);
  } //end if !?
}//end function setLocalities  
function makeNewOption(code, desc) {
  var newItem = document.createElement("option");
  newItem.id = code;
  newItem.name = code;
  newItem.innerHTML = desc;
  newItem.value = code;
  return newItem;
}//end function


 