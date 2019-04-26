/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttienda.bo.com.tiendaAbrigos.vista.prendas;

import com.aplicacionjava.www.botones.IUBotonIT;
import com.aplicacionjava.www.paneles.IUPanel;
import com.aplicacionjava.www.paneles.IUPanelBD;
import com.aplicacionjava.www.paneles.IUPanelCT;
import com.aplicacionjava.www.paneles.IUPanelCTU;
import com.aplicacionjava.www.paneles.IUPanelTA;
import com.aplicacionjava.www.paneles.IUPanelTCB;
import com.aplicacionjava.www.recursos.Limitacion;
import com.aplicacionjava.www.ventanas.IUVentanaT;
import fasttienda.bo.com.tiendaAbrigos.ayuda.Ayuda;
import fasttienda.bo.com.tiendaAbrigos.modelo.Modelo;
import fasttienda.bo.com.tiendaAbrigos.modelo.Unidad;
import fasttienda.bo.com.tiendaAbrigos.vista.inicio.IUPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author rudolf
 */
public class IUNuevoModelo extends IUVentanaT{
    
    private IUPrincipal ventanaPrincipal;
    private IUPanelBD primerPanelModelo;
    private IUPanelTCB categoria;
    private IUPanelCT marca;
    private IUPanelCT detalle;
    private IUPanelTCB tipoColor;
    private IUPanelTA colores;
    private IUPanelTA tallas;
    private IUPanelCT tela;
    private IUPanelCT industria;
    private IUPanelCT temporada;
    private IUPanelTCB tipoMoneda;
    private IUPanelCT unidadMoneda;
    private IUPanelCTU costo;
    private IUPanelCTU iva;
    private IUPanelCTU costoIva;
    private IUPanelCTU margenUtilidad;
    private IUPanelCTU precioTope;
    private IUPanelCTU precioOficial;
    private IUPanelTCB tipoUnidad;
    
    private IUPanel segundoPanelModelo;
    private IUBotonIT botonGuardar;
    private IUBotonIT botonCancelar;
    
    private boolean estado;
    
    public IUNuevoModelo(IUPrincipal ventanaPrincipal, String titulo, Limitacion limitacion, int porcentajeAlturaTitulo) {
        super(ventanaPrincipal, titulo, limitacion, porcentajeAlturaTitulo);
        this.ventanaPrincipal = ventanaPrincipal;
        this.estado = false;
        construirPaneles(panelFondo.getLimitacion());    
        setEventos();
        
    }
    private void construirPaneles(Limitacion limite){
        primerPanelModelo = new IUPanelBD(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(1), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(90)));
        panelFondo.add(primerPanelModelo);
        construirPrimerPanelModelo(primerPanelModelo.getLimitacion());
        
