
/**
 * An implementation of the Student interface.
 */
public class StudentImpl implements Student {

	private String sName;
	private int sId;

	
	public StudentImpl (int sId, String sName) {
		this.sId = sId;
		this.sName = sName;
	}

    @Override
    public String getName() {
        // TODO: implement
        return sName;
    }

    @Override
    public int getStudentId() {
        // TODO: implement
        return sId;
    }

    @Override
    public int hashCode() {
        // TODO: implement
    	 int hash = 7;
    	 hash = 31 * hash + sId;     	
    	 return hash;
    }

    @Override
    public boolean equals(Object obj) {
       if(this == obj) {
    	   return true;
       }
       if (obj == null) {
    	   return false; 
       }
       if(getClass() != obj.getClass()) {
    	   return false;
       }
       StudentImpl student = (StudentImpl) obj;
       if(student.getStudentId() != sId) {
    	   return false;
       }
       return true; 
       
    }
}