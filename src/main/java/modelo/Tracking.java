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
public class Tracking {

    public static final String SELECT_ALL = "SELECT idempresa,idcp,idcafepractice,codagricultor,apeagricultor,nomagricultor,dniagricultor,nomfinca,nomanexo\n"
            + "      ,format(cpinicial, '#,##0.00') AS cpinicial\n"
            + "      ,format(orginicial, '#,##0.00') AS orginicial\n"
            + "      ,format(ftinicial, '#,##0.00') AS ftinicial\n"
            + "      ,format(rainfinicial, '#,##0.00') AS rainfinicial\n"
            + "      ,format(convinicial, '#,##0.00') AS convinicial\n"
            + "      ,format(cpavance, '#,##0.00') AS cpavance\n"
            + "      ,format(orgavance, '#,##0.00') AS orgavance\n"
            + "      ,format(ftavance, '#,##0.00') AS ftavance\n"
            + "      ,format(rainfavance, '#,##0.00') AS rainfavance\n"
            + "      ,format(convavance, '#,##0.00') AS convavance\n"
            + "      ,format(cpdisponible, '#,##0.00') AS cpdisponible\n"
            + "      ,format(orgdisponible, '#,##0.00') AS orgdisponible\n"
            + "      ,format(ftdisponible, '#,##0.00') AS ftdisponible\n"
            + "      ,format(rainfdisponible, '#,##0.00') AS rainfdisponible\n"
            + "      ,format(convdisponible, '#,##0.00') AS convdisponible\n"
            + "  FROM tracking where idempresa='E0001'";

    public static final String SELECT_FORMAT = "SELECT idempresa,idcp,idcafepractice,codagricultor,apeagricultor,nomagricultor,dniagricultor,nomfinca,nomanexo\n"
            + "      ,format(cpinicial, '#,##0.00')\n"
            + "      ,format(orginicial, '#,##0.00')\n"
            + "      ,format(ftinicial, '#,##0.00')\n"
            + "      ,format(rainfinicial, '#,##0.00')\n"
            + "      ,format(convinicial, '#,##0.00')\n"
            + "      ,format(cpavance, '#,##0.00')\n"
            + "      ,format(orgavance, '#,##0.00')\n"
            + "      ,format(ftavance, '#,##0.00')\n"
            + "      ,format(rainfavance, '#,##0.00')\n"
            + "      ,format(convavance, '#,##0.00')\n"
            + "      ,format(cpdisponible, '#,##0.00')\n"
            + "      ,format(orgdisponible, '#,##0.00')\n"
            + "      ,format(ftdisponible, '#,##0.00')\n"
            + "      ,format(rainfdisponible, '#,##0.00')\n"
            + "      ,format(convdisponible, '#,##0.00')\n"
            + "  FROM tracking WHERE idempresa=?";
    public static final String SELECT_BUSCAR = "SELECT idempresa,idorga,idcp,idcafepractice,codagricultor,apeagricultor,nomagricultor,dniagricultor,nomfinca,nomanexo\n" +
"      ,format(cpinicial, '#,##0.00') AS cpinicial\n" +
"      ,format(orginicial, '#,##0.00') AS orginicial\n" +
"      ,format(ftinicial, '#,##0.00') AS ftinicial\n" +
"      ,format(rainfinicial, '#,##0.00') AS rainfinicial\n" +
"      ,format(convinicial, '#,##0.00') AS convinicial\n" +
"      ,format(cpavance, '#,##0.00') AS cpavance\n" +
"      ,format(orgavance, '#,##0.00') AS orgavance\n" +
"      ,format(ftavance, '#,##0.00') AS ftavance\n" +
"      ,format(rainfavance, '#,##0.00') AS rainfavance\n" +
"      ,format(convavance, '#,##0.00') AS convavance\n" +
"      ,format(cpdisponible, '#,##0.00') AS cpdisponible\n" +
"      ,format(orgdisponible, '#,##0.00') AS orgdisponible\n" +
"      ,format(ftdisponible, '#,##0.00') AS ftdisponible\n" +
"      ,format(rainfdisponible, '#,##0.00') AS rainfdisponible\n" +
"      ,format(convdisponible, '#,##0.00') AS convdisponible\n" +
"  FROM tracking where codagricultor LIKE '%?%'";

