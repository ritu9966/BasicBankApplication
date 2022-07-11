import java.util.*;
public class BankApplication {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("*********************************************");
        System.out.print("Enter your Name: ");
        String name=sc.nextLine();
        System.out.print("Enter your Id: ");
        int customerId=sc.nextInt();
        BankAccount obj1=new BankAccount(name,customerId);
        obj1.menu();

    }
    
}
class BankAccount{
    double bal;
    double prevTrans;
    String CustomerName;
    int customerId;

    BankAccount(String CustomerName,int customerId){
         this.CustomerName=CustomerName;
         this.customerId=customerId;
    }
    void deposit(double amount){
        if(amount!=0){
            bal+=amount;
            prevTrans=amount;
        }
    }
    void withdraw(double amt){
        if(amt!=0 && bal>=amt){
            bal-=amt;
            prevTrans=-amt;
    }
    else if(bal<amt){
        System.out.println("Bank balance insufficient");

    }
    }
    void getPrevioustrans(){
        if(prevTrans>0){
            System.out.println("Deposited: "+prevTrans);
        }
        else if(prevTrans<0){
            System.out.println("Withdrawn: "+Math.abs(prevTrans));
        }
        else{
            System.out.println("No transaction occured");
        }
    }
    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+CustomerName);
        System.out.println("Your ID:"+customerId);
        System.out.println("");
        System.out.println("*****Please choose need service*****");
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");
     
        do{
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'a':
                case 'b':
                System.out.println("......................");
                System.out.println("Enter a amount to deposit :");
                System.out.println("......................");
                double amt=sc.nextDouble();
                deposit(amt);
                System.out.println("\n");
                break;
            case 'c':
                System.out.println("......................");
                System.out.println("Enter a amount to Withdraw :");
                System.out.println("......................");
                double amtW=sc.nextDouble();
                withdraw(amtW);
                System.out.println("\n");
                break;
            case 'd':
                System.out.println("......................");
                System.out.println("Previous Transaction:");
                getPrevioustrans();
                System.out.println("......................");
                System.out.println("\n");
                break;
                case 'e':
                System.out.println("......................");
                break;
            default:
                System.out.println("Choose a correct option to proceed");
                break;
        }

    }while(option!='e');

    System.out.println("Thank you for using our banking services");
}

}
        
