package polytech.si3.firstserver.client.builder.json;

public enum JSONEnum {

    /**
     * User authentification
     */
    AUTHENTIFICATION("user authentification", "user"),
    ADD("add idea","add [id] [name] [description] [technology]"),
    INTEREST("Send interest request","interest [id]"),
    LIST("ask for ideas list","list []"),
    JOIN("ask to join an idea","join [id]"),
    GETREQUEST("Print request as JSON","getjsonrequest []");

    private String descrition;
    private String manual;

    JSONEnum(String descrition, String manual) {
        this.manual = manual;
        this.descrition = descrition;
    }

    public String getDescrition() {
        return descrition;
    }

    public String getManual() {
        return manual;
    }
}