    int idestimado;
    String idempresa;
    String idorga;
    String idcp;
    String idcafepractice;
    String codagri;
    String apeagri;
    String nomagri;
    String dniagri;
    String nomfinca;
    String nomanexo;
    String cpinicial;
    String orginicial;
    String ftinicial;
    String rainfinicial;
    String convinicial;
    String cpavance;
    String orgavance;
    String ftavance;
    String rainfavance;
    String convavance;
    String cpdisponible;
    String orgdisponible;
    String ftdisponible;
    String rainfdisponible;
    String convdisponible;

    public Tracking() {
    }

    public Tracking(String idempresa, String idcp, String idcafepractice, String codagri, String apeagri, String nomagri, String dniagri, String nomfinca, String nomanexo, String cpinicial, String orginicial, String ftinicial, String rainfinicial, String convinicial, String cpavance, String orgavance, String ftavance, String rainfavance, String convavance, String cpdisponible, String orgdisponible, String ftdisponible, String rainfdisponible, String convdisponible) {
        this.idempresa = idempresa;
        this.idcp = idcp;
        this.idcafepractice = idcafepractice;
        this.codagri = codagri;
        this.apeagri = apeagri;
        this.nomagri = nomagri;
        this.dniagri = dniagri;
        this.nomfinca = nomfinca;
        this.nomanexo = nomanexo;
        this.cpinicial = cpinicial;
        this.orginicial = orginicial;
        this.ftinicial = ftinicial;
        this.rainfinicial = rainfinicial;
        this.convinicial = convinicial;
        this.cpavance = cpavance;
        this.orgavance = orgavance;
        this.ftavance = ftavance;
        this.rainfavance = rainfavance;
        this.convavance = convavance;
        this.cpdisponible = cpdisponible;
        this.orgdisponible = orgdisponible;
        this.ftdisponible = ftdisponible;
        this.rainfdisponible = rainfdisponible;
        this.convdisponible = convdisponible;
    }

    public Tracking(int idestimado, String idempresa, String idorga, String idcp, String idcafepractice, String codagri, String apeagri, String nomagri, String dniagri, String nomfinca, String nomanexo, String cpinicial, String orginicial, String ftinicial, String rainfinicial, String convinicial, String cpavance, String orgavance, String ftavance, String rainfavance, String convavance, String cpdisponible, String orgdisponible, String ftdisponible, String rainfdisponible, String convdisponible) {
        this.idestimado = idestimado;
        this.idempresa = idempresa;
        this.idorga = idorga;
        this.idcp = idcp;
        this.idcafepractice = idcafepractice;
        this.codagri = codagri;
        this.apeagri = apeagri;
        this.nomagri = nomagri;
        this.dniagri = dniagri;
        this.nomfinca = nomfinca;
        this.nomanexo = nomanexo;
        this.cpinicial = cpinicial;
        this.orginicial = orginicial;
        this.ftinicial = ftinicial;
        this.rainfinicial = rainfinicial;
        this.convinicial = convinicial;
        this.cpavance = cpavance;
        this.orgavance = orgavance;
        this.ftavance = ftavance;
        this.rainfavance = rainfavance;
        this.convavance = convavance;
        this.cpdisponible = cpdisponible;
        this.orgdisponible = orgdisponible;
        this.ftdisponible = ftdisponible;
        this.rainfdisponible = rainfdisponible;
        this.convdisponible = convdisponible;
    }

    public Tracking(String idempresa, String idorga, String idcp, String idcafepractice, String codagri, String apeagri, String nomagri, String dniagri, String nomfinca, String nomanexo, String cpinicial, String orginicial, String ftinicial, String rainfinicial, String convinicial, String cpavance, String orgavance, String ftavance, String rainfavance, String convavance, String cpdisponible, String orgdisponible, String ftdisponible, String rainfdisponible, String convdisponible) {
        this.idempresa = idempresa;
        this.idorga = idorga;
        this.idcp = idcp;
        this.idcafepractice = idcafepractice;
        this.codagri = codagri;
        this.apeagri = apeagri;
        this.nomagri = nomagri;
        this.dniagri = dniagri;
        this.nomfinca = nomfinca;
        this.nomanexo = nomanexo;
        this.cpinicial = cpinicial;
        this.orginicial = orginicial;
        this.ftinicial = ftinicial;
        this.rainfinicial = rainfinicial;
        this.convinicial = convinicial;
        this.cpavance = cpavance;
        this.orgavance = orgavance;
        this.ftavance = ftavance;
        this.rainfavance = rainfavance;
        this.convavance = convavance;
        this.cpdisponible = cpdisponible;
        this.orgdisponible = orgdisponible;
        this.ftdisponible = ftdisponible;
        this.rainfdisponible = rainfdisponible;
        this.convdisponible = convdisponible;
    }

