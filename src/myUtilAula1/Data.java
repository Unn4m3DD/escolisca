package myUtilAula1;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    private int[] days = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public Data(int dia, int mes, int ano) throws Exception {
        dateValidation(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data(String data) throws Exception {
        data = data.replace("\n", "");
        String[] s_data = data.split("/");
        if(s_data.length != 3) throw new Exception();
        int dia = Integer.parseInt(s_data[0]);
        int mes = Integer.parseInt(s_data[1]);
        int ano = Integer.parseInt(s_data[2]);
        dateValidation(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    private void dateValidation(int dia, int mes, int ano) throws Exception {
        if (LeapYear(ano)) days[2] = 29;
        if (dia < 1 || dia > days[mes])
            throw new Exception();
        if (mes < 1 || mes > 12)
            throw new Exception();
        if (ano < 0)
            throw new Exception();
    }


    public static boolean LeapYear(int theYear) {
        if (theYear % 4 == 0) {
            if (theYear % 100 != 0 || theYear % 400 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean equals(Data d) {
        return this.ano == d.ano && this.dia == d.dia && this.mes == d.mes;
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
}