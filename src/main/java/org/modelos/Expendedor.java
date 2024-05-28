package org.modelos;

import java.util.ArrayList;

public class Expendedor {
    private Deposito <Producto> coca;
    private Deposito <Producto> sprite;
    private Deposito <Producto> fanta;
    private Deposito <Producto> snickers;
    private Deposito <Producto> super8;
    private ArrayList <Deposito<Producto>> depositos;
    private int c = 100;

    private Deposito<Moneda> monedaVuelto;
    private Producto producto; //Será el producto que se retornará

    public Expendedor(int size){
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        depositos = new ArrayList<>();

        depositos.add(coca);
        depositos.add(sprite);
        depositos.add(fanta);
        depositos.add(snickers);
        depositos.add(super8);

        monedaVuelto = new Deposito<>();
        for(Selector p : Selector.values()){
            for(int i = 0; i < size; i++){
                Producto producto = p.crearProducto(i+c);
                depositos.get(p.ordinal()).addObjeto(producto);
            }
            c+= 100;
        }
    }

    public void comprarProducto (Moneda pago, Selector eleccion) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException{
        int i = eleccion.ordinal();
        if(pago == null){
            throw new PagoIncorrectoException("El pago es incorrecto.");
        }
        if(pago.getValor() < eleccion.getprecio()){
            monedaVuelto.addObjeto(pago);
            throw new PagoInsuficienteException("El pago es insuficiente.");
        }
        if(depositos.get(eleccion.ordinal()).isEmpty()){
            monedaVuelto.addObjeto(pago);
            throw new NoHayProductoException("No hay producto." + eleccion.toString().toLowerCase());
        }
        int vuelto = (pago.getValor() - eleccion.getprecio())/100;
        for(int j = 0; j < vuelto; j++){
            monedaVuelto.addObjeto(new Moneda100(j+1));
        }
        producto = depositos.get(i).getObjeto();
    }

    public Producto getProducto() {
        return producto;
    }

    public Moneda getVuelto() {
        Moneda m = monedaVuelto.getObjeto();
        return m;
    }
}
