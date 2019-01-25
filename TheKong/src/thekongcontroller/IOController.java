/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import thekongmodel.BarrelData;
import thekongmodel.HeroData;
import thekongmodel.KongData;
import thekongmodel.LadderData;
import thekongmodel.LevelCollection;
import thekongmodel.LevelData;
import thekongmodel.PlatformData;
import thekongmodel.PlayerProfile;
import thekongmodel.PlayerProfileCollection;
import thekongmodel.PrincessData;
import thekongmodel.SpriteDataCollection;

/**
 *
 * @author CCannon
 */
public class IOController {

    public static LevelCollection readObjectConfigFile(String objectConfigFileName) {
        LevelCollection collection = new LevelCollection(objectConfigFileName);
        
        try {
            Scanner reader = new Scanner(new File(objectConfigFileName));
            
            while(reader.hasNext()) {
                String[] levelLine = reader.nextLine().split(",");
                LevelData newLevel = new LevelData(Double.parseDouble(levelLine[0].trim()), Double.parseDouble(levelLine[1].trim()), levelLine[2].trim());
                String[] ladderLine = reader.nextLine().split(",");
                while(!ladderLine[0].trim().equals("*")) {
                    LadderData newLadder = new LadderData(Double.parseDouble(ladderLine[0].trim()),
                        Double.parseDouble(ladderLine[1].trim()), Double.parseDouble(ladderLine[2].trim()),
                        Double.parseDouble(ladderLine[3].trim()), ladderLine[4].trim());
                    newLevel.addLadderData(newLadder);
                    ladderLine = reader.nextLine().split(",");
                }
                
                String[] platformLine = reader.nextLine().split(",");
                while(!platformLine[0].trim().equals("*")) {
                    PlatformData newPlatform = new PlatformData(Double.parseDouble(platformLine[0].trim()),
                        Double.parseDouble(platformLine[1].trim()), Double.parseDouble(platformLine[2].trim()),
                        Double.parseDouble(platformLine[3].trim()), platformLine[4].trim());
                    newLevel.addPlatformData(newPlatform);
                    platformLine = reader.nextLine().split(",");
                }
                collection.addLevel(newLevel);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Unable to read Object Config File from " + objectConfigFileName + ", returning empty collection.");
        }
        
        return collection;
    }
    
    public static PlayerProfileCollection readPlayerProfiles(String playerProfileConfigFileName) {
        PlayerProfileCollection collection = new PlayerProfileCollection(playerProfileConfigFileName);

        try {
            Scanner reader = new Scanner(new File(playerProfileConfigFileName));
            String activeProfileName = reader.nextLine().split(",")[0].trim();

            while (reader.hasNext()) {
                String[] playerData = reader.nextLine().split(",");
                PlayerProfile newProfile = new PlayerProfile(playerData[0]);
                newProfile.setHighScore(Integer.parseInt(playerData[1].trim()));
                newProfile.setTotalScore(Integer.parseInt(playerData[2].trim()));
                newProfile.setGamesPlayed(Integer.parseInt(playerData[3].trim()));
                newProfile.setLevelsWon(Integer.parseInt(playerData[4].trim()));

                collection.addPlayerProfile(newProfile);
            }

            for (int i = 0; i < collection.getNumPlayerProfiles(); i++) {
                if (collection.getPlayerProfile(i).getPlayerName().equalsIgnoreCase(activeProfileName)) {
                    collection.setActiveProfile(collection.getPlayerProfile(i));
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Unable to read PlayerProfileCollection from " + playerProfileConfigFileName + ", returning an empty collection");
        }

        return collection;
    }

    public static void writePlayerProfiles(PlayerProfileCollection collection) {
        try {
            PrintWriter writer = new PrintWriter(new File(collection.getPlayerProfileConfigFileName()));
            writer.println(collection.toString());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Unable to write PlayerProfileCollection to file " + collection.getPlayerProfileConfigFileName());
        }
    }

    public static SpriteDataCollection readSpriteConfigFile(String spriteConfigFileName) {
        SpriteDataCollection collection = new SpriteDataCollection();

        try {
            Scanner reader = new Scanner(new File(spriteConfigFileName));

            String[] heroLineOne = reader.nextLine().split(",");
            HeroData hd = new HeroData(Double.parseDouble(heroLineOne[0].trim()),
                    Double.parseDouble(heroLineOne[1].trim()), 
                    Double.parseDouble(heroLineOne[2].trim()), 
                    Double.parseDouble(heroLineOne[3].trim()),
                    heroLineOne[4].trim());
            
            String[] heroLineTwo = reader.nextLine().split(" ");
            hd.setRunningLeftValuesOne(Double.parseDouble(heroLineTwo[0].trim()),
                    Double.parseDouble(heroLineTwo[1].trim()), 
                    Double.parseDouble(heroLineTwo[2].trim()), 
                    Double.parseDouble(heroLineTwo[3].trim()));
            
            String[] heroLineThree = reader.nextLine().split(" ");
            hd.setRunningLeftValuesTwo(Double.parseDouble(heroLineThree[0].trim()),
                    Double.parseDouble(heroLineThree[1].trim()), 
                    Double.parseDouble(heroLineThree[2].trim()), 
                    Double.parseDouble(heroLineThree[3].trim()));
            
            String[] heroLineFour = reader.nextLine().split(" ");
            hd.setFacingLeftValues(Double.parseDouble(heroLineFour[0].trim()),
                    Double.parseDouble(heroLineFour[1].trim()), 
                    Double.parseDouble(heroLineFour[2].trim()), 
                    Double.parseDouble(heroLineFour[3].trim()));
            
            String[] heroLineFive = reader.nextLine().split(" ");
            hd.setFacingRightValues(Double.parseDouble(heroLineFive[0].trim()),
                    Double.parseDouble(heroLineFive[1].trim()), 
                    Double.parseDouble(heroLineFive[2].trim()), 
                    Double.parseDouble(heroLineFive[3].trim()));
            
            String[] heroLineSix = reader.nextLine().split(" ");
            hd.setRunningRightValuesOne(Double.parseDouble(heroLineSix[0].trim()),
                    Double.parseDouble(heroLineSix[1].trim()), 
                    Double.parseDouble(heroLineSix[2].trim()), 
                    Double.parseDouble(heroLineSix[3].trim()));
            
            String[] heroLineSeven = reader.nextLine().split(" ");
            hd.setRunningRightValuesTwo(Double.parseDouble(heroLineSeven[0].trim()),
                    Double.parseDouble(heroLineSeven[1].trim()), 
                    Double.parseDouble(heroLineSeven[2].trim()), 
                    Double.parseDouble(heroLineSeven[3].trim()));
            
            String[] kongLineOne = reader.nextLine().split(",");
            KongData kd = new KongData(Double.parseDouble(kongLineOne[0].trim()),
                    Double.parseDouble(kongLineOne[1].trim()), 
                    Double.parseDouble(kongLineOne[2].trim()), 
                    Double.parseDouble(kongLineOne[3].trim()),
                    kongLineOne[4].trim());
            
            String[] kongLineTwo = reader.nextLine().split(" ");
            kd.setMovingLeftValues(Double.parseDouble(kongLineTwo[0].trim()),
                    Double.parseDouble(kongLineTwo[1].trim()), 
                    Double.parseDouble(kongLineTwo[2].trim()), 
                    Double.parseDouble(kongLineTwo[3].trim()));
            
            String[] kongLineThree = reader.nextLine().split(" ");
            kd.setMovingRightValues(Double.parseDouble(kongLineThree[0].trim()),
                    Double.parseDouble(kongLineThree[1].trim()), 
                    Double.parseDouble(kongLineThree[2].trim()), 
                    Double.parseDouble(kongLineThree[3].trim()));
            
            String[] kongLineFour = reader.nextLine().split(" ");
            kd.setFacingForwardValues(Double.parseDouble(kongLineFour[0].trim()),
                    Double.parseDouble(kongLineFour[1].trim()), 
                    Double.parseDouble(kongLineFour[2].trim()), 
                    Double.parseDouble(kongLineFour[3].trim()));
            
            String[] kongLineFive = reader.nextLine().split(" ");
            kd.setThrowingBarrelValues(Double.parseDouble(kongLineFive[0].trim()),
                    Double.parseDouble(kongLineFive[1].trim()), 
                    Double.parseDouble(kongLineFive[2].trim()), 
                    Double.parseDouble(kongLineFive[3].trim()));

            String[] princessLineOne = reader.nextLine().split(",");
            PrincessData pd = new PrincessData(Double.parseDouble(princessLineOne[0].trim()),
                    Double.parseDouble(princessLineOne[1].trim()), 
                    Double.parseDouble(princessLineOne[2].trim()), 
                    Double.parseDouble(princessLineOne[3].trim()),
                    princessLineOne[4].trim());
            
            String[] princessLineTwo = reader.nextLine().split(" ");
            pd.setWalkingLeftValuesOne(Double.parseDouble(princessLineTwo[0].trim()),
                    Double.parseDouble(princessLineTwo[1].trim()), 
                    Double.parseDouble(princessLineTwo[2].trim()), 
                    Double.parseDouble(princessLineTwo[3].trim()));
            
            String[] princessLineThree = reader.nextLine().split(" ");
            pd.setWalkingLeftValuesTwo(Double.parseDouble(princessLineThree[0].trim()),
                    Double.parseDouble(princessLineThree[1].trim()), 
                    Double.parseDouble(princessLineThree[2].trim()), 
                    Double.parseDouble(princessLineThree[3].trim()));
            
            String[] princessLineFour = reader.nextLine().split(" ");
            pd.setWalkingRightValuesOne(Double.parseDouble(princessLineFour[0].trim()),
                    Double.parseDouble(princessLineFour[1].trim()), 
                    Double.parseDouble(princessLineFour[2].trim()), 
                    Double.parseDouble(princessLineFour[3].trim()));
            
            String[] princessLineFive = reader.nextLine().split(" ");
            pd.setWalkingRightValuesTwo(Double.parseDouble(princessLineFive[0].trim()),
                    Double.parseDouble(princessLineFive[1].trim()), 
                    Double.parseDouble(princessLineFive[2].trim()), 
                    Double.parseDouble(princessLineFive[3].trim()));

            String[] barrelLineOne = reader.nextLine().split(",");
            BarrelData bd = new BarrelData(Double.parseDouble(barrelLineOne[0].trim()),
                    Double.parseDouble(barrelLineOne[1].trim()), 
                    Double.parseDouble(barrelLineOne[2].trim()), 
                    Double.parseDouble(barrelLineOne[3].trim()),
                    barrelLineOne[4].trim());

            String[] barrelLineTwo = reader.nextLine().split(" ");
            bd.setHorizontalValues(Double.parseDouble(barrelLineTwo[0].trim()),
                    Double.parseDouble(barrelLineTwo[1].trim()), 
                    Double.parseDouble(barrelLineTwo[2].trim()), 
                    Double.parseDouble(barrelLineTwo[3].trim()));
            
            String[] barrelLineThree = reader.nextLine().split(" ");
            bd.setRollingValuesOne(Double.parseDouble(barrelLineThree[0].trim()),
                    Double.parseDouble(barrelLineThree[1].trim()), 
                    Double.parseDouble(barrelLineThree[2].trim()), 
                    Double.parseDouble(barrelLineThree[3].trim()));
            
            String[] barrelLineFour = reader.nextLine().split(" ");
            bd.setRollingValuesTwo(Double.parseDouble(barrelLineFour[0].trim()),
                    Double.parseDouble(barrelLineFour[1].trim()), 
                    Double.parseDouble(barrelLineFour[2].trim()), 
                    Double.parseDouble(barrelLineFour[3].trim()));
            
            String[] barrelLineFive = reader.nextLine().split(" ");
            bd.setRollingValuesThree(Double.parseDouble(barrelLineFive[0].trim()),
                    Double.parseDouble(barrelLineFive[1].trim()), 
                    Double.parseDouble(barrelLineFive[2].trim()), 
                    Double.parseDouble(barrelLineFive[3].trim()));
            
            String[] barrelLineSix = reader.nextLine().split(" ");
            bd.setRollingValuesFour(Double.parseDouble(barrelLineSix[0].trim()),
                    Double.parseDouble(barrelLineSix[1].trim()), 
                    Double.parseDouble(barrelLineSix[2].trim()), 
                    Double.parseDouble(barrelLineSix[3].trim()));
            
            collection.setHeroData(hd);
            collection.setKongData(kd);
            collection.setPrincessData(pd);
            collection.setBarrelData(bd);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Unable to read SpriteDataCollection from " + spriteConfigFileName + ", returning an empty collection");
        }

        return collection;
    }
}
