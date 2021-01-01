package retrieve.rabbit;

public class Rabbit {
    @Deprecated
    @RabbitAnnotation
    private String weight;



    @Deprecated

    private String name = ", the default value.";

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }
}
