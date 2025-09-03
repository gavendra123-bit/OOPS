class InsufficientFuntException extends Exception{
    public InsufficientFuntException(String msg){
        super(msg);
    }
}

class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String msg){
        super(msg);
    }
}

public class My_Class {
    private String acc_name;
    private double balance;
    public  My_Class(String name, double openbal) throws InvalidAmountException{
        if (openbal<0){
            throw new InvalidAmountException("Opening balance cannot be Negative");
        }
        this.acc_name=name;
        this.balance=openbal;
    }
    public void Withdraw(double amt, int pin) throws InsufficientFuntException {
        if (amt<=0){
            throw new InvalidAmountException("Withdraw Amount must be POSITIVE");
        }
        balance=balance-amt;
        System.out.println("Withdraw amt"+amt+"Remaining amt"+balance);
    }
    public void deposite(double amt) throws InvalidAmountException{
        if(amt<=0){
            throw new InvalidAmountException("Deposite Amount must be positive");
        }
        balance=balance+amt;
    }
    public double getBalance(){
        return balance;
    }
    public static void main(String[] args) {
        My_Class rahul=new My_Class("Rahul",1000.45);
        try {
            rahul.Withdraw(2000.876,0);
        }
        catch (InvalidAmountException e) {
            System.out.println("Invalid Amount"+e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Parent exception class"+e.getMessage());
        }
        finally {
            System.out.println("Your Session Expired");

        }
        try {
            rahul.deposite(-200);
        }
        catch(InvalidAmountException e) {
            System.out.println("Deposit error"+e.getMessage());

        }
        System.out.println("Final Balance of "+rahul.acc_name+" "+rahul.getBalance());

    }
}
