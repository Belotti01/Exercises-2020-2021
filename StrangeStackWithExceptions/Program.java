public class Program {
	public static void main(String[]gnirtS) {
		for(int i = -1; i < 100; i++) {
			StrangeStackTest(i);
		}
	}

	private static void StrangeStackTest(int size) {
		StrangeStack<Integer> stack = new StrangeStack<Integer>();
		for(int i = 0; i <= size; i++) {
			stack.push((int)(Math.random() * 120 - 20));
		}
		try {
			System.out.println("Size:\t" + stack.size());
			System.out.println("Stack:\t" + stack.toString());		
			System.out.println("One-to-last value:\t" + stack.popSecondFromTop());
			System.out.println("Updated Stack:\t" + stack.toString() + "\n");	
		}catch(CustomStackException e) {
			//In questo caso conviene catturare CustomStackException anzichè il normale
			//tipo Exception, in quanto perderei accesso a <getStackSize()> altrimenti.
			//Il casting funziona anche per le Exception, ma fai finta che non sia così.
			System.out.println(e.getMessage());
			if(e.getStackSize() != -1)
				System.out.println("The Stack size was " + e.getStackSize());
		}
	}
}

































/*
                  '_,__.                               
                ~N&85KHPu;:`                           
               *Au111}x}1y2y~                          
               KDoy1lykktciY}=                         
               iB&&&gQB##QW}x~                         
                &dR&&8B##BRy}=                         
               _5HHR&dNE8Q&k1'                         
               vRddQBQ8QBBgNd`                         
               _RNd&QQQQQQQQK                          
                S5SRgQ8g8Qs!                           
                YdSR&QdqNg;                            
               "K5sKA&SPNQk-                           
           ."^ug0asW5DSPd&#q~-.`                       
       _~)]7x)/a#05NNR&&9&@Sx)rr^~!:-`                 
   `:ri1vr^^^;^y#@BggRg#B@@Wv)r****rrr^=-              
  !xr***^^^;;~;}&gQBQ&B##@Q})r****rrrrrr/^             
 .v*^;^;**^^;~~=^xkzsAWP&E]rr*****rr*rr*r|`            
 :v;;~;~^**^;;;=~/fRRd5WK1|*****^******^^r_            
 :r;~====^*^;~~~~*}SR9Dqz}r****^^^^^**^;;r_            
 !*~~=!!==^^^*^;;^xKWfKKz}r****^^^^^**;=^r_            
 ;|~===!r1sdDN}*^^rt0NKKkx*******vctyx^~^|-            
 r\~=!!vHAHSR5}^;^^xaSasj]*****^;rjd&gR2)*_            
 ||~=!:\tffAR5x;;;^*YckFk}*^***^!|KRgg&N}r:            
`vr=!=v]7yFaWx;=====rcjzyx*!~^^=!^c59ERj)^^^-          
_xrrvxv|^v1t}!!!!!!!=v1oocx;::!:::*}jP2\*^~~;^-        
^vr^//v*^^~=:_,:!!::!|ukc}v^:",,__:;r\*;^*^~;~`        
;r^;r})~=!!:",_,:::::*y21ix*=!:,_-"=*=!*vr**=`         
 :*;~=!!::,,"",_,:!!!=vy1}7)^=~!,--_:!!!~;*^`          
  !^;=!:!:,,":"__"!~^^xk1x/^r==;~!_-_!--,_.            
       _^!::::","_,=^*)y1^/r\r|;;;=!=^'                
       ~=!!::::::,__=^|2555NW2}/;^^^^*;`

  	     He's never gonna give you up
*/