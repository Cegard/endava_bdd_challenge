package entities;

import utils.IO;

import java.util.Date;

public class Withdrawal extends Transaction {
    public Withdrawal(Client client, Agent agent, Date transactionDate, double transactionValue, String type) {
        super(client, agent, transactionDate, transactionValue, type);
    }

    @Override
    public boolean attend(Client client) {
        if(this.transactionValue <= client.getBalance()) {
            IO.printMessage(client.getName() + " withdraws: " + this.transactionValue + " succesfully");
            this.client.setBalance(this.client.getBalance() - this.transactionValue);
            return true;
        }
        else {
            IO.printMessage(client.getName() +  " trying to withdraw... " + this.transactionValue);
            IO.printMessage("Not founds available!");
            return false;
        }
    }
}
