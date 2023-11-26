public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet (Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.yyVel;
		yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
	}

	public double calcDistance (Planet p){
		double distance= Math.sqrt((p.xxPos-xxPos)*(p.xxPos-xxPos) + (p.yyPos-yyPos)*(p.yyPos-yyPos));
		return distance;
	}
	public double calcForceExertedBy(Planet p){
		double r=calcDistance(p);
		double force = G*p.mass*mass/(r*r);
		return force;
	}
	public double calcForceExertedByX(Planet p){
		double dx=p.xxPos-xxPos;
        double xF=calcForceExertedBy(p)*dx/calcDistance(p);
        return xF;
	}
	public double calcForceExertedByY(Planet p){
		double dy=p.yyPos-yyPos;
        double yF=calcForceExertedBy(p)*dy/calcDistance(p);
        return yF;
	}
	public double calcNetForceExertedByX(Planet[] all){
		double xNet=0;
		for(Planet p : all){
			if(this.equals(p)){
				continue;
			}
			xNet+=this.calcForceExertedByX(p);
		}
		return xNet;
	}
	public double calcNetForceExertedByY(Planet[] all){
		double yNet=0;
		for(Planet p : all){
			if(this.equals(p)){
				continue;
			}
			yNet+=this.calcForceExertedByY(p);
		}
		return yNet;
	}
	public void update (double dt, double fX, double fY){
		/** to update its position and velocity*/
		double aX=fX/mass;
		double aY=fY/mass;
		xxVel+=aX*dt;
		yyVel+=aY*dt;
		xxPos+=xxVel*dt;
		yyPos+=yyVel*dt;
	}
	public void draw (){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}