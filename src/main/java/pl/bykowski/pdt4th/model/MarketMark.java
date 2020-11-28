package pl.bykowski.pdt4th.model;

public enum MarketMark {
    ASTON_MARTIN(440),
    TESLA(441),
    JAGUAR(442),
    MASERATI(443),
    LAND_ROVER(444),
    ROLLS_ROYCE (445),
    TOYOTA(448),
    MERCEDES(449),
    BMW(452),
    BUGATTI(454),
    FORD(460),
    LINCOLN(464),
    CHEVROLET(467),
    CADILLAC(469),
    OPEL(471),
    MAZDA(473),
    HONDA(474),
    DODGE(476),
    CHRYSLER(477),
    NISSAN(478),
    INFINITI(480),
    VOLKSWAGEN(482),
    JEEP(483),
    VOLVO(485),
    FIAT(492),
    HYUNDAI(489),
    KIA(499),
    LAMBORGHINI(502),
    LEXUS(515),
    SUBARU(523),
    AUDI(582);

    private final Integer id;

    MarketMark(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
