/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package designing.fpij;

import java.util.Arrays;
import java.util.List;
import fpij.Asset.AssetType;

public class AssetUtil {
  public static int totalAssetValues(final List<Asset> assets) {
    return assets.stream()
                 .mapToInt(Asset::getValue)
                 .sum();
  }

  public static int totalBondValues(final List<Asset> assets) {
    return assets.stream()
                 .mapToInt(asset -> 
                    asset.getType() == AssetType.BOND ? asset.getValue() : 0)
                 .sum();
  }

  public static int totalStockValues(final List<Asset> assets) {
    return assets.stream()
                 .mapToInt(asset -> 
                    asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
                 .sum();
  }

  public static void main(final String[] args) {
    final List<Asset> assets = Arrays.asList(
      new Asset(Asset.AssetType.BOND, 1000),
      new Asset(Asset.AssetType.BOND, 2000),
      new Asset(Asset.AssetType.STOCK, 3000),
      new Asset(Asset.AssetType.STOCK, 4000)
    );
    
    System.out.println("//" + "START:TOTAL_ALL_OUTPUT");
    System.out.println("Total of all assets: " + totalAssetValues(assets));
    System.out.println("//" + "END:TOTAL_ALL_OUTPUT");

    System.out.println("//" + "START:TOTAL_BONDS_OUTPUT");
    System.out.println("Total of bonds: " + totalBondValues(assets));
    System.out.println("//" + "END:TOTAL_BONDS_OUTPUT");

    System.out.println("//" + "START:TOTAL_STOCKS_OUTPUT");
    System.out.println("Total of stocks: " + totalStockValues(assets));      
    System.out.println("//" + "END:TOTAL_STOCKS_OUTPUT");
  }
}
