
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
	let cookies = document.cookie;
	
	
	uiColorChoice  = cookies.split("=")[1];
	console.log(uiColorChoice)
	if(uiColorChoice == "dark"){
	 $("#headerBox").removeClass('bg-light').addClass('bg-dark');
	 $("#navbarid").removeClass(' bg-light').addClass(' bg-dark');
	 document.body.style.backgroundColor = "gray";
	}else{
		
	}
	

		
      

}

window.onload = function() { //calls to check uiColor
  test();
};

//need a on page load to check the cookie and add