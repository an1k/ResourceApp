<?php
ob_start();
session_start();
 $current_file=$_SERVER['SCRIPT_NAME'];

 
if(isset($_SERVER['HTTP_REFERER'])&&!empty($_SERVER['HTTP_REFERER']))
$http_referer=$_SERVER['HTTP_REFERER'];
else
$http_referer='index.php';


 function loggedin(){
    if(isset($_SESSION['user_id'])&&!empty($_SESSION['user_id'])){  
     return true;
    }else
	return false;
     
	 }
	 
  function getUserFields($fields){
    $query="select {$fields} from `users` where `userid`='{$_SESSION['user_id']}'";
	  if($query_run=mysql_query($query)){
	  
        return mysql_fetch_assoc($query_run);
        }else
		return false;



    }  
	
	class User{
	private $id, $firstname, $lastname , $dp, $username, $email, $result, $game_no;
	public function __construct($i){
	$this->id=$i;
	$query="select * from `users` where `userid`='{$this->id}'";
	if(@$query_run=mysql_query($query)){
	  $this->result=mysql_fetch_assoc($query_run);
	  $this->firstname=$this->result['firstname'];
	  $this->lastname=$this->result['lastname'];
	  $this->dp=$this->result['dp'];
	  $this->email=$this->result['email'];
	  $this->username=$this->result['username'];
	  $this->game_no=$this->result['gameno'];
	  }  
	}
	public function getResult(){
	return $this->result;
	
	}
	public function getFirstName(){
	return $this->firstname;
	}
	public function changeFirstName($i){
	$this->firstname=$i;
	}
	public function changeLastName($i){
	$this->lastname=$i;
	}
	public function changeDp($i){
	$this->dp=$i;
	}
	public function changeEmail($i){
	$this->email=$i;
	}
	public function setGame($i){
	$this->game_no=$i;
	$this->update();
	}
	public function getGame(){
	return $this->game_no;
	}
	public function update(){
	$query="UPDATE `users` SET `firstname` =  '".$this->firstname."',
`lastname` =  '".$this->lastname."',
`email` =  '".$this->email."', `dp` = '".$this->dp."', `gameno` =".$this->game_no." WHERE  `users`.`userid` =".$this->id;
    if(@$query_run=mysql_query($query)){
	$query="select * from `users` where `userid`='{$this->id}'";
	if(@$query_run=mysql_query($query)){
	  $this->result=mysql_fetch_assoc($query_run);
	  }
	return true;
	}else{
	//echo mysql_error();
	return false;
	}
	}
	}
	 
	 
	 class Photos{
	 private $id;
	 public function __construct($i){
	 $this->id=$i;
	 }
	 public function getPhotos(){
	 $query="SELECT `photo` FROM `photos` WHERE `id` = ".$this->id;
	 if(@$query_run=mysql_query($query)){
	  return $query_run;
	 }else
	 return false;
	 }
	 
	 }
	 
	 
class Games{

public function createGame($game,$file,$privacy){
$game_no=rand(1000,9999);
$query="select `gameno` from `games` where `gameno`=".$game_no;
$query_run=@mysql_query($query);
while(mysql_num_rows($query_run)>0){
$game_no=rand(1000,9999);
$query="select `gameno` from `games` where `gameno`=".$game_no;
$query_run=@mysql_query($query);
}
$query="INSERT INTO `games` VALUES ('".$game_no."', CURRENT_TIMESTAMP, '".$game."', '".$file."',1,".$privacy.")";
if(@mysql_query($query)){
return $game_no;
}else{
return false;
}

}

public function deleteGame($game_no){
$file=$this->getFile($game_no);
$query="DELETE FROM `games` WHERE `games`.`gameno` =".$game_no;
if($query_run=@mysql_query($query)){
return true;
}else{
return false;
}
}

public function getAvailable($game){
$query="SELECT `gameno` FROM `games` WHERE `game`='".$game."' AND `privacy`=1";
if($query_run=mysql_query($query)){
return $query_run;
}else{
echo mysql_error();
 return false;
}
}

public function checkAvailabillity($game,$game_no){
$query="SELECT `gameno`,`users` FROM `games` WHERE `game`='".$game."' AND `gameno`=".$game_no;
if($query_run=mysql_query($query)){
if(mysql_num_rows($query_run)>0){
$no=mysql_fetch_assoc($query_run);
if($no['users']<5)
return true;
else
return false;
}else{
return false;
}
}else{
echo mysql_error();
return false;
}
}

public function getUsers($game_no){
$query="SELECT `users` FROM `games` WHERE `gameno`=".$game_no;
$query_run=mysql_query($query);
if(mysql_num_rows($query_run)>0){
$no=mysql_fetch_assoc($query_run);
return $no['users'];
}else{
mysql_error();
return false;
}
}

public function setUsers($game_no, $users){
$query="UPDATE  `games` SET `users` =  ".$users." WHERE  `gameno` =".$game_no;

if(mysql_query($query)){
return true;
}else{
mysql_error();
return false;
}
}

public function getFile($game_no){
$query="SELECT `file` FROM `games` WHERE `gameno`=".$game_no;
$query_run=mysql_query($query);
if(mysql_num_rows($query_run)>0){
$no=mysql_fetch_assoc($query_run);
return $no['file'];
}else{
mysql_error();
return false;
}
}

}
	 
	?>