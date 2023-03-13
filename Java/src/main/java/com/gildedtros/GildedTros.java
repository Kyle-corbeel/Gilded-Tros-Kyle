package com.gildedtros;

import static java.lang.Math.max;
import static java.lang.Math.min;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        int deg = 0;
        for (int i = 0; i < items.length; i++) {
            //legendary items remain unchanged
            if(!isLegendary(items[i])){
                items[i].sellIn--;

                deg = checkDegradation(items[i]);

                //Apply degradation to quality
                if(deg==0){
                    items[i].quality = 0;
                }
                else if(deg<0 && items[i].sellIn<0){
                    items[i].quality+=(deg*2);
                }
                else {
                    items[i].quality+=deg;
                }

                //Check non-legendary item quality is between 0 and 50
                items[i].quality = max(min(items[i].quality,50),0);
            }
        }
    }

    public boolean isLegendary(Item item){
        return item.name.equals("B-DAWG Keychain");
    }
    public boolean isSmelly(Item item){
        return item.name.equals("Duplicate Code") ||
            item.name.equals("Long Methods") ||
            item.name.equals("Ugly Variable Names");
    }
    public boolean isBackstagePass(Item item){
        return item.name.startsWith("Backstage passes for");
    }

    public int checkDegradation(Item item){
        //Standard degradation is -1 every day
        int deg = -1;

        //Check for different item types
        if(item.name.equals("Good Wine")){
            deg=1;
        }
        else if(isSmelly(item)){
            deg=-2;
        }
        else if(isBackstagePass(item)){
            if(item.sellIn<0){ deg=0; }
            else if(item.sellIn<6){ deg=3; }
            else if (item.sellIn<11){ deg=2; }
            else{ deg=-1; }
        }
        return deg;
    }
}