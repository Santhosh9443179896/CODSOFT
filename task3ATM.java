

import java.util.Scanner;

class MinBalException extends Exception
{

    public MinBalException(String message) 
    {
        super(message);
        
    }
    
    
}
class Account
{
    int ano;
    String name;
    double balance;

    public Account(int ano, String name, double balance) throws MinBalException 
    {
        if(balance<1000)
        {System.out.println("error occured");
         throw new MinBalException("minimum balance is Rs.1000");}
        this.ano = ano;
        this.name = name;
        this.balance = balance;
    }
    public void deposit(double amt)
    {
        balance=balance+amt;
	System.out.println("--------------------------");
        System.out.println("current balance :"+balance);
	System.out.println("--------------------------");
    }
    public void withdraw(double amt)throws MinBalException
    {
        if(balance-amt<1000)
        {
            System.out.println("error occured");
            throw new MinBalException("minimum balance is Rs.1000");
        }
        balance=balance-amt;
	System.out.println("--------------------------");
        System.out.println("current balance after withdraw :"+balance);
	System.out.println("--------------------------");
    }   
    public void display()
    {
	System.out.println("--------------------------");
        System.out.println("Name:"+name);
        System.out.println("Acccount Number:"+ano);
        System.out.println("Balance:"+balance);
	System.out.println("--------------------------");
    }
    
}
public class task3ATM {

   
    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Wwlcome to SS Bank");
        System.out.println("enter your name:");
        String n=sc.next();
        System.out.println("Enter account number:");
        int a=sc.nextInt();
        System.out.println("Enter amount:");
        double c=sc.nextDouble();
        try
        {
            Account obj=new Account(a,n,c);
            System.out.println("Account created successfully");
            int choice;
	    System.out.println("--------------------------");
	    System.out.println("ATM Interface");
            do
            {
              System.out.println("1.deposit\n2.withdraw\n3.display balance \n4.exit");
              System.out.println("Enter your choice:");  
               choice=sc.nextInt();
              if(choice==1)
              {
                  System.out.println("Enter amount:");
                  double b=sc.nextDouble();
                  obj.deposit(b);
                  
              }
              else if(choice==2)
              {
                  System.out.println("Enter amount:");
                  double b=sc.nextDouble();
                  obj.withdraw(b);
              }
              else if(choice==3)
              {
                  obj.display();
              }
              else 
              {
                  break;
              }
            }while(choice<4);
        }catch(MinBalException m)
        {
            System.out.println("minimum balance is Rs.1000");
        }
        System.out.println("try again later")       ;
                
    }
    
}


//output:
//case 1:
//run:
//Welcome to TATA Bank
//enter your name:

//ramu
//Enter account number:
//1001
//Enter amount:
//4000
//Account created successfully
//1.deposit
//2.withdraw
//3.display
//4.exit
//Enter your choice:
//1
//Enter amount:
//500
//current balance :4500.0
//1.deposit
//2.withdraw
//3.display
//4.exit
//Enter your choice:
//2
//Enter amount:
//3000
//current balance after withdraw :1500.0
//1.deposit
//2.withdraw
//3.display
//4.exit
//Enter your choice:
//3
//Name:ramu
//Acccount Number:1001
//Balance:1500.0
//1.deposit
//2.withdraw
//3.display
//4.exit
//Enter your choice:
//4
//try again later

//case 2:
//run:
//Welcome to TATA Bank
//enter your name:

//ramu
//Enter account number:
//1001
//Enter amount:
//4000
//Account created successfully
//1.deposit
//2.withdraw
//3.display
//4.exit
//Enter your choice:
//2
//Enter amount:
//4000
//error occured
//minimum balance is Rs.1000
//try again later

//case 3:
//run:
//Welcome to TATA Bank
//enter your name:
//ramu
//Enter account number:
//1001
//Enter amount:
//900
//error occured
//minimum balance is Rs.1000
//try again later
