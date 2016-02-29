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
  house();  
  minmove();    // Don't forget to move it!
  minshow();
  nugshow();
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
void house()
{ 
  fill( 250,100,0 );                // Orange
  rectMode (CENTER);
  rect( 335, horizon-40, 150,130,7 );       
  fill( 129, 3, 26);                // Maroon
  triangle( 235,horizon-100, 435,horizon-100, 335,5 );
}
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
  fill(255, 255, 0);                      ///Yellow Sun
  ellipse( sunX, sunY, 90, 90 );
}
  
void nugshow()                           ////Nugget show
{
 
  ellipseMode(CENTER);
  fill(255, 155, 120);
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
if (nugX >= xMin+10) {
  nugX= random(600);
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
