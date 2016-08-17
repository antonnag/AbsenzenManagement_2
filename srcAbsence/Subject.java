import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class Subject{

	int counterDelays;
	int counterLessons;
	int maxAbsence;
	int havingAbsences;
	
	String fachName;
   
    private List<Absence> absenceList = new ArrayList<Absence>();

	
	
	public Subject (String fachName , int numberOfLessonPer2Weeks){

		this.fachName = fachName;
		this.maxAbsence = numberOfLessonPer2Weeks;
	}
	
	public String getFachName() {
		return this.fachName;
	}

	public void setLessonAbsence(String datum, String reason, int numberOfH){
	   absenceList.add(new LessonAbsence(datum, reason, numberOfH));
	   counterLessons = counterLessons + numberOfH ;  
	}
	
	public void setDelayAbsence(String datum, String reason){
		absenceList.add(new DelayAbsence(datum, reason));
		counterDelays++;
	}
	
	
	public List<Absence> getAbsenceObjects(){
		return getSortedList(absenceList);
	}
	/*-------------------------------------*/
	

	public List<Absence> getLessonAbsenceObjects(){
	    List<Absence> LessonAbsenceList = new ArrayList<Absence>();
	
	    for (Absence element  : this.absenceList) {
			if(element instanceof LessonAbsence){
				LessonAbsenceList.add(element);	
			}
		}
	    
	    return getSortedList(LessonAbsenceList);
	}
	
	
	public List<Absence> getDelayAbsenceObjects(){
	    List<Absence> DelayAbsenceList = new ArrayList<Absence>();
	
	    for (Absence element  : this.absenceList) {
			if(element instanceof DelayAbsence){
				DelayAbsenceList.add(element);	
			}
		}
	    
	    return getSortedList(DelayAbsenceList);
	}
	
	
	public List<Absence> getSortedList(List<Absence> sortedList){
		 
	     Collections.sort(sortedList, Absence.AbsenceDateComparator);
		return sortedList;
	}

	
	public String checkIfMaxAbsenceReached(){
		String color = null;
	
		havingAbsences =  counterLessons + (counterDelays/3);
		if(havingAbsences == maxAbsence){
		  color = "orange";	
		}
		if(havingAbsences > maxAbsence){
		 color = "red";	
		}
		
		if(havingAbsences < maxAbsence){
		  color = "green";	
		}
		return color;
	}
	
	public int getHowManyLessonsPuffer(){
		return (maxAbsence - havingAbsences)/1;
	}
	
	public int getHowManyDelaysPuffer(){
		// 3 Delays = 1 Absence
		int convertedToDelays  = getHowManyLessonsPuffer() * 3;
		
		int DivisionWithoutRest = counterDelays/3;
		int delaysBalance = counterDelays - (DivisionWithoutRest*3);
		int delayBalancePuffer = convertedToDelays - delaysBalance;
       		
		return delayBalancePuffer;
	
	}
	

	
	

}
