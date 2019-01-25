/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thekongcontroller;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import thekongview.BarrelView;
import thekongview.HeroView;
import thekongview.LadderView;
import thekongview.PlatformView;
import thekongview.PlayAreaView;


/**
 *
 * @author Tay
 */
public class AnimationController extends AnimationTimer {

    private static PlayAreaView playareaview;
    private HeroView hero;
    public final double playerSpeed = 3;
    public final double gravity = 2.899;
    public boolean heroJump;
    public long frameCount;
    public long startFrame;
    
    
    
    
    public AnimationController(PlayAreaView playareaview) {
        this.playareaview = playareaview;
        this.hero = playareaview.getHero();
        this.heroJump = false;
        this.frameCount = 0;
        
    }

    @Override
    public void handle(long now) {
        HeroView heroV = playareaview.getHero();

        if (heroV.getCenterX() - heroV.getBoundingRadius() < 0) {
            
            heroV.setDirection(0.0);
            heroV.setSpeed(1.0);
            heroV.move();
            heroV.setSpeed(0.0);

        }
        if (heroV.getCenterX() + heroV.getBoundingRadius() > playareaview.getWidth()) {
            heroV.setDirection(180.0);
            heroV.setSpeed(1.0);
            heroV.move();
            heroV.setSpeed(0.0);
        }

        
        if(!heroLadder(playareaview) && !heroFloor(playareaview) && !heroPlatform(playareaview)){
            hero.setY(hero.getY() + gravity);
            
        }
        
        
        if(hero.getDirection() == 270 || hero.getDirection() == 90){
            
            if(heroLadder(playareaview)){
                hero.setSpeed(playerSpeed);
            }
            else{
                hero.setSpeed(0);
                hero.setDirection(0);
                
            }
        }
        
        if(heroJump){
            if(frameCount - startFrame < 10){
                hero.setY(hero.getY() -(gravity * 2.5) );
            }
            else{
                heroJump = false;
            }
        }
        
        
        
        playareaview.moveSprites();
        frameCount += 1;
        

    }
    
    public static void initialize(){
        
        Timer time = new Timer();
        time.schedule(new TimerTask(){
            
            
            @Override
            public void run(){
                playareaview.getBarrel(30);
                
            }
        }, 500
        
        );
        
       
    }
    
    public boolean heroLadder(PlayAreaView playareaview){
        LadderView ladder;
        for(int i = 0; i<playareaview.getLevelView().getNumLadders(); i++){
            ladder = playareaview.getLevelView().getLadder(i);
            
            if(hero.getBoundsInLocal().intersects(ladder.getBoundsInLocal())){
                return true;
            }
        }
        return false;
    }
    
    public boolean heroFloor(PlayAreaView playareaview){
        if(hero.getY() + hero.getBoundingRadius() * 2 >= playareaview.getHeight()){
            return true;
        }
        return false;
    }
    
    public boolean heroPlatform(PlayAreaView playareaview){
        PlatformView platformV;
        
        for(int i=0; i<playareaview.getLevelView().getNumPlatforms(); i++){
            platformV = playareaview.getLevelView().getPlatformView(i);
            
            if(hero.getY() >= platformV.getY() - hero.getBoundingRadius() * 2 && hero.getY() <= platformV.getY() + (platformV.getHeight() - hero.getBoundingRadius() * 2)) {
                if(hero.getX() > platformV.getX() && hero.getX() < platformV.getX() + platformV.getWidth() || hero.getX() + (hero.getBoundingRadius() * 2) > platformV.getX() && 
                        hero.getX() + hero.getBoundingRadius() * 2 < platformV.getX() + platformV.getWidth()){
                    return true;
                }
                
            }
        
        
        }
        
        return false;
        
    }
    
}
