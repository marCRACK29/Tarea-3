package org.modelos;

/**
 * Moneda que representa una moneda de valor 500
 */
class Moneda500 extends Moneda{

    public Moneda500(int serie){
        super(serie);
    }

    /**
     *
     * @return Retorna un valor de 500
     */
    public int getValor() {
        return 500;
    }

}
