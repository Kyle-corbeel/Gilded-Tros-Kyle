package com.gildedtros;

import static java.lang.Math.min;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(!isLegendary(items[i])){
                items[i].sellIn--;

                if(items[i].name.equals("Good Wine")){
                    items[i].quality++;
                }
                else if(isDodgy(items[i])){
                    items[i].quality-=2;
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
                    }
                }
                else{
                    items[i].quality--;
                }
                items[i].quality = min(items[i].quality,50);
            }
            // if (!items[i].name.equals("Good Wine")
            //         && !items[i].name.equals("Backstage passes for Re:Factor")
            //         && !items[i].name.equals("Backstage passes for HAXX"))
            // {
            //     if (items[i].quality > 0) {
            //         if (!items[i].name.equals("B-DAWG Keychain")) {
            //             items[i].quality = items[i].quality - 1;
            //         }
            //     }
            // } else {
            //     if (items[i].quality < 50) {
            //         items[i].quality = items[i].quality + 1;

            //         if (items[i].name.equals("Backstage passes for Re:Factor") || items[i].name.equals("Backstage passes for HAXX") ) {
            //             if (items[i].sellIn < 11) {
            //                 if (items[i].quality < 50) {
            //                     items[i].quality = items[i].quality + 1;
            //                 }
            //             }

            //             if (items[i].sellIn < 6) {
            //                 if (items[i].quality < 50) {
            //                     items[i].quality = items[i].quality + 1;
            //                 }
            //             }
            //         }
            //     }
            // }

            // if (!items[i].name.equals("B-DAWG Keychain")) {
            //     items[i].sellIn = items[i].sellIn - 1;
            // }

            // if (items[i].sellIn < 0) {
            //     if (!items[i].name.equals("Good Wine")) {
            //         if (!items[i].name.equals("Backstage passes for Re:Factor") && !items[i].name.equals("Backstage passes for HAXX")) {
            //             if (items[i].quality > 0) {
            //                 if (!items[i].name.equals("B-DAWG Keychain")) {
            //                     items[i].quality = items[i].quality - 1;
            //                 }
            //             }
            //         } else {
            //             items[i].quality = items[i].quality - items[i].quality;
            //         }
            //     } else {
            //         if (items[i].quality < 50) {
            //             items[i].quality = items[i].quality + 1;
            //         }
            //     }
            // }
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
        return item.name.contains("Backstage passes for");
    }
}