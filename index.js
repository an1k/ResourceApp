
xmlCache=createXmlObject();
xmlHttp=createXmlObject();
currentLoc='new';
function init(){
prev=document.getElementById('logout');
home();

//alert(currentLoc.toString());
}
function home(){
if(currentLoc=='home'){
alert('you are already in home');
}else{
//alert('home');
try{prev.className='nothing';
prev=document.getElementById('home');
prev.className='selected';
}catch(e){
alert(e);
}

if(xmlCache.readyState==4 || xmlCache.readyState==0){
currentLoc='home';
document.getElementById('mid').innerHTML="<h2>Wait.... fetching data....</h2>";
xmlCache.open("GET","test.php?page=home",true);
		xmlCache.onreadystatechange=tj;
		xmlCache.send(null);
}else{
setTimeout(home(),1000);
}
}
}


function servicesRegistered(){
if(currentLoc=='servicesregistered'){
alert('you are already in services registered');
}else{
if(xmlCache.readyState==4 || xmlCache.readyState==0){
currentLoc='servicesregistered';
document.getElementById('mid').innerHTML="<h2>Wait.... fetching data....</h2>";
xmlCache.open("GET","services_registered.php",true);
		xmlCache.onreadystatechange=tj;
		xmlCache.send(null);
}else{
setTimeout(photos(),1000);
}
//alert('photo');
}
}

function registerService(){
if(currentLoc=='servicesregistered'){
alert('you are already in register service');
}else{
if(xmlCache.readyState==4 || xmlCache.readyState==0){
currentLoc='servicesregistered';
document.getElementById('mid').innerHTML="<h2>Wait.... fetching data....</h2>";
xmlCache.open("GET","register_service.php",true);
		xmlCache.onreadystatechange=tj;
		xmlCache.send(null);
}else{
setTimeout(photos(),1000);
}
//alert('photo');
}
}


function services(){
if(currentLoc=='services'){
alert('you are already in services');
}else{
if(xmlCache.readyState==4 || xmlCache.readyState==0){
currentLoc='services';
document.getElementById('mid').innerHTML="<h2>Wait.... fetching data....</h2>";
xmlCache.open("GET","services.php",true);
		xmlCache.onreadystatechange=tj;
		xmlCache.send(null);
}else{
setTimeout(services(),1000);
}
//alert('photo');
}
}


function profile(){
if(currentLoc=='profile'){
alert('you are already in profile');
}else{
if(xmlCache.readyState==4 || xmlCache.readyState==0){
currentLoc='profile';
document.getElementById('mid').innerHTML="<h2>Wait.... fetching data....</h2>";
xmlCache.open("GET","profile.php",true);
		xmlCache.onreadystatechange=tj;
		xmlCache.send(null);
}else{
setTimeout(profile(),1000);
}
//alert('profile');
}
}

function info(){
if(currentLoc=='info'){
alert('you are already in info');
}else{
if(xmlCache.readyState==4 || xmlCache.readyState==0){
currentLoc='info';
document.getElementById('mid').innerHTML="<h2>Wait.... fetching data....</h2>";
xmlCache.open("GET","test.php?page=info",true);
		xmlCache.onreadystatechange=tj;
		xmlCache.send(null);
}else{
setTimeout(info(),1000);
}
//alert('info');
}

}
function createXmlObject(){
	if(window.ActiveXObject){
		var xmlHttp;
		try{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
			xmlHttp=false;
		}	
		}else{ try{
		
		xmlHttp=new XMLHttpRequest();
		}catch(e){
			xmlHttp=false;
			alert(e);
		}
	}
	if(!xmlHttp){
		alert("hey somethings wrong");
	}else return xmlHttp;
}


function tj(){
     //alert('readystatechange');
    if(xmlCache.readyState==4&&xmlCache.status==200){
	 
	 document.getElementById('mid').innerHTML=xmlCache.responseText;
	}
	}
	
	
	
	function findMatch(){
//alert('findMatch()');
   xmlHttp=createXmlObject();
   
  
   try{  var search=document.search.keyword.value;
document.getElementById('searchState').innerHTML='Searching...';
xmlHttp.open('GET','search.inc.php?search='+search,true);
xmlHttp.onreadystatechange= searched;
 xmlHttp.send();
}catch(e){
alert(e);}

}

function searched(){
	if(xmlHttp.readyState==4&&xmlHttp.status==200){
	 document.getElementById('searchState').innerHTML='';
	 document.getElementById('results').innerHTML=xmlHttp.responseText;
	}
}