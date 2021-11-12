import java.util.Scanner;
public class TesterWRM{
  public static void main(String[]args){
    Scanner k = new Scanner(System.in);
    int selection;
    WRM p= new WRM();
    while(true){
      while(true){
        try{
          System.out.println("Please, enter:\n1 to RegisterPatient\n2 to ServePatient\n3 to CancelAll\n4 to  check CanDoctorGoHome\n5 to ShowAllPatient\n6 to exit");
          selection = k.nextInt();
          if(selection!=1 && selection!=2 && selection!=3 && selection!=4 && selection!=5 && selection!=6)
            System.err.println("Wrong Selection! Please, try Again.");
          else break;
        }
        catch(Exception e){
          System.err.println("Input Format Mismatch! Please, try Again.");
          k.next();
        }
      }
      
      if(selection==1){
        p.RegisterPatient();
      }
      else if(selection==2){
        p.ServePatient();
      }
      else if(selection==3){
        p.CancelAll();
      }
      else if(selection==4){
        System.out.println(p.CanDoctorGoHome());
      }
      else if(selection==5){
        p.ShowAllPatient();
      }
      else if(selection==6){
        break;
      }
    }
  }
}