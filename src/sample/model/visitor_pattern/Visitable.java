package sample.model.visitor_pattern;

public interface Visitable {

    void accept(Visitor visitor);

    Integer getAvailability(Visitor visitor);

}
