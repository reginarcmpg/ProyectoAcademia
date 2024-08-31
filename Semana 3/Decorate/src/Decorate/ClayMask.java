package Decorate;

public class ClayMask extends ServiceDecorate {

    public ClayMask(Service serviceDecorate) {
        super(serviceDecorate);
        ExtraName = "Essential Oils";
        extraPrice = 45;
    }
}