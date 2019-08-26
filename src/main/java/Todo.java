public class Todo extends Task{

    public Todo(String description) throws DukeException {
        super(description);
            if (description.isBlank()) {
                throw new DukeException("☹ OOPS!!! The description of a todo task cannot be empty.");
            }
        }

    @Override
    public String toString() {
        return "[T]" + "[" + super.getStatusIcon() + "]" + this.description;
    }
}
