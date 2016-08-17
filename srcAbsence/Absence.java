import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public abstract class Absence {
	
	Date date;
	String reason;
	String typ;
	int numberOfH;
    //Datumformatierung
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");;

	
	public Absence (String  datum, String reason){
		// TODO Auto-generated method stub
		
		this.reason = reason;
		try {
			this.date = sdf.parse(datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void setDate(Date date){
	  this.date =	date;
	}
	public void setReason(String reason){
      this.reason = reason;	
	}

	public Date getDate(){
	
		return this.date;
	}
	
	public String getReason(){
		return this.reason;
	}
	
	abstract int getNumbersOfH();
	
	

	    public static Comparator<Absence> AbsenceDateComparator = new Comparator<Absence>() {

	    	public int compare(Absence s1, Absence s2) {
	    	   Date AbsenceA = s1.getDate();
	    	   Date AbsenceB = s2.getDate();

	           return AbsenceA.compareTo(AbsenceB);


	        }};

		public String getTyp() {
			// TODO Auto-generated method stub
			return this.typ;
		}



}
