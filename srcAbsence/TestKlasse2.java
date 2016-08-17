import java.util.List;


public class TestKlasse2 {
	static Subject De;
	static Subject Fr;
	static Subject En;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	LadenDerFacher();
	
	//Green - absenzen unterhalb der grenze
	FAbsenzProFachSetzenDe(De);
 	 	
	//Orange - abenzen gleich viel , wie erlaubt
	FAbsenzProFachSetzenFr(Fr);
	//Red - Absenzen überschreittung
	FAbsenzProFachSetzenEn(En);

	OuptuAufbereitungProFach(De);
	OuptuAufbereitungProFach(Fr);
	OuptuAufbereitungProFach(En);

	
	} 
      
		
	
	 public static void LadenDerFacher(){
	       De = new Subject("Deutsch",4 );
	       Fr = new Subject("Franz",5 );
	       En = new Subject("Englisch",7 );

	 }
	
     public static void AusgabeAllerNoten(List<Absence> list) {
      int i = 0;
      while (i < list.size()) {
    	  if(list.get(i).getTyp() == "A")
    	  System.out.println(" " + list.get(i).getDate()+ " , " + list.get(i).getReason() + " , " + list.get(i).getTyp() + " , " + list.get(i).getNumbersOfH() ) ;
    	  else{
        	  System.out.println(" " + list.get(i).getDate()+ " , " + list.get(i).getReason() + " , " + list.get(i).getTyp()) ;    		  
    	  }
			i++;
		}
     }
     
     public static void OuptuAufbereitungProFach(Subject tempFach){
        
    	 
    	 
    	 
         System.out.println("___________________________________");
    	     System.out.println("Subject : " + tempFach.getFachName());
	     if (tempFach.getAbsenceObjects().size()> 0){
    	     System.out.println("Absenzen/Verspätungen:");
	         AusgabeAllerNoten(tempFach.getAbsenceObjects());      
	     }
	         System.out.println("AbsenceOverview");
	         System.out.println("[Status: " + tempFach.checkIfMaxAbsenceReached()+ "] - [Absenzen übrig: " + tempFach.getHowManyLessonsPuffer() + "] - [oder Verspätungen übrig: " + tempFach.getHowManyDelaysPuffer()+"]");
	     
	     
	     System.out.println("___________________________________"); 


     }
     

     public static void FAbsenzProFachSetzenDe(Subject tempFach) {
    
    	 tempFach.setLessonAbsence("20161010", "Krank", 1);
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");

    	 
     }
     
     public static void FAbsenzProFachSetzenFr(Subject tempFach) {
    	    
    	 tempFach.setLessonAbsence("20161010", "Krank", 2);
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");
    	 tempFach.setLessonAbsence("20161010", "Krank", 2);  
   
    	 
     }
     
     public static void FAbsenzProFachSetzenEn(Subject tempFach) {
 	    
    	 tempFach.setLessonAbsence("20161010", "Krank", 2);
    	 tempFach.setLessonAbsence("20161010", "Krank", 2);    	 
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");
    	 tempFach.setDelayAbsence("20161010", "zug verspätung");
    	 tempFach.setLessonAbsence("20161010", "Krank", 2);     	 
    	 tempFach.setLessonAbsence("20161010", "Krank", 1);   
     }
   




      
      

}
