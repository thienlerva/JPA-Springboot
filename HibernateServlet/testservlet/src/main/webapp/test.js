window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#viewTicketsNav').on('click', loadTicketsView);
	$('#userNav').on('click', loadUserView);
	$('#authorNav').on('click', loadAuthorView);
	$('#logout').on('click', loadLogoutView);

}

function loadHomeView(){
	/*
	 * AJAX functions can be used to retrieve all types 
	 * of data from a server. Including HTML!
	 * We will send a request to a servlet which will 
	 * forward our desired HTML page as a response, 
	 * then, in the onreadystatechange function, we will 
	 * designate what we would like to do with the response 
	 * as usual -- but in this case, we will apply event listeners
	 * to the new DOM elements
	 */
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('here ate JS');
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#username').html(xhr.responseText);
			console.log('here ate JS');
			getUse();
		}
	}
	xhr.open("GET", "hometest", true);
	xhr.send();	
}

function getuser(){
	//send request to /reimbursements
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let user = xhr.responseText;
			console.log(user);
			
//			for(let r of reims){
//				appendToTicketList(r);
//			}
		}
	}
	xhr.open("GET", "hometest");
	xhr.send();
}