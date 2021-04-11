
function chooseUi (colorChoice){
document.getElementById("uiChoice").value = colorChoice;
}





if (confirm('do you accept our use of cookies ? some functions might not be availible without them')) {
 document.getElementById("cookieAllow").value = "true";
 
} else {
  
  document.getElementById("dropdownMenuButton").disabled = "true";
  document.getElementById("cookieAllow").value = "false";

}
