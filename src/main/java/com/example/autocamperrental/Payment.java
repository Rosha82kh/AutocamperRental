package com.example.autocamperrental;

import com.example.autocamperrental1.Luxury;

public class Payment extends Season{
    double deposite;
    double totalPrice;
    double priceHighSeason=getHighSeason();
    double priceLowSeason=getLowSeason();
    Luxury l=new Luxury();
    double  LuxuryPrice=l.getLuxuryNormalPrice();

          public double calculateHighSeasonForLuxury(double priceHighSeason,double LuxuryPrice,double totalPrice){
              totalPrice=(priceHighSeason+LuxuryPrice);
               return totalPrice;
          }
          public double calculateLowSeasonForLuxury(){
              totalPrice=(priceLowSeason+LuxuryPrice);
              return totalPrice;}

         public void calculateHighSeasonForBasic(){
                 double priceHighSeason=getHighSeason();
                 totalPrice=deposite+priceHighSeason;



         }

    public static void main(String[] args) {
              Payment P=new Payment();

        System.out.println( "the price for luxury camper in high season "+P.calculateHighSeasonForLuxury(5,4,3));
        System.out.println( "the price for luxury camper in Low season "+P.calculateLowSeasonForLuxury());

    }

}
