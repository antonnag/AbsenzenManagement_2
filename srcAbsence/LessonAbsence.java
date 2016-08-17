import java.util.Date;



public class LessonAbsence extends Absence {

	public LessonAbsence(String datum, String reason, int numberOfH) {

		super(datum, reason);
		super.numberOfH = numberOfH;
		super.typ = "A";
	}

	@Override
	int getNumbersOfH() {
		// TODO Auto-generated method stub
		return super.numberOfH;
	}
}
