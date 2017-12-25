/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var trailimage;

function displayRenoFlat() {
  var locIndex = document.getElementById("location_code").selectedIndex;
  var locCode = document.getElementById("location_code")[locIndex].value;
  var localityIndex = document.getElementById("localities").selectedIndex;
  var localityCode = document.getElementById("localities")[localityIndex].value;
  var colIndex = document.getElementById("colonies").selectedIndex;
  var colCode = document.getElementById("colonies")[colIndex].value;

  var url = "../../ReportFilters?cmd=getRenoFlats&loc_code=" + escape(locCode) + "&locality=" + escape(localityCode) + "&col_code=" + escape(colCode);
  //alert("url : " + url);
  if (window.XMLHttpRequest) {
    req = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    req = new ActiveXObject("Microsoft.XMLHTTP");
  }
  req.open("Post", url, true);
  //alert(url);
  req.onreadystatechange = CatCallbackReno;
  req.send(null);
}//end function displayRenoFlat

function CatCallbackReno() {
  if (req.readyState == 4) {
    if (req.status == 200) {
      var renoList = req.responseText;
      setRenoFlat(renoList);
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

function setRenoFlat(renoList) {
  var cat_obj = document.getElementById("renoFlatDet");
  var bcast = document.getElementById("submit");
  cat_obj.style.textAlign = "center";
  //alert(renoList);
  while (cat_obj.rows.length > 1)
    cat_obj.deleteRow(cat_obj.rows.length - 1);
  var i = 0;
  var row = null;
  if (renoList != '?') {
    //alert("inside");
    bcast.style.display = "block";
    var Cat_arr = renoList.split('#$#');
    for (i = 0; i < Cat_arr.length; i++) {//i = Cat_arr.length;
      var Cat = Cat_arr[i].split('$#$');
      row = cat_obj.insertRow(i + 1);
      for (var j = 0; j < Cat.length; j++) {
        row.insertCell(j).innerHTML = Cat[j];
        //col.style.textAlign = "center";
      }
    }//end for i
  } else {//end if ?
    row = cat_obj.insertRow(i + 1);
    var col = row.insertCell(i);
    col.colSpan = "5";
    //$([col]).attr('colspan', 3);
    col.innerHTML = "No Renovated Flat available in this colony to broadcast";
    var bcast = document.getElementById("submit");
    bcast.style.display = "none";
  } //end if !?
}//end function setRenoFlat  



