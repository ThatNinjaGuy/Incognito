
import java.util.*;

import com.io.ReadFile;
import com.pojo.Order;
import com.util.DetectFrontRunning;

public class LogicTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ReadFile readFile = new ReadFile();
        List<String> readOrders = readFile.readRowsFromFile("orderBook.csv");
        List<Order> orderList = new ArrayList<>();
        for (int i = 1; i < readOrders.size(); i++) {
            String orders = readOrders.get(i);
            String[] orderDetails = orders.split(",");
            int tradeId = Integer.parseInt(orderDetails[0].trim());
            String customerId = orderDetails[1].trim();
            String shareName = orderDetails[2].trim();
            String shareId = orderDetails[3].trim();
            String buySell = orderDetails[4].trim();
            double sharePrice = Double.parseDouble(orderDetails[5].trim());
            String shareType = orderDetails[6].trim();
            double shareQuantity = Double.parseDouble(orderDetails[7].trim());
            String traderId = orderDetails[8].trim();
            String firmClient = orderDetails[9];
            Order orderObject = new Order(tradeId, customerId, shareName, shareId, buySell, sharePrice, shareType, shareQuantity, traderId, firmClient);

            orderList.add(orderObject);

        }
        DetectFrontRunning obj = new DetectFrontRunning();
        List<Order[]> orderScenarioes = obj.detectingFrontRunning(orderList);

        System.out.println("Below are the flagged trades");
        
        for(int i = 0;i<orderScenarioes.size();i++)
        {   
            System.out.println("This is the no. "+ (i+1) + " batch");
            for(int j = 0;j<3;j++)
            {
                System.out.println(orderScenarioes.get(i)[j].toString1());
            }
        }

    }

}
