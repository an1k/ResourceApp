
<?php
require_once 'core.inc.php';
require_once 'connect.inc.php';
//echo $current_file;

?>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>the fucking title goes here</title>
<link rel="stylesheet" href="index.css"/>
<?php
if(loggedin()){
?>
<script type="text/javascript" src="index.js"></script>
<?php
}else{
?>
<script>
function check(){
var a=document.forms["login"]["username"].value;
                var b=document.forms["login"]["password"].value;
				if(a==""||b==""){
				alert('both the username and password fields should be filled');
				return false;
				}else
				return true;
				}
</script>
</head>
<body>
<?php }
?>


 <?php
 
    if(loggedin()){
	 
      ?>	
</head>

<body onload="init()">
	  <div id="big_wrapper">
 
    <header id="top_header">
    <h1 class="tj">Welcome </h1>
    <a href="upload.php" alt="change profile picture"><img id="dp"  src="generate_thumbnail.php"/></a>
    <h2><?php 
	if($result=getUserFields('firstname,lastname')){
	  echo $result['firstname']." ".$result['lastname'];
	  }
	  ?>
</h2>
<a href="logout.php"><div id="logout">
Log Out
</div></a>
    </header>
    <nav id="top_menu">
    <ul>
    <li id="home" class="nothing"><a onclick="home()">home</a></li>
    <li id="profile" class="nothing"><a onclick="profile()">profile</a></li>
    <li id="info" class="nothing"><a onclick="info()">gamer's info</a></li>
	<li id="photos" class="nothing"><a onclick="photos()">photos</a></li>
	<li id="games" class="nothing"><a onclick="games()">games</a></li>
    </ul>
    </nav>
    <aside id="another_side_fuck"><h4>INFO</h4>
	<?php
	include_once 'info.php';
	?>
    </aside>
    <section id="main_section">
	  <div id="mid">
        <article>
            this page is loading.....
       </article>
    <article>
     if you have javascript turned off please turn it on or else this page might not work<br>    
       </article>
	   </div>
	   <div id="space"><br></div>
    </section>
    <aside id="side_fuck">
    <h4>NEWS</h4>
    <?php
	include_once 'news.php';
	?>
       
    </aside>
    
    </div>
    
<?php
 }else{
    include_once 'loginform.inc.php';
   }
 ?>
 <footer id="the_footer">
<div id="footer_stuff">Developed by Anik Bose</div>
</footer>
</body>
</html>
