public class NBody{
	public static double readRadius(String inputfile){
		In in = new In(inputfile);
		int firstItem = in.readInt();
		double radius = in.readDouble();
		return radius;	
	}

	public static Planet[] readPlanets(String inputfile){
		In in = new In(inputfile);
		int count = in.readInt();
		double radius = in.readDouble();
		Planet[] planets= new Planet[count];
		for(int i = 0; i<count; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName= in.readString();
			planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);		
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		In in = new In(filename);
		final int count = in.readInt();
		
		double radius = readRadius(filename);
		Planet[] planet = readPlanets(filename);

		StdDraw.setCanvasSize(512, 512);
		//set the img as background
		StdDraw.setScale(-radius, radius); // Set the scale

		StdDraw.enableDoubleBuffering();

		double time = 0;
		double[] xForces = new double[count];
		double[] yForces = new double[count];
		while(time <= T ){
			StdDraw.clear();
		    StdDraw.picture(0.0, 0.0, "images/starfield.jpg", 2*radius, 2*radius);
		    
			for(int i=0; i<count; i++){
				xForces[i] = planet[i].calcNetForceExertedByX(planet);
				yForces[i] = planet[i].calcNetForceExertedByY(planet);
				planet[i].update(dt, xForces[i], yForces[i]);
			}
		    for(Planet body: planet){
		    	body.draw();
		    }
		    StdDraw.show();
		    StdDraw.pause(10);

			time += dt;
		}

		StdOut.printf("%d\n", planet.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planet.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planet[i].xxPos, planet[i].yyPos, planet[i].xxVel,
                planet[i].yyVel, planet[i].mass, planet[i].imgFileName);
		}
		
	}
}