


function openForm(){

    document.getElementById("feedFormID").style.display = "block";	
	

}

function closeForm(){
	
    document.getElementById("feedFormID").style.display = "none";	
	
}

 function getFeeds()
    {

        var username = '<%= Session["allFeedsData"] %>';
       
    }



function changeUiColor(){
	let cookies = document.cookie;
	
	
	uiColorChoice  = cookies.split("=")[1];

	if(uiColorChoice == "dark"){
	 $("#headerBox").removeClass('bg-light').addClass('bg-dark');
	 $("#navbarid").removeClass(' bg-light').addClass(' bg-dark');
	 document.body.style.backgroundColor = "gray";
	}else{// white is the default css so no need to change
		
	}
	

		
      

}

window.onload = function() { //calls to check uiColor
  changeUiColor();
};

//need a on page load to check the cookie and add