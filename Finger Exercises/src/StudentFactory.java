
/**
 * Factory for {@link Student} instances. All implementors of this interface must have have a
 * public default no-args constructor.
 * <p/>
 * This factory allows callers to build your implementation of a {@link Student} without depending
 * on your actual concrete implementation class.
 *
 * @author eyeung
 */
public interface StudentFactory {

    /**
     * Builds a new {@link Student} instance with the specified name and id
     *
     * @param name a String representing a student's name (not necessarily unique)
     * @param id an int that uniquely identifies a student
     * @return a {@link Student} with this name and id
     */
    public Student buildStudent(String name, int id);

}
