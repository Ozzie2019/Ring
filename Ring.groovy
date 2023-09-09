import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Isosceles
import eu.mihosoft.vrl.v3d.Wedge
import eu.mihosoft.vrl.v3d.Toroid
hight = 10
width = hight
length = width
earOg = 
	new Wedge(width,5,hight).toCSG()
ear= earOg
		  .movez(30)
		  .movex(-10)
	
ewa = 
	new Wedge(length,5,hight).toCSG()
	
ewa = ewa.roty(90)
		 .movez(30)
		 
jaw = 
    new Isosceles(5,10,5).toCSG()

jaw = jaw.roty(180)
         .rotz(90)
		 .movex(-5)
		 .movez(30)

ring = new Toroid(9.3745, 12, 10, 10).toCSG()
ring = ring.movez(17.5)
		   .movey(5)
		   .movex(-5)
CSG allUnion = CSG.unionAll([ear,ewa,jaw,])
.movex(0)
.movez(2.5)
.movey(2.5)
Finring = CSG.unionAll([ring, allUnion])
.rotx(90)
.toZMin()
return [Finring]