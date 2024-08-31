package Decorate;

public class EssentialOils extends ServiceDecorate {

    public EssentialOils(Service serviceDecorate) {
        super(serviceDecorate);
        ExtraName = "Essential Oils";
        extraPrice = 135;
    }
}

