<?php

 //echo 'hello world';
 //phpinfo();
$mysql_host='localhost';
$mysql_user='root';
$mysql_db='helphire';

 if((!mysql_connect($mysql_host,$mysql_user,'')) || !mysql_select_db($mysql_db)){
 die('error');
}
 

 
 ?>
