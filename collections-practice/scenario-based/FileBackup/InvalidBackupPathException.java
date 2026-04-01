package filebackupscheduler;

//Custom checked exception
public class InvalidBackupPathException extends Exception{

 public InvalidBackupPathException(String message){
     super(message);
 }
}

