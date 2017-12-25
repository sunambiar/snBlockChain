/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var trailimage;

function fetchColonies() {
  //alert("inside col fun");
  var catindex = document.getElementById("localities").selectedIndex;
  var catcode = document.getElementById("localities")[catindex].value;

  var url = "../../ReportFilters?cmd=getColonies&locality=" + escape(catcode);
  //alert("Colony :: "+ url);
  if (window.XMLHttpRequest) {
    req = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    req = new ActiveXObject("Microsoft.XMLHTTP");
  }
  req.open("Post", url, true);
  //alert(url);
  req.onreadystatechange = CatCallbackC;
  req.send(null);
}//end function fetchLocalities

function CatCallbackC() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      var colList = req.responseText;
      //alert("Colony :: "+ colList);
      setColonies(colList);
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

function setColonies(colList) {
  var cat_obj = document.getElementById("colonies");
  cat_obj.length = 0;
  if (colList != '?') {
    //alert("inside");
    var Cat_arr = colList.split(';');
    var i = 0;
    cat_obj.options[0] = new Option("--All--", "-1", false, false);
    for (i = 0; i < Cat_arr.length; i++) {
      //alert(i + "::" + Cat_arr[i]);
      var Cat = Cat_arr[i].split(':');
      //cat_obj.options[cat_obj.options.length] = new Option(Cat[1], Cat[0], false, false);
      cat_obj.options[cat_obj.options.length] = new Option(Cat[1], Cat_arr[i], false, false);//to get both col_name & col_code in select value
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


 