        segundoPanelModelo = new IUPanel(new Limitacion(limite.getPorcentajeAncho(1), limite.getPorcentajeAlto(91), limite.getPorcentajeAncho(98), limite.getPorcentajeAlto(8)));
        panelFondo.add(segundoPanelModelo);        
        construirSegundoPanel(segundoPanelModelo.getLimitacion());
    }
    private void construirPrimerPanelModelo(Limitacion limite){
        String[] elementos = Ayuda.getColumnaTabla("categoria", "select distinct categoria from modelo");
        categoria = new IUPanelTCB("categoria de modelo", elementos, new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(categoria);
        
        marca = new IUPanelCT("marca del modelo", "", new Limitacion(limite.getPorcentajeAncho(50), limite.getPorcentajeAlto(5), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(marca);
        
        detalle = new IUPanelCT("detalle del modelo", "", new Limitacion(limite.getPorcentajeAncho(4), limite.getPorcentajeAlto(14), limite.getPorcentajeAncho(92), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(detalle);
        
        String[] tiposColores = Ayuda.getColumnaTabla("tipocolor", "select distinct tipocolor from modelo");
        tipoColor = new IUPanelTCB("tipo de colores", tiposColores, new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(23), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(tipoColor);
        
        colores = new IUPanelTA("colores (rojo, azul-verde, negro)", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(32), limite.getPorcentajeAncho(45), limite.getPorcentajeAlto(14)), 21, 79);
        colores.iuAreaTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(7)/4));
        primerPanelModelo.add(colores);
        
        tallas = new IUPanelTA("tallas (XL, 185/12-XL, 45)", "", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(32), limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(14)), 21, 79);
        tallas.iuAreaTexto.setFont(new Font("Verdana", Font.PLAIN, limite.getPorcentajeAlto(7)/4));
        primerPanelModelo.add(tallas);
        
        tela = new IUPanelCT("nombre de tela", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(tela);
        
        industria = new IUPanelCT("origen de industria", "", new Limitacion(limite.getPorcentajeAncho(40), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(industria);
        
        temporada = new IUPanelCT("temporada", "", new Limitacion(limite.getPorcentajeAncho(75), limite.getPorcentajeAlto(48), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(temporada);
        
        tipoMoneda = new IUPanelTCB("tipo de monedas", Ayuda.getMonedaOficial(), new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(tipoMoneda);
        
        unidadMoneda = new IUPanelCT("U/M", "", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(10), limite.getPorcentajeAlto(7)), 40, 60);
        unidadMoneda.iuTexto.setHorizontalAlignment(SwingConstants.CENTER);
        unidadMoneda.iuTexto.setEditable(false);
        unidadMoneda.iuTexto.setFocusable(false);
        primerPanelModelo.add(unidadMoneda);
        
        costo = new IUPanelCTU("costo unitario", "", "", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        costo.iuTexto.setPosicionHorizontalUnidad("izquierda");
        costo.iuTexto.setRestriccionNumeroDecimal();
        primerPanelModelo.add(costo);
        
        iva = new IUPanelCTU("I.V.A.", String.valueOf(Ayuda.getDatoDouble("IVA", "select IVA from impuesto")), "%", new Limitacion(limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(57), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 50);        
        iva.iuTexto.setRestriccionNumeroDecimal();
        iva.iuTexto.setPosicionHorizontalUnidad("izquierda");
        primerPanelModelo.add(iva);
        
        costoIva = new IUPanelCTU("costo I.V.A.", "", "", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        costoIva.iuTexto.setPosicionHorizontalUnidad("izquierda");
        costoIva.iuTexto.setEditable(false);
        costoIva.iuTexto.setFocusable(false);
        primerPanelModelo.add(costoIva);
        
        margenUtilidad = new IUPanelCTU("margen de utilidad", "", "%", new Limitacion(limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        margenUtilidad.iuTexto.setPosicionHorizontalUnidad("izquierda");
        margenUtilidad.iuTexto.setRestriccionNumeroEnteros();
        primerPanelModelo.add(margenUtilidad);
        
        precioTope = new IUPanelCTU("precio tope", "", "", new Limitacion(limite.getPorcentajeAncho(55), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(20), limite.getPorcentajeAlto(7)), 40, 60, 50);
        precioTope.iuTexto.setPosicionHorizontalUnidad("izquierda");
        precioTope.iuTexto.setEditable(false);
        precioTope.iuTexto.setFocusable(false);
        primerPanelModelo.add(precioTope);
        
        precioOficial = new IUPanelCTU("precio oficial", "", "", new Limitacion(limite.getPorcentajeAncho(80), limite.getPorcentajeAlto(66), limite.getPorcentajeAncho(15), limite.getPorcentajeAlto(7)), 40, 60, 50);
        precioOficial.iuTexto.setPosicionHorizontalUnidad("izquierda");
        precioOficial.iuTexto.setRestriccionNumeroDecimal();
        primerPanelModelo.add(precioOficial);
        
        String[] tipoUnidades = Ayuda.getUnidadesMedida();
        tipoUnidad = new IUPanelTCB("tipo de unidad", tipoUnidades, new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(75), limite.getPorcentajeAncho(30), limite.getPorcentajeAlto(7)), 40, 60);
        primerPanelModelo.add(tipoUnidad);
    }
    private void construirSegundoPanel(Limitacion limite){
        botonGuardar = new IUBotonIT("guardar nueva prenda", "src/imagenes/si.png", new Limitacion(limite.getPorcentajeAncho(60), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(34), limite.getPorcentajeAlto(90)));
        segundoPanelModelo.add(botonGuardar);
        
        botonCancelar = new IUBotonIT("salir del formulario", "src/imagenes/salir.png", new Limitacion(limite.getPorcentajeAncho(5), limite.getPorcentajeAlto(10), limite.getPorcentajeAncho(34), limite.getPorcentajeAlto(90)));
        segundoPanelModelo.add(botonCancelar);
    }
    public boolean getEstado(){
        return estado;
    }
    public Modelo getModelo(){        
        Modelo modelo = new Modelo(0);
        modelo.setCategoria(categoria.iuTexto.getTexto());
        modelo.setMarca(marca.iuTexto.getText());
        modelo.setDetalle(detalle.getTexto());
        modelo.setTipoColor(tipoColor.getTexto());
        modelo.setColores(colores.iuAreaTexto.getText());
        modelo.setTallas(tallas.iuAreaTexto.getText());
        modelo.setTela(tela.getTexto());
        modelo.setIndustria(industria.getTexto());
        modelo.setTemporada(temporada.getTexto());           
        modelo.setCostoUnitario(Double.valueOf(costo.getTexto()));        
        modelo.setCostoUnitarioIva(Double.valueOf(costoIva.getTexto()));
        modelo.setMargenUtilidad(Double.valueOf(margenUtilidad.getTexto()));
        modelo.setPrecioTope(Double.valueOf(precioTope.getTexto()));
        modelo.setPrecioOficial(Double.valueOf(precioOficial.getTexto()));
        modelo.setImpuestoID(Ayuda.getDatoInt("ImpuestoID", "select ImpuestoID from impuesto order by ImpuestoID desc limit 1"));
        modelo.generarImpuesto();      
        
        Unidad unidadMonetaria = new Unidad(0);
        unidadMonetaria.agregarIDUnidad(tipoMoneda.iuTexto.getTexto(), unidadMoneda.iuTexto.getText());
        modelo.getUnidades().add(unidadMonetaria);
        
        Unidad unidadMedida = new Unidad(0);
        unidadMedida.agregarIDUnidad(tipoUnidad.iuTexto.getTexto(), "");
        modelo.getUnidades().add(unidadMedida);

        return modelo;
    }
    public boolean camposCorrectos(){
        boolean verificador = false;
        if(!categoria.iuTexto.getTexto().isEmpty()){
            if(!marca.iuTexto.getText().isEmpty()){
                if(!detalle.iuTexto.getText().isEmpty()){
                    if(!tipoColor.iuTexto.getTexto().isEmpty()){
                        if(!colores.iuAreaTexto.getText().isEmpty()){
                            if(!tallas.iuAreaTexto.getText().isEmpty()){
                                if(!tela.iuTexto.getText().isEmpty()){
                                    if(!industria.iuTexto.getText().isEmpty()){
                                        if(!temporada.iuTexto.getText().isEmpty()){
                                            if(!tipoMoneda.iuTexto.getTexto().isEmpty()){
                                                if(!unidadMoneda.iuTexto.getText().isEmpty()){
                                                    if(!costo.iuTexto.getText().isEmpty()){
                                                        if(!iva.iuTexto.getText().isEmpty()){
                                                            if(!costoIva.iuTexto.getText().isEmpty()){
                                                                if(!margenUtilidad.iuTexto.getText().isEmpty()){
                                                                    if(!precioTope.iuTexto.getText().isEmpty()){
                                                                        if(!precioOficial.iuTexto.getText().isEmpty()){
                                                                            if(!tipoUnidad.iuTexto.getTexto().isEmpty()){
                                                                                verificador = true;
                                                                            }else
                                                                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TIPO UNIDAD...", "advertencia");                                                                            
                                                                        }else
                                                                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo PRECIO OFICIAL...", "advertencia");
                                                                    }else
                                                                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo PRECIO TOPE...", "advertencia");
                                                                }else
                                                                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo MARGEN DE UTILIDAD...", "advertencia");
                                                            }else
                                                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo COSTO IVA...", "advertencia");
                                                        }else
                                                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo IVA...", "advertencia");
                                                    }else
                                                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo COSTO...", "advertencia");
                                                }else
                                                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo UNIDAD DE MEDIDA...", "advertencia");
                                            }else
                                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TIPO DE MONEDA...", "advertencia");
                                        }else
                                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TEMPORADA...", "advertencia");
                                    }else
                                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo INDUSTRIA...", "advertencia");
                                }else
                                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TELA...", "advertencia");
                            }else
                                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TALLAS...", "advertencia");
                        }else
                            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo COLORES...", "advertencia");
                    }else
                        Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo TIPO DE COLOR...", "advertencia");
                }else
                    Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo DETALLE...", "advertencia");
            }else
                Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo MARCA...", "advertencia");
        }else
            Ayuda.mensajeVerificacion(ventanaPrincipal, this, "aviso", "lo siento.... pero no puede estar vacio el campo CATEGORIA...", "advertencia");
        return verificador;
    }
    public void setEventos(){
        botonGuardar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(camposCorrectos()){                    
                    estado = true;
                    dispose();
                }
            }
        });
        
        botonCancelar.addEventoRaton(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        
        tipoMoneda.iuTexto.addItemListener((ItemEvent e) -> {
            if(!tipoMoneda.getTexto().isEmpty()){
                switch(tipoMoneda.getTexto()){
                    case "Bolivianos":
                        unidadMoneda.iuTexto.setText("BOB.-");
                        costo.iuTexto.iuUnidad.setText("BOB.-");
                        costoIva.iuTexto.iuUnidad.setText("BOB.-");
                        precioTope.iuTexto.iuUnidad.setText("BOB.-");
                        precioOficial.iuTexto.iuUnidad.setText("BOB.-");                            
                        break;
                    case "Dolares":
                        unidadMoneda.iuTexto.setText("$US.-");
                        costo.iuTexto.iuUnidad.setText("$US.-");
                        costoIva.iuTexto.iuUnidad.setText("$US.-");
                        precioTope.iuTexto.iuUnidad.setText("$US.-");
                        precioOficial.iuTexto.iuUnidad.setText("$US.-");
                        break;
                }
            }
        });
        costo.iuTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!costo.iuTexto.getText().isEmpty()){
                        double impuestos = Double.parseDouble(iva.iuTexto.getText());
                        double costoUnitario = Double.parseDouble(costo.iuTexto.getText());
                        double costoUnitarioIva = costoUnitario + (impuestos*costoUnitario);
                        costoUnitarioIva = Ayuda.acotarNumero(costoUnitarioIva, 2);
                        costoIva.iuTexto.setText(String.valueOf(costoUnitarioIva));                        
                    }
                }
            }
        });
        iva.iuTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!costo.iuTexto.getText().isEmpty() && !iva.iuTexto.getText().isEmpty()){
                        double impuestos = Double.parseDouble(iva.iuTexto.getText());
                        double costoUnitario = Double.parseDouble(costo.iuTexto.getText());
                        double costoUnitarioIva = costoUnitario + (impuestos*costoUnitario);
                        costoUnitarioIva = Ayuda.acotarNumero(costoUnitarioIva, 2);
                        costoIva.iuTexto.setText(String.valueOf(costoUnitarioIva));                        
                    }                    
                }
            }
        });
        margenUtilidad.iuTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!margenUtilidad.iuTexto.getText().isEmpty() && !costoIva.iuTexto.getText().isEmpty()){
                        double costoIvaUnitario = Double.parseDouble(costoIva.iuTexto.getText());
                        double margen = Double.parseDouble(margenUtilidad.iuTexto.getText())/100;
                        double precio = 0;
                        if(margen < 1){
                            precio = costoIvaUnitario/(1-margen);
                        }else{                           
                            do {                                
                                margen = margen - 1;
                                if(margen >= 0 && margen < 1)
                                    precio = precio + costoIvaUnitario + costoIvaUnitario/(1-margen);
                                else
                                    precio = precio + costoIvaUnitario;
                            } while (margen >= 1);
                        }       
                        precio = Ayuda.acotarNumero(precio, 2);
                        precioTope.iuTexto.setText(String.valueOf(precio));
                        precioOficial.iuTexto.setText(String.valueOf(precio));
                    }                    
                }
            }
        });
        precioOficial.iuTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!precioOficial.iuTexto.getText().isEmpty()){
                        if(Double.valueOf(precioOficial.iuTexto.getText()) < Double.valueOf(precioTope.iuTexto.getText())){
                            categoria.iuTexto.transferFocusBackward();
                            precioOficial.iuTexto.setSelectedTextColor(new Color(120, 0, 0));
                        }else
                            precioOficial.iuTexto.setSelectedTextColor(new Color(2, 67, 109));
                    }else
                        precioOficial.iuTexto.transferFocusBackward();
                }
            }
        });        
    }    
}
