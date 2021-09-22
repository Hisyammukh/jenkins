package Object;

public class VAObject {
    
    private String bankCode;
    private String externalID;
    private String name;

    public VAObject(){
        super();
    }
    public VAObject(String externalID, String bankCode, String name){
        this.externalID = externalID;
        this.bankCode = bankCode;
        this.name = name;

    }

    public String getExternalID(){
        return externalID;
    }

    public String getBankCode(){
        return bankCode;
    }

    public String getName(){
        return name;
    }
}