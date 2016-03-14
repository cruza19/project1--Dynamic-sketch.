//////// Project 1 -AC

//// float: setting the horizon and minion floating x, y.


float sunX, sunY;
float xMin=200, yMin=200, dxMin=3, dyMin=2;
float horizon;
float nugR;
float nugG;
float nugB;
int score=1;
float nugX=335; 
float nugY=230;

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
  setting();  
  minmove();    // Don't forget to move it!
  minshow();
  nugshow();
  chasenug();
  msg();
  out();
}

/// SCENE: sky, grass, sun, house, Minion at (x,y)
void scene()
{
  background( 150, 120, 255 );              // Sky Purple.
  sunshow();
  fill( 100, 235, 200 );                    // Mint
  noStroke();
  rectMode( CORNER );
  rect( 0, horizon, width, height );
}


// House on horizon (150).
void setting()
/////House

{ 
  fill( 250, 100, 0 );                // Orange
  rectMode (CENTER);
  rect( 335, horizon-40, 150, 130, 7 );       
  fill( 129, 3, 26);                // Maroon
  triangle( 235, horizon-100, 435, horizon-100, 335, 5 );
  /////Window 1
  fill(255, 255, 255);                
  rect(290, horizon-70, 40, 40, 7);
  /////Window 2
  fill(255, 255, 255);                
  rect(380, horizon-70, 40, 40, 7);
  /////Door
  fill(0);                
  rect(335, horizon-8, 55, 65, 7);


  /////Trees

  fill(103, 79, 65);                 //Trunk1
  rectMode (CENTER);
  rect(500, horizon-30, 20, 60);

  fill(124, 209, 107);               //Leaf1
  ellipseMode(CENTER);
  ellipse(500, horizon-70, 50, 80); 


  fill(103, 79, 65);                 //Trunk3
  rectMode (CENTER);
  rect(560, horizon-30, 20, 60);

  fill(104, 129, 57);               //Leaf3
  ellipseMode(CENTER);
  ellipse(560, horizon-70, 50, 80); 

  fill(103, 79, 65);                 //Trunk2
  rectMode (CENTER);
  rect(530, horizon-30, 20, 60);

  fill(184, 229, 157);               //Leaf2
  ellipseMode(CENTER);
  ellipse(530, horizon-70, 50, 80); 


  fill(103, 79, 65);                 //Trunk4
  rectMode (CENTER);
  rect(100, horizon-30, 40, 60);

  fill(55, 216, 24);                  //Leaf4
  triangle(50, horizon-55, 100, horizon-125, 150, horizon-55);
  triangle(50, horizon-85, 100, horizon-140, 150, horizon-85);
  triangle(55, horizon-110, 100, horizon-165, 145, horizon-110);
}



/////Trees




void sunmove()                        ///sun move
{
  float sunset;


  if (sunX > width) {
    sunX=  0;
  }
  sunX=(sunX + 1);
  sunset=(150 + cos(sunX*.009)*125);
  sunY=(sunset);
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
  nugR=random(255);
  nugG=random(255);
  nugB=random(255);
  noStroke();
  ellipseMode(CENTER);
  fill(nugR, nugG, nugB);
  ellipse(nugX, nugY, 25, 25);
  ellipse(nugX-17, nugY, 12, 10);
  ellipse(nugX+17, nugY, 12, 10);
  ellipse(nugX, nugY-17, 10, 12);
  ellipse(nugX, nugY+17, 10, 12);
}
/// Minion
void minshow()
{
  rectMode(CENTER);
  noStroke();
  fill(351, 255, 26);
  rect( xMin, yMin, 75, 100); //body
  arc( xMin, yMin-50, 75, 75, PI, TWO_PI); //head

  eyes();

  noFill();
  arc( xMin, yMin, 30, 30, HALF_PI, PI);  //mouth
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

  textSize(15);                              //name
  fill(106, 255, 234);
  text("Minion", xMin-20, yMin+45);
}  


////EVENTS
void mousePressed() {          ///nug appears on click
  nugX= mouseX;
  nugY= mouseY;
}

void chasenug() {

  if (dist(xMin, yMin, nugX, nugY) < 25) {   ///Minion chasing nugget
    nugX= random(10, 650);
    nugY = random(10, 400);
    score = score+1;
  }
}
void out() {                        //// quit after 10 times the creature eats the nugget
  if (score==10 || key=='q') {
    exit();
  }
}
/// MESSAGES
void msg()
{
  textSize(22);
  fill(250, 250, 250);
  text( "Proyect 1.", width/50, 20 );
  text( "=)", width/20, 45 );
  fill( 0, 0, 0 );
  text( "Abel Cruz", 10, height-10 );
  textSize(20);
  fill(250, 50, 0);
  text(score, 650, horizon-220);
}  
