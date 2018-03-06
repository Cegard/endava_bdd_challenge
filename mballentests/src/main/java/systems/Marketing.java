package systems;

import entities.Message;
import entities.TransactionMessage;
import utils.TransactionMessageAdapter;

public class Marketing extends Observer {
    MktService marketingService;

    public Marketing() {
        this.marketingService = new MarketingService();
    }

    @Override
    public void update(Message message) {
        TransactionMessage transactionMessage = TransactionMessageAdapter.getTransactionMessage(message);
        this.marketingService.sendAD(transactionMessage.getCustomerId(), transactionMessage.getCustomerEmail());
    }
}
