//////// Project 1 -AC

//// float: setting the horizon and minion floating x, y.

float nugX, nugY;
float sunX, sunY;
float xMin=200, yMin=200, dxMin=3, dyMin=2;
float horizon;


//// SETUP: size, parameters for the horizon size and window size
void setup()
{
  size(700, 450);
  horizon=  height / 1.85;
  //
  smooth();
  ellipseMode(CENTER);
}


/// FRAME: scene, house, Minion
void draw()
{
  scene();
  sunmove();
  sunshow();
  setting();  
  minmove();    // Don't forget to move it!
  minshow();
  nugshow();
  chasenug();
  msg();
  
}

/// SCENE: sky, grass, sun, house, Minion at (x,y)
void scene()
{
  background( 150,120,255 );              // Sky Purple.
  fill( 100,235,200 );                    // Mint
  noStroke();
  rectMode( CORNER );
  rect( 0,horizon, width,height ); 
  
}


// House on horizon (150).
void setting()
/////House

{ 
  fill( 250,100,0 );                // Orange
  rectMode (CENTER);
  rect( 335, horizon-40, 150,130,7 );       
  fill( 129, 3, 26);                // Maroon
  triangle( 235,horizon-100, 435,horizon-100, 335,5 );
/////Window 1
  fill(255,255,255);                
  rect(290, horizon-70, 40,40,7);
/////Window 2
  fill(255,255,255);                
  rect(380, horizon-70, 40,40,7);
/////Door
  fill(0);                
  rect(335, horizon-8, 55,65,7);


/////Trees
  
  fill(103, 79, 65);                 //Trunk1
  rectMode (CENTER);
  rect(500, horizon-30, 20,60);
  
  fill(124, 209, 107);               //Leaf1
  ellipseMode(CENTER);
  ellipse(500, horizon-70, 50, 80); 
  
  
  fill(103, 79, 65);                 //Trunk3
  rectMode (CENTER);
  rect(560, horizon-30, 20,60);
  
  fill(104, 129, 57);               //Leaf3
  ellipseMode(CENTER);
  ellipse(560, horizon-70, 50, 80); 
  
  fill(103, 79, 65);                 //Trunk2
  rectMode (CENTER);
  rect(530, horizon-30, 20,60);
  
  fill(184, 229, 157);               //Leaf2
  ellipseMode(CENTER);
  ellipse(530, horizon-70, 50, 80); 
  
  
  fill(103, 79, 65);                 //Trunk4
  rectMode (CENTER);
  rect(100, horizon-30, 40,60);
  
  fill(55, 216, 24);                  //Leaf4
  triangle(50, horizon-55, 100, horizon-125, 150, horizon-55);
  triangle(50, horizon-85, 100, horizon-140, 150, horizon-85);
  triangle(55, horizon-110, 100, horizon-165, 145, horizon-110);
}



/////Trees




void sunmove()                        ///sun move
{
  sunY=75;
  if (sunX > width) {
    sunX=  0;
    
  }
  sunX=  sunX + 1;
}
                            //// Move Minion
void minmove()
{
  //// Check boundaries.
  


  //// Move Him
  xMin=  xMin  +  (nugX-xMin) / 55;
  yMin=  yMin  +  (nugY-yMin) / 55;
}
void sunshow()                            ///sun show
{
  ellipseMode(CENTER);
  fill(255, 177, 8);                      ///Yellow Sun
  ellipse( sunX, sunY, 90, 90 );
}
  
void nugshow()                           ////Nugget show
{
 
  ellipseMode(CENTER);
  fill(152, 118, 43);
  ellipse(nugX, nugY, 60,30);


}
/// Minion
void minshow()
{
  rectMode(CENTER);
  noStroke();
  fill(351, 255, 26);
  rect( xMin,yMin, 75,100); //body
  arc( xMin, yMin-50, 75, 75, PI, TWO_PI); //head
  
  eyes();
    
  noFill();
  arc( xMin, yMin, 30, 30, HALF_PI, PI);
}

void eyes()
{
  fill(255);
  stroke(0);
  ellipse( xMin-15, yMin-50, 30, 30) ;    //eyes
  ellipse( xMin+15, yMin-50, 30, 30);
  fill(0);
  ellipse( xMin-10, yMin-50, 14, 14);     //eye balls
  ellipse( xMin+10, yMin-50, 14, 14);
}  


////EVENTS
void mousePressed()  {
  nugX= mouseX;
  nugY= mouseY;
}

void chasenug(){
if ((xMin > nugX-10) || (yMin > nugY-10)) { 
    nugX = random(0, 600);
    nugY = random(0, 400);
  
  
  
   

}
}



/// MESSAGES
void msg()
{
  fill(250, 250, 250);
  text( "Proyect 1.", width/50,20 );
  text( "=)", width/20,35 );
  fill( 0,0,0 );
  text( "Abel Cruz", 10,height-10 );
}  
