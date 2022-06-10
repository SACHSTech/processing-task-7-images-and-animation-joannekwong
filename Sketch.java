import processing.core.PApplet;
import processing.core.PImage; //import the PImage library

public class Sketch extends PApplet {

  PImage imgPlayer; // declare a global image variable
  PImage imgBasketball;
  PImage imgBackground;
  // Set initial positions and speeds for the clouds

  float fltPlayerX = 300;
  float fltPlayerY = 300;

  float fltBasketballX = 300;
  float fltBasketballY = 270;

  float fltCloudX1 = 20;
  float fltCloudY1 = 50;
  
  float fltCloudX2 = 100;
  float fltCloudY2 = 30;
  
  float fltCloudSpeedX1 = 2;
  float fltCloudSpeedY1 = 1;
  
  float fltCloudSpeedX2 = 4;
  float fltCloudSpeedY2 = 3;

  public void settings() {
    size(400, 400);
  
  }

  public void setup() {
    // Load all images of player, basketball, and backround
    imgPlayer = loadImage("characterBlue.png"); 

    imgBasketball = loadImage("basketball.png");


    imgBackground = loadImage("background.jpg");
    imgBackground.resize(imgBackground.width/2,imgBackground.height/2);


  }

  public void draw() {
    //Draw the images
    background(128);
    image(imgBackground, 0, 0);

    image(imgBasketball, fltBasketballX, fltBasketballY);

    image(imgPlayer,fltPlayerX,fltPlayerY);
    
    //Move basketball in parabola
    fltBasketballX -= 2.5;
    fltBasketballY -= 9 + (-.0007 * ((300 - fltBasketballX) * (300 - fltBasketballX)));



    //draw clouds and move
    ellipse(fltCloudX1, fltCloudY1, 50, 20);
    ellipse(fltCloudX2, fltCloudY2, 70, 20);
    fltCloudX1 += fltCloudSpeedX1/3;
    fltCloudY1 += fltCloudSpeedY1/3;
    fltCloudX2 += fltCloudSpeedX2/3;
    fltCloudY2 += fltCloudSpeedY2/3;
    
    if (fltCloudX1 < 0+10 || fltCloudX1 > width-10) {
      fltCloudSpeedX1 *= -1;
    }
  
    if (fltCloudY1 < 0+10  || fltCloudY1 > 60) {
      fltCloudSpeedY1 *= -1;
    }
    if (fltCloudX2 < 0+10 || fltCloudX2 > width-10) {
      fltCloudSpeedX2 *= -1;
    }
  
    if (fltCloudY2 < 0+10  || fltCloudY2 > 60) {
      fltCloudSpeedY2 *= -1;
    }

 
  }
}