$(document).ready(function(){
    $("#register").click(function(){
    var x=$("#phone").val().length();
    if(x!=10)
    	{
    	alert("Name must be filled out");
        return false;
    	}
    	
    });
});