import java.util.*;
import javax.lang.model.util.ElementScanner14;
class student

{
int a;
int b;
int c;
int d;
int e;
int f;
    public student(int a,int b,int c,int d, int e,int f)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.e=e;
this.f=f;
        
    }
    public void total()
    {
        int tot=a+b+c+d+e+f;
        float per = (tot / 600.0f) * 100;
        System.out.println("Total marks obtained in 12th "+tot);
        System.out.println("percentage obtained in 12th "+per);
        if(per >= 90)
        {
            System.out.println("Grade obtained in 12th : O Grade");
        }
        else if(per>= 80)
        {
            System.out.println("Grade obtained in 12th : A+ Grade");
        }
        else if(per  >=  70)
        {
            System.out.println("Grade obtained in 12th : A Grade");
        }
        else if(per >= 60)
        {
            System.out.println("Grade obtained in 12th : B Grade");

        }
        else if(per>=  50)
        {
            System.out.println("Grade obtained in 12th : c Grade");
        }
        else if(per>= 30)
        {
           
            
                System.out.println("Grade obtained in 12th : D Grade");
            
        }
        else
        {
            System.out.println("Grade obtained in 12th : E (failed) Grade");
        }



    }
    
}



public class task2
{
    public static void main(String args[])
    {
      Scanner sc =new Scanner(System.in);
      System.out.println("Enter mark1:");
      int m1=sc.nextInt();
       System.out.println("Enter mark2:"); 
      int m2=sc.nextInt(); 
       System.out.println("Enter mark3:");
      int m3=sc.nextInt();
       System.out.println("Enter mark4:"); 
      int m4=sc.nextInt(); 
       System.out.println("Enter mark5:");
      int m5=sc.nextInt(); 
       System.out.println("Enter mark6:");
      int m6=sc.nextInt(); 
      student obj=new student(m1,m2,m3,m4,m5,m6);
      obj.total();

    }
}