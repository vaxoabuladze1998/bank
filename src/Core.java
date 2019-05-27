import java.util.List;

public class Core {
    private Medium medium;

    public void addAmount (String client, float amount) throws Exception {
        float balance = this.getBalance(client);
        if(balance+amount<0){

            return;
        }
        long dataId =System.currentTimeMillis();
        medium.write(client,dataId,Float.toString(amount));
    }
    public void getAmount (String client, float amount) throws Exception {
        this.addAmount(client,-amount);
    }
    public void transforAmount(String formClient, String toClient, float amount) throws Exception {
        this.getAmount(formClient,amount);
        this.addAmount(toClient,amount);
    }
    public float getBalance(String client) throws Exception{

        float balance = 0;

        List<String> operations = medium.read(client);

        for (String operation : operations) {
            balance+= Float.valueOf(operation.split("")[1]);

        }


        return balance;
    }

}
