/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MustainE
 */
public class TrackingDocu {
    public static final String SELECT_ALL="select t1.idDocutraza,t1.idEmpresa,t1.idCliente,t2.RazonSocial,t1.fecha,t1.Certificado,t1.nroguia,t1.NroContrato,t1.NroTrilla,t1.NroGuiaMcmNaki,\n" +
"t1.Factura,t1.Sacos,t1.kb,t1.kn,t1.PrimaFairtrade,t1.NotaCredito,t1.Tcs,t1.Condicion,t1.Estado from Docutraza t1\n" +
"inner join cliente t2\n" +
"on (t1.idCliente=t2.idCliente) where t1.idEmpresa='E0001' order by Fecha asc";
        public static final String SELECT_ALLIDEMPRESA="select t1.idDocutraza,t1.idEmpresa,t1.idCliente,t2.RazonSocial,t1.fecha,t1.Certificado,t1.nroguia,t1.NroContrato,t1.NroTrilla,t1.NroGuiaMcmNaki,\n" +
"t1.Factura,t1.Sacos,t1.kb,t1.kn,t1.PrimaFairtrade,t1.NotaCredito,t1.Tcs,t1.Condicion,t1.Estado from Docutraza t1\n" +
"inner join cliente t2\n" +
"on (t1.idCliente=t2.idCliente) where t1.idEmpresa=?";
   String iddocutraza;
   String idempresa;
   String idcliente;
   String razonsocial;
   String fecha;
   String certificado;
   String nroguia;
   String nrocontrato;
   String nrotrilla;
   String nroguiamcmnaki;
   String factura;
   int sacos;
   double kb;
   double kn;
   String primafairtrade;
   String notacredito;
   String tcs;
   String condicion;
   String estado;

   
    public TrackingDocu() {
    }

    public TrackingDocu(String iddocutraza, String idempresa, String idcliente, String razonsocial, String fecha, String certificado, String nroguia, String nrocontrato, String nrotrilla, String nroguiamcmnaki, String factura, int sacos, double kb, double kn, String primafairtrade, String notacredito, String tcs, String condicion, String estado) {
        this.iddocutraza = iddocutraza;
        this.idempresa = idempresa;
        this.idcliente = idcliente;
        this.razonsocial = razonsocial;
        this.fecha = fecha;
        this.certificado = certificado;
        this.nroguia = nroguia;
        this.nrocontrato = nrocontrato;
        this.nrotrilla = nrotrilla;
        this.nroguiamcmnaki = nroguiamcmnaki;
        this.factura = factura;
        this.sacos = sacos;
        this.kb = kb;
        this.kn = kn;
        this.primafairtrade = primafairtrade;
        this.notacredito = notacredito;
        this.tcs = tcs;
        this.condicion = condicion;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TrackingDocu{" + "iddocutraza=" + iddocutraza + ", idempresa=" + idempresa + ", idcliente=" + idcliente + ", razonsocial=" + razonsocial + ", fecha=" + fecha + ", certificado=" + certificado + ", nroguia=" + nroguia + ", nrocontrato=" + nrocontrato + ", nrotrilla=" + nrotrilla + ", nroguiamcmnaki=" + nroguiamcmnaki + ", factura=" + factura + ", sacos=" + sacos + ", kb=" + kb + ", kn=" + kn + ", primafairtrade=" + primafairtrade + ", notacredito=" + notacredito + ", tcs=" + tcs + ", condicion=" + condicion + ", estado=" + estado + '}';
    }
    
    

    public String getIddocutraza() {
        return iddocutraza;
    }

    public void setIddocutraza(String iddocutraza) {
        this.iddocutraza = iddocutraza;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getNroguia() {
        return nroguia;
    }

    public void setNroguia(String nroguia) {
        this.nroguia = nroguia;
    }

    public String getNrocontrato() {
        return nrocontrato;
    }

    public void setNrocontrato(String nrocontrato) {
        this.nrocontrato = nrocontrato;
    }

    public String getNrotrilla() {
        return nrotrilla;
    }

    public void setNrotrilla(String nrotrilla) {
        this.nrotrilla = nrotrilla;
    }

    public String getNroguiamcmnaki() {
        return nroguiamcmnaki;
    }

    public void setNroguiamcmnaki(String nroguiamcmnaki) {
        this.nroguiamcmnaki = nroguiamcmnaki;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getSacos() {
        return sacos;
    }

    public void setSacos(int sacos) {
        this.sacos = sacos;
    }

    public double getKb() {
        return kb;
    }

    public void setKb(double kb) {
        this.kb = kb;
    }

    public double getKn() {
        return kn;
    }

    public void setKn(double kn) {
        this.kn = kn;
    }

    public String getPrimafairtrade() {
        return primafairtrade;
    }

    public void setPrimafairtrade(String primafairtrade) {
        this.primafairtrade = primafairtrade;
    }

    public String getNotacredito() {
        return notacredito;
    }

    public void setNotacredito(String notacredito) {
        this.notacredito = notacredito;
    }

    public String getTcs() {
        return tcs;
    }

    public void setTcs(String tcs) {
        this.tcs = tcs;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
}
