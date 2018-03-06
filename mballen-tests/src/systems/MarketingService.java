package systems;

import utils.IO;

public class MarketingService extends MktService {
    @Override
    public void sendAD(String customerID, String email) {
        IO.printMessage("Sending cupons to email " + email + " from customer " + customerID);
    }
}
