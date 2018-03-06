package systems;

import utils.IO;

public abstract class MktService {
    public void updateInformation(String customerID, Double transactionValue, String email) {
        IO.printMessage("Check value :" + transactionValue);
        this.sendAD(customerID, email);
    }

    abstract public void sendAD(String CustomerID, String email);
}
