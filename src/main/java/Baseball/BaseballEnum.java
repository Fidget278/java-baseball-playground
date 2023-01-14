package Baseball;

public enum BaseballEnum {
    Strike("Strike"),
    Ball("Ball"),
    Nothing("Nothing");

    private String name;

    BaseballEnum(String name) {
        this.name = name;
    }
}
