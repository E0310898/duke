 class Task {
    protected String description; // basically similar to describing features of the class
    protected boolean isDone;

    public Task(String description) { // constructor
        this.description = description;
        this.isDone = false;
    }

     public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

}