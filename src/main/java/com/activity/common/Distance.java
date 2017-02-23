package com.activity.common;
 public class Distance {

    private static Double EARTH_RADIUS = 6378.137;

    private static Double rad(Double d){
        return d * Math.PI / 180.0;
    }

    public static Double GetDistance(String long_1, String lat_1, String long_2, String lat_2) {
    	/*boolean matches = long_1.matches("\\d*");
    	Double lat1=null;
    	Double long2=null;	
    	Double long1=null;
    	Double lat2=null;
    	if(long_1!=null&&lat_1!=null&&long_2!=null&&lat_2!=null
    			&&long_1.matches("\\d*")
    			&&lat_1.matches("\\d*")
    			&&long_2.matches("\\d*")
    			&&lat_2.matches("\\d*")
    			){
	    	 long1=Double.valueOf(long_1);
	    	 lat1=Double.valueOf(lat_1);
	    	 long2=Double.valueOf(long_2);
	    	 lat2=Double.valueOf(lat_2);
    	}else{
    		 long1=Double.valueOf(0.0);
	    	 lat1=Double.valueOf(0.0);
	    	 long2=Double.valueOf(0.0);
	    	 lat2=Double.valueOf(0.0);
    	}*/
    	
    	
    	Double lat1=null;
    	Double long2=null;	
    	Double long1=null;
    	Double lat2=null;
    	
    	try {
    		 long1=Double.valueOf(long_1);
	    	 lat1=Double.valueOf(lat_1);
	    	 long2=Double.valueOf(long_2);
	    	 lat2=Double.valueOf(lat_2);
		} catch (Exception e) {
			 long1=Double.valueOf(0.0);
	    	 lat1=Double.valueOf(0.0);
	    	 long2=Double.valueOf(0.0);
	    	 lat2=Double.valueOf(0.0);
		}
    	
        Double a, b, d, sa2, sb2;
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        a = lat1 - lat2;
        b = rad(long1 - long2);

        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2   * EARTH_RADIUS
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return d;
    }
    
    public static void main(String[] args) {
        //根据两点间的经纬度计算距离，单位：km
        System.out.println(GetDistance("8", "y", "yy", "yy"));
        System.out.println(GetDistance("117", "36", "1wer55", "36"));
        System.out.println(GetDistance("112.9084", "112.9084", "110.99", "112.9083"));
       /* System.out.println(GetDistance(121.5373, 38.86827, 121.5372, 38.86832));
        System.out.println(GetDistance(20.5, 118.2, 21.1, 117.6));
        System.out.println(GetDistance(121.445140,31.177779, 121.444832,31.179313));
*/    
        }
    
 }