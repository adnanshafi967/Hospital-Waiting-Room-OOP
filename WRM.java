import java.util.Scanner;
public class WRM{
  ListQueue pQ;
  static int j=1;
  WRM(){
    pQ= new ListQueue();
  }
  public void RegisterPatient(){
    Scanner sc =new Scanner(System.in);
    String n= sc.next();
    int a= sc.nextInt();
    String b= sc.next();
    Patient p =new Patient(n,a,b,j);
    try{
      pQ.enqueue(p);
      j++;
    }
    catch(QueueOverflowException e){
      System.err.println("waiting room is full");
    }
  }
  public void ServePatient(){
    try{
      Patient b = (Patient)pQ.dequeue();
      System.out.println(b.id);
      System.out.println(b.name);
    }
    catch(QueueUnderflowException e){
      System.err.println("waiting room is empty");
    }
  }
  public void CancelAll(){
      int c=pQ.size;
    for(int i=0;i<c;i++){
      try{
        pQ.dequeue();
      }
      catch(QueueUnderflowException e){
        System.err.println("waiting room is empty");
      }
    }
  }
  public boolean CanDoctorGoHome(){
    if(pQ.isEmpty()==true){
      return true;
    }
    return false;
  }
  public void ShowAllPatient(){
    Object l[]= pQ.toArray();
    Patient q[]= new Patient[l.length];
    for(int i=0;i<l.length;i++){
         q[i]= (Patient)l[i];
    }
    for(int i=0;i<q.length;i++){
        char min= q[i].name.charAt(0);
        int minpos= i;
        for(int j=i;j<q.length;j++){
            if(min>q[j].name.charAt(0)){
                min=q[j].name.charAt(0);
                minpos=j;
            }
        }
        if(min!=q[i].name.charAt(0)){
            Patient temp=q[i];
            q[i]=q[minpos];
            q[minpos]=temp;
        }
    }
    for(int i=0;i<q.length;i++){
        System.out.println(q[i].id);
        System.out.println(q[i].name);
    }
  }
}