    public Tracking(String cpdisponible, String orgdisponible, String ftdisponible, String rainfdisponible, String convdisponible) {
        this.cpdisponible = cpdisponible;
        this.orgdisponible = orgdisponible;
        this.ftdisponible = ftdisponible;
        this.rainfdisponible = rainfdisponible;
        this.convdisponible = convdisponible;
    }

    public int getIdestimado() {
        return idestimado;
    }

    public void setIdestimado(int idestimado) {
        this.idestimado = idestimado;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdorga() {
        return idorga;
    }

    public void setIdorga(String idorga) {
        this.idorga = idorga;
    }

    public String getIdcp() {
        return idcp;
    }

    public void setIdcp(String idcp) {
        this.idcp = idcp;
    }

    public String getIdcafepractice() {
        return idcafepractice;
    }

    public void setIdcafepractice(String idcafepractice) {
        this.idcafepractice = idcafepractice;
    }

    public String getCodagri() {
        return codagri;
    }

    public void setCodagri(String codagri) {
        this.codagri = codagri;
    }

    public String getApeagri() {
        return apeagri;
    }

    public void setApeagri(String apeagri) {
        this.apeagri = apeagri;
    }

    public String getNomagri() {
        return nomagri;
    }

    public void setNomagri(String nomagri) {
        this.nomagri = nomagri;
    }

    public String getDniagri() {
        return dniagri;
    }

    public void setDniagri(String dniagri) {
        this.dniagri = dniagri;
    }

    public String getNomfinca() {
        return nomfinca;
    }

    public void setNomfinca(String nomfinca) {
        this.nomfinca = nomfinca;
    }

    public String getNomanexo() {
        return nomanexo;
    }

    public void setNomanexo(String nomanexo) {
        this.nomanexo = nomanexo;
    }

    public String getCpinicial() {
        return cpinicial;
    }

    public void setCpinicial(String cpinicial) {
        this.cpinicial = cpinicial;
    }

    public String getOrginicial() {
        return orginicial;
    }

    public void setOrginicial(String orginicial) {
        this.orginicial = orginicial;
    }

    public String getFtinicial() {
        return ftinicial;
    }

    public void setFtinicial(String ftinicial) {
        this.ftinicial = ftinicial;
    }

    public String getRainfinicial() {
        return rainfinicial;
    }

    public void setRainfinicial(String rainfinicial) {
        this.rainfinicial = rainfinicial;
    }

    public String getConvinicial() {
        return convinicial;
    }

    public void setConvinicial(String convinicial) {
        this.convinicial = convinicial;
    }

    public String getCpavance() {
        return cpavance;
    }

    public void setCpavance(String cpavance) {
        this.cpavance = cpavance;
    }

    public String getOrgavance() {
        return orgavance;
    }

    public void setOrgavance(String orgavance) {
        this.orgavance = orgavance;
    }

    public String getFtavance() {
        return ftavance;
    }

    public void setFtavance(String ftavance) {
        this.ftavance = ftavance;
    }

    public String getRainfavance() {
        return rainfavance;
    }

    public void setRainfavance(String rainfavance) {
        this.rainfavance = rainfavance;
    }

    public String getConvavance() {
        return convavance;
    }

    public void setConvavance(String convavance) {
        this.convavance = convavance;
    }

    public String getCpdisponible() {
        return cpdisponible;
    }

    public void setCpdisponible(String cpdisponible) {
        this.cpdisponible = cpdisponible;
    }

    public String getOrgdisponible() {
        return orgdisponible;
    }

    public void setOrgdisponible(String orgdisponible) {
        this.orgdisponible = orgdisponible;
    }

    public String getFtdisponible() {
        return ftdisponible;
    }

    public void setFtdisponible(String ftdisponible) {
        this.ftdisponible = ftdisponible;
    }

    public String getRainfdisponible() {
        return rainfdisponible;
    }

    public void setRainfdisponible(String rainfdisponible) {
        this.rainfdisponible = rainfdisponible;
    }

    public String getConvdisponible() {
        return convdisponible;
    }

    public void setConvdisponible(String convdisponible) {
        this.convdisponible = convdisponible;
    }

}
