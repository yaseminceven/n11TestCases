package base;

//class to specify data
public class BaseData {
    private final String[] paymentInfo = {"yasemintest@gmail.com","yasemin ceven","İstanbul","Sarıyer","Ayazağa","Büyükdere Caddesi Ayazağa Mahallesi","05313641470","53733830338","ev"};
    private final String[] cartNum = {"5425","2334","3010","9904"};
    private final String[] cartInfo = {"yasemin ceven","4","2023","317"};

    public String getPaymentInfo(int i){
        return paymentInfo[i];
    }

   public String[] getCartNum(){
       return cartNum;
   }
   public String getCartInfo(int i){
       return cartInfo[i];
   }
    
}
