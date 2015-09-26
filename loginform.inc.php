<?php
  if(isset($_POST['username'])&&isset($_POST['password'])){
     $username=$_POST['username'];
	 $password=$_POST['password'];
	if(!empty($username)&&!empty($password)){
	 $password=md5($password);
	$query="select `id`,`type` from `users` where `username`='".mysql_real_escape_string($username)."' and `password`='".$password."'";
	if($query_run=mysql_query($query)){
	echo mysql_error();
	 if(mysql_num_rows($query_run)>=1){
	 
	  $userid=mysql_result($query_run,0,'id');
	  $type=mysql_result($query_run,0,'type');
	  $_SESSION['user_id']=$userid;
	  $_SESSION['type']=$type;
	  header('location:index.php');
	    }else{
		echo 'invalid username or password';
		echo mysql_error();
	 }
	 }else echo 'wrong user id or password <br>';
	}else{
	echo 'supply the fucking username and password';
	}
  
  }
?>

<form id="login" name="login" action="<?php echo $current_file;?>" method="POST" onSubmit="return check()" >
username: <input type="text" name="username">&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
password: <input type="password" name="password">
<input type="submit" value="log in">

</form>
<div id="register"><br><br><h2>new user??<h2><br>
<a href="register.php">
<div id="box" onclick="register.php">register
</div>
</a>
</div>
<div id="description">
This is a place you wanna be.. <br><br>A Place to share place to play..<br><br>Whatever you are looking for you will find it here under one roof.<br><br> BLOGS CHATROOMS PHOTOS MEDIA and the BEST of all..<br><br><h2>GAMES</h2></div>

