/* 
    Document   : DestinMaster
    Created on : Jan 21, 2015, 11:48:28 AM
    Author     : 00504623
*/

function fetchFlats() {
  //alert("inside fun flat");
  document.getElementById("addRow").style.display = "inherit";
  var localityCode = document.getElementById("localities").value;
  //alert(localityCode);
  var colCode = document.getElementById("colonies").value;
  
  var url = "../../ReportFilters?cmd=getFlats&localityCode=" + escape(localityCode)+"&colCode=" + escape(colCode);
  //alert("url :: " + url);
  if (window.XMLHttpRequest) {//alert("inside ");
    req = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    req = new ActiveXObject("Microsoft.XMLHTTP");
  }
  req.open("Post", url, true);
  //alert(url);
  req.onreadystatechange = CatCallbackF;
  req.send(null);
}//end function fetchFlats

function CatCallbackF() {
  //alert("inside");
  if (req.readyState == 4) {
    if (req.status == 200) {
      var flatList = req.responseText;
      //alert("Flat :: " + flatList);
      displayFlats(flatList);
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

function displayFlats(flatList) {
  var cat_obj = document.getElementById("add_flat");
  cat_obj.style.textAlign = "center";
  //cat_obj.style.border = "1";
  //var totClmn = 10;
  //cat_obj.length = 0; 
  while(cat_obj.rows.length>0) 
    cat_obj.deleteRow(cat_obj.rows.length-1); 
    
  if (flatList !== '?') {
    var col_arr=["HOUSE_NO", "RESID_TCODE","RESID_SCODE", "BUILDING_NM","STATUS","AREA_SQFT","TOTAL_OCCUPANTS","CURRENT_OCCUPANTS","MIN_GRADE_CODE","RENOVATED_FLAG"];
    var Cat_arr = flatList.split(';');
    var i;
    //var tbl_head = cat_obj.createTHead();
    var row_head = cat_obj.insertRow(0);
    for(i=0;i<col_arr.length;i++){
      var col_head = row_head.insertCell(i).innerHTML="<b>"+col_arr[i]+"</b>";
    }
    for (i = 0; i < Cat_arr.length; i++) {//i = Cat_arr.length;
      var Cat = Cat_arr[i].split(':'); 
      var row = cat_obj.insertRow(i+1);
      for (var j = 1; j < Cat.length; j++) {
          var col = row.insertCell(j-1).innerHTML=Cat[j];
          //col.style.textAlign = "center";
    }
      //var col_1 = row.insertCell(0);col_1.innerHTML =Cat[0];
      //cat_obj.options[cat_obj.options.length] = new Option(Cat[1], Cat[0], false, false);
     // var taBLE = document.getElementById("myTable");
      /*var col_1 = row.insertCell(0);var col_2 = row.insertCell(1);var col_3 = row.insertCell(2);var col_4 = row.insertCell(3);
      var col_5 = row.insertCell(4);var col_6 = row.insertCell(5);var col_7 = row.insertCell(6);var col_8 = row.insertCell(7);
      var col_9 = row.insertCell(8);var col_10 = row.insertCell(9);var col_11 = row.insertCell(10);var col_12 = row.insertCell(11);
      var col_13 = row.insertCell(12);
      col_1.innerHTML = "NEW CELL1";
      col_2.innerHTML = "NEW CELL2";
      /*cat_obj.innerHTML+="<tr><th>HOUSE_NO</th></tr>";
      cat_obj.innerHTML+="<tr>"+"<td></td>"
+"</tr>";*/

    
    }//end for i
    //  fetchSAPCust();
  } else {//end if ?
    alert("No Record Found !");
    //cat_obj.options[0] = new Option("--All--", "-1", false, false);
  } //end if !?
  }
  

  
function makeNewOption(code, desc) {
  var newItem = document.createElement("option");
  newItem.id = code;
  newItem.name = code;
  newItem.innerHTML = desc;
  newItem.value = code;
  return newItem;
}//end function


function displayColonies(){
  document.getElementById("addRow").style.display = "inherit";
  var localityCode = document.getElementById("localities").value;
  //var colCode = document.getElementById("colonies").value;
  
  var url = "../../ReportFilters?cmd=getColonyDet&localityCode=" + escape(localityCode);//+"&colCode=" + escape(colCode);
  //alert("url :: " + url);
  if (window.XMLHttpRequest) {//alert("inside ");
    req = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    req = new ActiveXObject("Microsoft.XMLHTTP");
  }
  req.open("Post", url, true);
  //alert(url);
  req.onreadystatechange = CatCallbackCol;
  req.send(null);
}//end function fetchFlats

function CatCallbackCol() {
  //alert("inside");
  if (req.readyState == 4) {
    if (req.status == 200) {
      var colList = req.responseText;
      //alert("Flat :: " + flatList);
      displayCol(colList);
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

function displayCol(colList) {
  var cat_obj = document.getElementById("dis_colony");
  cat_obj.style.textAlign = "center";
  //cat_obj.style.border = "1";
  var totClmn = 6;
  //cat_obj.length = 0; 
  while(cat_obj.rows.length>0) 
    cat_obj.deleteRow(cat_obj.rows.length-1); 
   
 
  /*var locality = document.getElementById("localities").value;
   alert(locality);
  var locarr = locality.split(':');
  var loc_name = locarr[1];
  //alert(loc_name);
  */
   if (colList !== '?') {
    var col_arr=["COL_NAME", "LOCALITY_NAME" ,"ADDRESS1", "ADDRESS2","PIN_CODE","ADMIN_OFFICER"];
    var Cat_arr = colList.split(';');
    var i;
    //var tbl_head = cat_obj.createTHead();
    var row_head = cat_obj.insertRow(0);
    for(i=0;i<totClmn;i++){
      var col_head = row_head.insertCell(i).innerHTML="<b>"+col_arr[i]+"</b>";
    }
    for (i = 1; i <= Cat_arr.length; i++) {//i = Cat_arr.length;
      var Cat = Cat_arr[i-1].split(':'); 
      var row = cat_obj.insertRow(i);
      for (j = 1; j <= Cat.length; j++) {
        /*  if(j==2)
              row.insertCell(j-1).innerHTML=loc_name;
            else
         */ var col = row.insertCell(j-1).innerHTML=Cat[j-1];
          //col.style.textAlign = "center";
    }
      //var col_1 = row.insertCell(0);col_1.innerHTML =Cat[0];
      //cat_obj.options[cat_obj.options.length] = new Option(Cat[1], Cat[0], false, false);
     // var taBLE = document.getElementById("myTable");
      /*var col_1 = row.insertCell(0);var col_2 = row.insertCell(1);var col_3 = row.insertCell(2);var col_4 = row.insertCell(3);
      var col_5 = row.insertCell(4);var col_6 = row.insertCell(5);var col_7 = row.insertCell(6);var col_8 = row.insertCell(7);
      var col_9 = row.insertCell(8);var col_10 = row.insertCell(9);var col_11 = row.insertCell(10);var col_12 = row.insertCell(11);
      var col_13 = row.insertCell(12);
      col_1.innerHTML = "NEW CELL1";
      col_2.innerHTML = "NEW CELL2";
      /*cat_obj.innerHTML+="<tr><th>HOUSE_NO</th></tr>";
      cat_obj.innerHTML+="<tr>"+"<td></td>"
+"</tr>";*/

    
    }//end for i
    //  fetchSAPCust();
  } else {//end if ?
    alert("No Record Found !");
    //cat_obj.options[0] = new Option("--All--", "-1", false, false);
  } //end if !?
  }
 
  function displayLocalities(){
  document.getElementById("addRow").style.display = "inherit";
  var location_code = document.getElementById("location_code").value;
  //alert(location_code);
  //var colCode = document.getElementById("colonies").value;
  
  var url = "../../ReportFilters?cmd=getLocalityDet&locationCode=" + escape(location_code);//+"&colCode=" + escape(colCode);
  //alert("url :: " + url);
  if (window.XMLHttpRequest) {//alert("inside ");
    req = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    req = new ActiveXObject("Microsoft.XMLHTTP");
  }
  req.open("Post", url, true);
  //alert(url);
  req.onreadystatechange = CatCallbackloc;
  req.send(null);
}//end function fetchFlats

function CatCallbackloc() {
  //alert("inside");
  if (req.readyState == 4) {
    if (req.status == 200) {
      var locList = req.responseText;
      //alert("Flat :: " + flatList);
      displaylocality(locList);
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

function displaylocality(locList) {
  var cat_obj = document.getElementById("dis_locality");
  cat_obj.style.textAlign = "center";
  //cat_obj.style.border = "1";
  //var totClmn = 3;
  //cat_obj.length = 0; 
  while(cat_obj.rows.length>0) 
    cat_obj.deleteRow(cat_obj.rows.length-1); 
   
 
  /*var locality = document.getElementById("localities").value;
   alert(locality);
  var locarr = locality.split(':');
  var loc_name = locarr[1];
  //alert(loc_name);
  */
   if (locList !== '?') {
    var col_arr=["LOC_NAME", "LOCALITY_NAME", "LAST_ALLOTTED_CAT"];
    var Cat_arr = locList.split(';');
    var i;
    //var tbl_head = cat_obj.createTHead();
    var row_head = cat_obj.insertRow(0);
    for(i=0;i<col_arr.length;i++){
      var col_head = row_head.insertCell(i).innerHTML="<b>"+col_arr[i]+"</b>";
    }
    for (i = 1; i <= Cat_arr.length; i++) {//i = Cat_arr.length;
      var Cat = Cat_arr[i-1].split(':'); 
      var row = cat_obj.insertRow(i);
      for (j = 1; j <= Cat.length; j++) {
        /*  if(j==2)
              row.insertCell(j-1).innerHTML=loc_name;
            else
         */ row.insertCell(j-1).innerHTML=Cat[j-1];
          //col.style.textAlign = "center";
    }
      //var col_1 = row.insertCell(0);col_1.innerHTML =Cat[0];
      //cat_obj.options[cat_obj.options.length] = new Option(Cat[1], Cat[0], false, false);
     // var taBLE = document.getElementById("myTable");
      /*var col_1 = row.insertCell(0);var col_2 = row.insertCell(1);var col_3 = row.insertCell(2);var col_4 = row.insertCell(3);
      var col_5 = row.insertCell(4);var col_6 = row.insertCell(5);var col_7 = row.insertCell(6);var col_8 = row.insertCell(7);
      var col_9 = row.insertCell(8);var col_10 = row.insertCell(9);var col_11 = row.insertCell(10);var col_12 = row.insertCell(11);
      var col_13 = row.insertCell(12);
      col_1.innerHTML = "NEW CELL1";
      col_2.innerHTML = "NEW CELL2";
      /*cat_obj.innerHTML+="<tr><th>HOUSE_NO</th></tr>";
      cat_obj.innerHTML+="<tr>"+"<td></td>"
+"</tr>";*/

    
    }//end for i
    //  fetchSAPCust();
  } else {//end if ?
    alert("No Record Found !");
    //cat_obj.options[0] = new Option("--All--", "-1", false, false);
  } //end if !?
  }

 