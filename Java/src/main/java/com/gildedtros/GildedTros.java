package com.gildedtros;

import static java.lang.Math.max;
import static java.lang.Math.min;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            //legendary items remain unchanged
            if(!isLegendary(items[i])){
                items[i].sellIn--;

                //Check for different item types
                if(items[i].name.equals("Good Wine")){
                    items[i].quality++;
                }
                else if(isDodgy(items[i])){
                    items[i].quality-=2;
                    if(items[i].sellIn<0){items[i].quality-=2;}
                }
                else if(isBackstagePass(items[i])){
                    if(items[i].sellIn<0){
                        items[i].quality = 0;
                    }
                    else if(items[i].sellIn<6){
                        items[i].quality+=3;
                    }
                    else if (items[i].sellIn<11){
                        items[i].quality+=2;
                    }
                    else{
                        items[i].quality--;
                        if(items[i].sellIn<0){items[i].quality--;}
                    }
                }
                else{
                    items[i].quality--;
                    if(items[i].sellIn<0){items[i].quality--;}
                }
                //Check non-legendary item quality is between 0 and 50
                items[i].quality = max(min(items[i].quality,50),0);
            }
        }
    }

    public boolean isLegendary(Item item){
        return item.name.equals("B-DAWG Keychain");
    }
    public boolean isDodgy(Item item){
        return item.name.equals("Duplicate Code") ||
            item.name.equals("Long Methods") ||
            item.name.equals("Ugly Variable Names");
    }
    public boolean isBackstagePass(Item item){
        return item.name.startsWith("Backstage passes for");
    }
}