package Decorate;

public class HotStone extends ServiceDecorate {

    public HotStone(Service serviceDecorate) {
        super(serviceDecorate);
        ExtraName = "Essential Oils";
        extraPrice = 50;
    }
}