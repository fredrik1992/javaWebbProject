
console.log("js loaded")

function openForm(){
	console.log("in open")
    document.getElementById("feedFormID").style.display = "block";	
	alert("opemn");

}

function closeForm(){
	console.log("in close")
    document.getElementById("feedFormID").style.display = "none";	
	
}

 function getFeeds()
    {

        var username = '<%= Session["allFeedsData"] %>';
        console.log("test");
    }



window.addEventListener("load", function() {
  alert('Page is loaded');
});