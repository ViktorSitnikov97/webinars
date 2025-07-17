package example1;

public class Example {
    private String example;
    private ExampleType type = ExampleType.CORRECT;
    public Example(String example) {
        this.example = example;
    }
    protected void printString() {
        System.out.println(example);
    }
    public ExampleType getType() {
        return type;
    }
    public void setType(ExampleType type) {
        this.type = type;
    }
    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Example{" +
                "example='" + example + '\'' +
                ", type=" + type +
                '}';
    }
}
