/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function toggle5(showHideDiv) {
  var ele = document.getElementById(showHideDiv);

  if(ele.style.display == "none" || ele.style.display == "") {
    ele.style.display = "block";

  } else {
    ele.style.display = "none";
  }
}