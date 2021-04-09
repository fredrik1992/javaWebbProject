
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



function test(){
	console.log("testy")
	
	 $("#headerBox").removeClass('bg-light').addClass('bg-dark');
	 $("#navbarid").removeClass(' bg-light').addClass(' bg-dark');
		
		$("#headerBox").backgroundColor = "grey";// funkar inte
      

}