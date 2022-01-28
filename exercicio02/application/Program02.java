package application;

import javax.swing.JOptionPane;

import model.entities.Account;
import model.exception.DomainException;

public class Program02 {
	
	public static void main(String args[]) {
		
		Account account = new Account();
		try {
			
			System.out.println("Enter account data:");
			System.out.println("Number: " 
						+ String.format("%7d", account.getNumber()).replace(' ' , '0') + 
					"-" + account.getDac());
			
			//Entrada do parametro do nome do correntista
			System.out.print("Holder: ");
			account.setHolder(JOptionPane.showInputDialog("Holder: "));
			System.out.println(account.getHolder());
			
			//Entrada do Valor Saldo Inicial
			System.out.print("Initial Balance: $");
			account.setBalance
					(Double.parseDouble
							(JOptionPane.showInputDialog("Initial Balance: ")));
			System.out.println(String.format("%.2f",account.getBalance()));
			
			//Entrada do Valor Limite de saque
			System.out.print("Withdraw Limit: $");
			account.setWithdrawLimit
					(Double.parseDouble
							(JOptionPane.showInputDialog("Withdraw Limit: ")));
			System.out.println(String.format("%.2f",account.getWithdrawLimit()));
			
			//Efetuando saque
			System.out.print("Enter amount for withdraw: $");
			Double amountWithdraw = Double.parseDouble
					(JOptionPane.showInputDialog("Enter amount for withdraw: "));
			System.out.println(String.format("%.2f", amountWithdraw));
			account.withdraw(amountWithdraw);
			
			System.out.println("New Balance $" + String.format("%.2f", account.getBalance()));
			
		}
		catch(DomainException e) {
			System.out.println("Error domain: " + e.getMessage());
		}
		catch(NullPointerException e) {
			System.out.println("Error domain: " + e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error arguments: " + e.getMessage());
		}
	}
	
}
