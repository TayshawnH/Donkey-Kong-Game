/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import thekongmodel.LevelCollection;
import thekongmodel.LevelData;
import thekongmodel.PlayerProfileCollection;
import thekongmodel.SpriteDataCollection;
import thekongview.CommandView;
import thekongview.GameView;
import thekongview.HeroView;
import thekongview.LadderView;
import thekongview.LevelView;
import thekongview.PlayAreaView;
import thekongview.PrincessView;
import thekongview.StatusView;

/**
 *
 * @author Tay
 */
public class MainController extends Application {

    private static String playerProfileConfigFileName;
    private static String spriteConfigFileName;
    private static String objectConfigFileName;
    private static LevelData levelData;
    private static PlayerProfileCollection playerCollection;
    private static SpriteDataCollection spriteCollection;
    private static LevelCollection levelCollection;
    private static PlayAreaView playAreaView;

    @Override
    public void start(Stage primaryStage) {
        spriteConfigFileName = "SpriteConfig.txt";
        objectConfigFileName = "ObjectConfig.txt";
        playerProfileConfigFileName = "PlayerProfileConfig.txt";

        playerCollection = IOController.readPlayerProfiles(playerProfileConfigFileName);
        levelCollection = IOController.readObjectConfigFile(objectConfigFileName);
        spriteCollection = IOController.readSpriteConfigFile(spriteConfigFileName);
        LoginController lc = new LoginController(playerCollection);
        levelData = new LevelData(levelCollection.getLevel(0).getWidth(), levelCollection.getLevel(0).getHeight(),
        levelCollection.getLevel(0).getBackgroundImageFileName());

        playAreaView = new PlayAreaView(spriteCollection, levelCollection.getLevel(0));
        
        String tay = lc.getLoginProfile().getPlayerName();
        LevelView level = new LevelView(levelData);
        CommandView command = new CommandView();

        StatusView status = new StatusView(tay, 0);
        GameView gameV = new GameView(status, playAreaView, command);
        AnimationController ac = new AnimationController(playAreaView);

        command.getStartButton().setOnAction((ActionEvent event) -> {
            ac.start();
        });
        
        command.getEndButton().setOnAction((ActionEvent event)->{
            System.exit(0);
        });
        
        //root.getChildren().add(play);
        Scene scene = new Scene(gameV);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            private final double playerSpeed = 2.5;
            HeroView hero = playAreaView.getHero();
            
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT) {
                    playAreaView.getHero().setDirection(0.0);
                    playAreaView.getHero().setSpeed(playerSpeed);
                    

                }

                if (event.getCode() == KeyCode.LEFT) {
                    playAreaView.getHero().setDirection(180.0);
                    playAreaView.getHero().setSpeed(playerSpeed);
                }

                if (event.getCode() == KeyCode.UP) {
                    if (ac.heroLadder(playAreaView)) {
                        playAreaView.getHero().setDirection(270.0);
                        playAreaView.getHero().setSpeed(0.0);
                        
                    }

                    if ((ac.heroFloor(playAreaView) || ac.heroPlatform(playAreaView)) && !ac.heroLadder(playAreaView)) {
                        ac.heroJump = true;
                        ac.startFrame = ac.frameCount;
                    }

                }
                if (event.getCode() == KeyCode.DOWN) {
                    if (ac.heroLadder(playAreaView)) 
                        playAreaView.getHero().setDirection(90);
                        playAreaView.getHero().setSpeed(0.0);
                }

            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            private final double playerSpeed = 5.0;

            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT) {
                    playAreaView.getHero().setDirection(0.0);
                    playAreaView.getHero().setSpeed(0.0);

                }

                if (event.getCode() == KeyCode.LEFT) {
                    playAreaView.getHero().setDirection(180.0);
                    playAreaView.getHero().setSpeed(0.0);
                }
                
                if(event.getCode() == KeyCode.UP){
                    playAreaView.getHero().setDirection(270.0);
                    playAreaView.getHero().setSpeed(0.0);
                }
                
                if(event.getCode() == KeyCode.DOWN){
                    playAreaView.getHero().setDirection(90.0);
                    playAreaView.getHero().setSpeed(0.0);
                    
                    for(int i = 0; i < playAreaView.getLevelView().getNumLadders(); i++){
                        LadderView ladderV = playAreaView.getLevelView().getLadder(i);
                        
                    }
                }
                
            }

        });

    }
    
    

    public void savePlayerData() {
        IOController.writePlayerProfiles(playerCollection);
    }

    public static void main(String[] args) {
        playerCollection = IOController.readPlayerProfiles(args[0]);

         levelCollection = IOController.readObjectConfigFile(args[1]);

        spriteCollection = IOController.readSpriteConfigFile(args[2]);

        launch(args);
    }

}
