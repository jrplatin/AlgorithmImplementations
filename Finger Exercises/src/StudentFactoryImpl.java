
public class StudentFactoryImpl implements StudentFactory {
	
	public StudentFactoryImpl () {
		
	}
    @Override
    public Student buildStudent(String name, int id) {
        // TODO: implement this
    	StudentImpl st = new StudentImpl(id, name);
        return st ;
    }

}
